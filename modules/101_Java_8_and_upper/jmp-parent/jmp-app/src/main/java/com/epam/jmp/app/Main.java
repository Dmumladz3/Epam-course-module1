package com.epam.jmp.app;

import com.epam.jmp.dto.*;
import com.epam.jmp.exception.SubscriptionNotFoundException;
import com.epam.jmp.impl.BankImpl;
import com.epam.jmp.service.impl.ServiceImpl;
import com.epam.jmp.service.bank.Bank;
import com.epam.jmp.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bank bank = new BankImpl();
        Service service = new ServiceImpl();

        User user = new User("John", "Doe", LocalDate.of(1990, 1, 1));

        BankCard card = bank.createBankCard(user, BankCardType.CREDIT);
        System.out.println("Card Created: " + card);

        service.subscribe(card);

        System.out.println("Is Payable: " + Service.isPayableUser(user));
        System.out.println("Average Age: " + service.getAverageUsersAge());
        var subscriptions = service.getAllSubscriptionsByCondition(
                s -> s.getBankcard().contains("1234") // Predicate
        );
        System.out.println("Matching Subscriptions: " + subscriptions);

        try {
            service.getSubscriptionByBankCardNumber("0000")
                    .orElseThrow(() -> new SubscriptionNotFoundException("Subscription not found"));
        } catch (SubscriptionNotFoundException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
    }
}