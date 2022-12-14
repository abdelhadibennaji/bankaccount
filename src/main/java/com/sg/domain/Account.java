package com.sg.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private Balance balance;

    private List<Operation> operations;

    private Account(Balance balance, List<Operation> operations) {
        this.balance = balance;
        this.operations = operations;
    }

    public static Account from(Balance balance, List<Operation> operations) {
        return new Account(balance, operations);
    }


    public Account deposit(OperationDeposit operationDeposit) {
        Balance balance = this.balance.addAmount(operationDeposit.getAmount());
        return from(balance, addOperation(operationDeposit));
    }

    public Account withdrawal(OperationWithdrawal operationWithdrawal) {
        Balance balance = this.balance.subtract(operationWithdrawal.getAmount());
        return from(balance, addOperation(operationWithdrawal));
    }

    private List<Operation> addOperation(Operation operation) {
        List<Operation> operations = (List<Operation>) ((ArrayList)this.operations).clone();
        operations.add(operation);
        return operations;
    }

    public Balance getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
