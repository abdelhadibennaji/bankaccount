package com.sg.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {

    private BigDecimal value;

    private Amount(BigDecimal value) {
        if(value.doubleValue()<0) throw new NegativeAmountException("Amount can not be negative");
        this.value = value;
    }

    public static Amount from(BigDecimal value) {
        return new Amount(value);
    }

    public Amount Add(Amount amount) {
        return from(this.value.add(amount.value));
    }

    public Amount subtract(Amount amount) {
        return from(this.value.subtract(amount.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return Objects.equals(value, amount.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
