package com.sg.domain;

import java.time.LocalDateTime;

public class OperationWithdrawal extends Operation{

    private OperationWithdrawal(LocalDateTime operationDate, Amount amount) {
        super(operationDate, amount);
    }


    public static OperationWithdrawal from(LocalDateTime operationDate, Amount amount) {
       return new OperationWithdrawal(operationDate, amount);
    }
}
