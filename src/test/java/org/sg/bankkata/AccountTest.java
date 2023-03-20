package org.sg.bankkata;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sg.bankkata.exception.InsufficientFundsException;
import org.sg.bankkata.models.Account;
import org.sg.bankkata.models.Money;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(new Money(100.0));
    }

    @Test
    public void testCreateAccount() {
        Assertions.assertEquals(new Money(100.0), account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(new Money(50));
        Assertions.assertEquals(new Money(150), account.getBalance());
    }

    @Test
    public void testWithdraw() throws InsufficientFundsException {
        account.withdraw(new Money(50));
        Assertions.assertEquals(new Money(50), account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Assertions.assertThrows(InsufficientFundsException.class, () -> account.withdraw(new Money(150)));
    }

    @Test
    public void testPrintHistory() throws InsufficientFundsException {
        account.deposit(new Money(50));
        account.withdraw(new Money(25));
        account.deposit(new Money(75));

        String expectedHistory = "OPERATION | DATE       | AMOUNT | BALANCE\n" +
                "DEPOSIT    | " + LocalDate.now().toString() + " | 50.0 | 150.0\n" +
                "WITHDRAWAL | " + LocalDate.now().toString() + " | 25.0 | 125.0\n" +
                "DEPOSIT    | " + LocalDate.now().toString() + " | 75.0 | 200.0\n";

        Assertions.assertEquals(expectedHistory, account.printHistory());
    }
    
}
