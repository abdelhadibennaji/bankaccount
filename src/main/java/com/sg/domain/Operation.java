package com.sg.domain;

import java.time.LocalDateTime;

public class Operation {

    private Amount amount;

    private LocalDateTime operationDate;

    public Operation(LocalDateTime operationDate, Amount amount) {
        this.operationDate = operationDate;
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }
}
