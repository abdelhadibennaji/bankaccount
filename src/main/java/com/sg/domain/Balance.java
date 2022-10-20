package com.sg.domain;

import java.util.Objects;

public class Balance {

    private Amount amount;

    private Balance(Amount amount) {
        this.amount= amount;
    }

    public static Balance from(Amount amount) {
        return new Balance(amount);
    }

    public Balance addAmount(Amount amount) {
        Amount amount1 = this.amount.Add(amount);
        return from(amount1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Balance balance = (Balance) o;

        return Objects.equals(amount, balance.amount);
    }

    @Override
    public int hashCode() {
        return amount != null ? amount.hashCode() : 0;
    }
}
