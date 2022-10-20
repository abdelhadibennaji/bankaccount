package com.sg.domain;

public class Balance {

    private Amount amount;

    private Balance(Amount amount) {
        this.amount= amount;
    }

    public static Balance from(Amount amount) {
        return new Balance(amount);
    }
}
