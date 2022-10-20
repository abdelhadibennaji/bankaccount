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

    public static Account from(Balance balance, ArrayList<Operation> operations) {
        return new Account(balance, operations);
    }


    public Account deposit(OperationDeposit operationDeposit) {
        Balance balance = this.balance.addAmount(operationDeposit.getAmount());
        return from(balance, new ArrayList<Operation>());
    }

    public Account withdrawal(Amount amount) {
        Balance balance = this.balance.subtract(amount);
        return from(balance, new ArrayList<Operation>());
    }

    public Balance getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
