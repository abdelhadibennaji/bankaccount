package com.sg.domain;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void doNothing() {

    }

    @Test
    public void shouldSaveMoneyWhenMakeADepositInAccount() {
        Amount amount = Amount.from(new BigDecimal(100));
        Balance balance = Balance.from(amount);
        Account account = Account.from(balance);
        Amount newAmount = Amount.from(new BigDecimal(50));
        account = account.deposit(newAmount);
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(150)));
        assertEquals(expectedBalance, account.getBalance());
    }

    @Test
    public void shouldMakeWithdrawalWhenWhenRetrieveMoneyAndThereIsEnoughMoney() {
        Amount amount = Amount.from(new BigDecimal(100));
        Balance balance = Balance.from(amount);
        Account account = Account.from(balance);
        Amount newAmount = Amount.from(new BigDecimal(50));
        account = account.withdrawal(newAmount);
        Balance expectedBalance = Balance.from(Amount.from(new BigDecimal(50)));
        assertEquals(expectedBalance, account.getBalance());
    }


}
