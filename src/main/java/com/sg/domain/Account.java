package com.sg.domain;

public class Account {

    private Balance balance;

    private Account(Balance balance) {
        this.balance = balance;
    }

    public static Account from(Balance balance) {
        return new Account(balance);
    }

    public Account deposit(Amount amount) {
        Balance balance = this.balance.addAmount(amount);
        return from(balance);
    }

    public Balance getBalance() {
        return balance;
    }

    public Account withdrawal(Amount amount) {
        Balance balance = this.balance.subtract(amount);
        return from(balance);
    }
}
