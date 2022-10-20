package com.sg.domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    @Test
    public void doNothing() {

    }

    @Before
    public void init() {
        Amount amount = Amount.from(new BigDecimal(100));
        Balance balance = Balance.from(amount);
        account = Account.from(balance, new ArrayList<>());
    }

    @Test
    public void shouldSaveMoneyWhenMakeADepositInAccount() {
        Amount amountToDeposit = Amount.from(new BigDecimal(50));
        OperationDeposit operationDeposit = OperationDeposit.from(LocalDateTime.now(), amountToDeposit);
        account = account.deposit(operationDeposit);
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(150)));
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    public void shouldMakeWithdrawalWhenWhenRetrieveMoneyAndThereIsEnoughMoney() {
        Amount amountToWithdrawal = Amount.from(new BigDecimal(50));
        OperationWithdrawal operationWithdrawal = OperationWithdrawal.from(LocalDateTime.now(), amountToWithdrawal);
        account = account.withdrawal(operationWithdrawal);
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(50)));
        assertEquals(expectedBalance, account.getBalance());
    }


    @Test(expected = NegativeBalanceException.class)
    public void shouldNotMakeWithdrawalWhenRetrieveMoneyAndThereIsNotEnoughMoney() {
        Amount amountToWithdrawal = Amount.from(new BigDecimal(150));
        OperationWithdrawal operationWithdrawal = OperationWithdrawal.from(LocalDateTime.now(), amountToWithdrawal);
        account = account.withdrawal(operationWithdrawal);
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(100)));
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    public void shouldSeeHistoryOfMyOperation() {
        Amount amountToDeposit1 = Amount.from(new BigDecimal(150));
        OperationDeposit operationDeposit1 = OperationDeposit.from(LocalDateTime.now(), amountToDeposit1);
        account = account.deposit(operationDeposit1);

        Amount amountToWithdrawal1 = Amount.from(new BigDecimal(50));
        OperationWithdrawal operationWithdrawal1 = OperationWithdrawal.from(LocalDateTime.now(), amountToWithdrawal1);
        account = account.withdrawal(operationWithdrawal1);

        Amount amountToDeposit2 = Amount.from(new BigDecimal(100));
        OperationDeposit operationDeposit2 = OperationDeposit.from(LocalDateTime.now(), amountToDeposit2);
        account = account.deposit(operationDeposit2);

        Amount amountToWithdrawal2 = Amount.from(new BigDecimal(80));
        OperationWithdrawal operationWithdrawal2 = OperationWithdrawal.from(LocalDateTime.now(), amountToWithdrawal2);
        account = account.withdrawal(operationWithdrawal2);

        assertEquals(4, account.getOperations().size());
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(220)));
        assertEquals(expectedBalance, account.getBalance());
        assertEquals(operationDeposit1, account.getOperations().get(0));
        assertEquals(operationWithdrawal1, account.getOperations().get(1));
        assertEquals(operationDeposit2, account.getOperations().get(2));
        assertEquals(operationWithdrawal2, account.getOperations().get(3));
    }
}
