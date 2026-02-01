package com.epam.jmp.impl;

import com.epam.jmp.dto.*;
import com.epam.jmp.service.bank.Bank;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;

public class BankImpl implements Bank {

    @FunctionalInterface
    interface BankCardFactory {
        BankCard create(String number, User user);
    }

    private final Map<BankCardType, BankCardFactory> cardFactories = Map.of(
            BankCardType.CREDIT, (number, user) -> new CreditBankCard(number, user, 1000.0),
            BankCardType.DEBIT, (number, user) -> new DebitBankCard(number, user, 0.0)
    );

    private final Map<BankCardType, BiFunction<User, String, BankCard>> strictFactories = Map.of(
            BankCardType.CREDIT, this::createCredit,
            BankCardType.DEBIT, this::createDebit
    );

    private BankCard createCredit(User user, String number) {
        return new CreditBankCard(number, user, 1000.0);
    }

    private BankCard createDebit(User user, String number) {
        return new DebitBankCard(number, user, 0.0);
    }

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        return strictFactories.get(cardType).apply(user, UUID.randomUUID().toString());
    }
}