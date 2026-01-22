package com.epam.jmp.impl;

import com.epam.jmp.dto.*;
import com.epam.jmp.service.bank.Bank;
import junit.framework.TestCase;
import java.time.LocalDate;

public class BankImplTest extends TestCase {

    private Bank bank;
    private User user;

    public void setUp() {
        bank = new BankImpl();
        user = new User("Test", "User", LocalDate.now());
    }

    public void testCreateCreditCard() {
        BankCard card = bank.createBankCard(user, BankCardType.CREDIT);
        assertNotNull(card);
        assertTrue(card instanceof CreditBankCard);
        assertEquals(user, card.getUser());
        assertEquals(1000.0, ((CreditBankCard) card).getCreditLimit());
    }

    public void testCreateDebitCard() {
        BankCard card = bank.createBankCard(user, BankCardType.DEBIT);
        assertNotNull(card);
        assertTrue(card instanceof DebitBankCard);
        assertEquals(user, card.getUser());
        assertEquals(0.0, ((DebitBankCard) card).getBalance());
    }
}