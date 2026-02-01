package com.epam.jmp;

import com.epam.jmp.dto.*;
import com.epam.jmp.exception.SubscriptionNotFoundException;
import com.epam.jmp.service.Service;
import com.epam.jmp.service.impl.ServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.List;

import static junit.framework.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceImplTest {

    private ServiceImpl service;
    private User user;
    private BankCard card;

    @BeforeEach
    void setUp() {
        service = new ServiceImpl();
        user = new User("Test", "User", LocalDate.of(1990, 1, 1));
        card = new CreditBankCard("1234", user, 1000);
    }

    @Test
    void testSubscribeAndGetSubscription() {
        service.subscribe(card);

        var subscription = service.getSubscriptionByBankCardNumber("1234");

        assertTrue(subscription.isPresent());
        assertEquals("1234", subscription.get().getBankcard());
        assertEquals(LocalDate.now(), subscription.get().getStartDate());
    }

    @Test
    void testGetAllUsers() {
        service.subscribe(card);
        List<User> users = service.getAllUsers();

        assertFalse(users.isEmpty());
        assertEquals(user, users.get(0));
    }

    @Test
    void testGetAverageUsersAge() {
        service.subscribe(card);
        double averageAge = service.getAverageUsersAge();

        assertTrue(averageAge > 30);
    }

    @Test
    void testIsPayableUser() {
        boolean isPayable = Service.isPayableUser(user);
        assertTrue(isPayable);

        User child = new User("Child", "User", LocalDate.now());
        assertFalse(Service.isPayableUser(child));
    }

    @Test
    void testSubscriptionNotFoundException() {
        assertThrows(SubscriptionNotFoundException.class, () -> {
            service.getSubscriptionByBankCardNumber("9999")
                    .orElseThrow(() -> new SubscriptionNotFoundException("Not Found"));
        });
    }

    @Test
    void testGetAllSubscriptionsByCondition() {
        service.subscribe(card);

        var matching = service.getAllSubscriptionsByCondition(s -> s.getBankcard().equals("1234"));
        assertFalse(matching.isEmpty());
        assertEquals(1, matching.size());

        var nonMatching = service.getAllSubscriptionsByCondition(s -> s.getBankcard().equals("0000"));
        assertTrue(nonMatching.isEmpty());
    }
}