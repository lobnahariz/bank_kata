package org.sg.bankkata;

import java.math.BigDecimal;

import org.sg.bankkata.exception.InsufficientFundsException;
import org.sg.bankkata.models.Account;
import org.sg.bankkata.models.AccountNumber;
import org.sg.bankkata.models.Money;

public class App 
{
    public static void main( String[] args ) throws InsufficientFundsException
    {
    	  // Create a new account with initial balance of 1000
        Account account = new Account(new Money(new BigDecimal("1000")));

        // Make some deposits and withdrawals
        account.deposit(new Money(new BigDecimal("500")));
        account.withdraw(new Money(new BigDecimal("200")));
        account.deposit(new Money(new BigDecimal("1000")));

        // Print account balance and transaction history
        System.out.println("Account balance: " + account.getBalance());
        System.out.println("Transaction history:\n" + account.printHistory());
    }
}
