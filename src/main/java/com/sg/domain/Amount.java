package com.sg.domain;

import java.math.BigDecimal;

public class Amount {

    private BigDecimal value;

    private Amount(BigDecimal value) {
        this.value = value;
    }

    public static Amount from(BigDecimal value) {
        return new Amount(value);
    }

}
