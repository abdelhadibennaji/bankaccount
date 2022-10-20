package com.sg.domain;

import java.time.LocalDateTime;

public class OperationDeposit extends Operation{

    private OperationDeposit(LocalDateTime operationDate, Amount amount) {
        super(operationDate, amount);
    }

    public static OperationDeposit from(LocalDateTime operationDate, Amount amount) {
        return new OperationDeposit(operationDate, amount);
    }
}
