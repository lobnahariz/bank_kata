package org.sg.bankkata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.sg.bankkata.models.Money;
import org.sg.bankkata.models.Transaction;

public class TransactionTest {
    
    @Test
    public void testGetAmount() {
        Money amount = new Money(100);
        Money balance = new Money(500);
        Transaction transaction = new Transaction(amount, balance);
        assertEquals(amount, transaction.getAmount());
    }

    @Test
    public void testGetBalance() {
        Money amount = new Money(100);
        Money balance = new Money(500);
        Transaction transaction = new Transaction(amount, balance);
        assertEquals(balance, transaction.getBalance());
    }

    @Test
    public void testGetDate() {
        Money amount = new Money(100);
        Money balance = new Money(500);
        Transaction transaction = new Transaction(amount, balance);
        assertNotNull(transaction.getDate());
    }

}

