package com.sg.domain;

public class Account {

    private Balance balance;

    private Account(Balance balance) {
        this.balance = balance;
    }

    public static Account from(Balance balance) {
        return new Account(balance);
    }

    public Account deposit(Amount newAmount) {
        return null;
    }

    public Balance getBalance() {
        return balance;
    }
}
