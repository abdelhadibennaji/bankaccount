package com.sg.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void doNothing() {

    }

    @Test
    public void shouldSaveMoneyWhenMakeADepositInAccount() {
        Amount amount = Amount.from(new BigDecimal(100));
        Balance balance = Balance.from(amount);
        Account account = Account.from(balance, new ArrayList<Operation>());
        Amount newAmount = Amount.from(new BigDecimal(50));
        OperationDeposit operationDeposit = OperationDeposit.from(LocalDateTime.now(), newAmount);
        account = account.deposit(operationDeposit);
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(150)));
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    public void shouldMakeWithdrawalWhenWhenRetrieveMoneyAndThereIsEnoughMoney() {
        Amount amount = Amount.from(new BigDecimal(100));
        Balance balance = Balance.from(amount);
        Account account = Account.from(balance, new ArrayList<Operation>());
        Amount newAmount = Amount.from(new BigDecimal(50));
        OperationWithdrawal operationWithdrawal = OperationWithdrawal.from(LocalDateTime.now(), newAmount);
        account = account.withdrawal(operationWithdrawal);
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(50)));
        assertEquals(expectedBalance, account.getBalance());
    }


    @Test(expected = NegativeBalanceException.class)
    public void shouldNotMakeWithdrawalWhenRetrieveMoneyAndThereIsNotEnoughMoney() {
        Amount amount = Amount.from(new BigDecimal(100));
        Balance balance = Balance.from(amount);
        Account account = Account.from(balance, new ArrayList<Operation>());
        Amount newAmount = Amount.from(new BigDecimal(150));
        OperationWithdrawal operationWithdrawal = OperationWithdrawal.from(LocalDateTime.now(), newAmount);
        account = account.withdrawal(operationWithdrawal);
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(100)));
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    public void shouldSeeHistoryOfMyOperation() {
        Amount amount = Amount.from(new BigDecimal(100));
        Balance balance = Balance.from(amount);
        Account account = Account.from(balance, new ArrayList<Operation>());

        Amount newAmount = Amount.from(new BigDecimal(150));
        OperationDeposit operationDeposit1 = OperationDeposit.from(LocalDateTime.now(), newAmount);
        account = account.deposit(operationDeposit1);

        Amount newAmount2 = Amount.from(new BigDecimal(50));
        OperationWithdrawal operationWithdrawal1 = OperationWithdrawal.from(LocalDateTime.now(), newAmount2);
        account = account.withdrawal(operationWithdrawal1);

        
    }
}
