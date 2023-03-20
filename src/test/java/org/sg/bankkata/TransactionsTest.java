package org.sg.bankkata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.sg.bankkata.models.Money;
import org.sg.bankkata.models.Transaction;
import org.sg.bankkata.models.Transactions;

public class TransactionsTest {

    @Test
    public void testAddTransaction() {
        Transactions transactions = new Transactions();
        Transaction transaction1 = new Transaction(new Money(100), new Money(100));
        Transaction transaction2 = new Transaction(new Money(-50), new Money(50));

        transactions.addTransaction(transaction1);
        transactions.addTransaction(transaction2);

        assertEquals(2, transactions.getTransactions().size());
        assertEquals(transaction1, transactions.getTransactions().get(0));
        assertEquals(transaction2, transactions.getTransactions().get(1));
    }

    @Test
    public void testGetTransactions() {
        Transactions transactions = new Transactions();
        assertTrue(transactions.getTransactions().isEmpty());

        Transaction transaction1 = new Transaction(new Money(100), new Money(100));
        transactions.addTransaction(transaction1);
        assertEquals(1, transactions.getTransactions().size());
        assertEquals(transaction1, transactions.getTransactions().get(0));

        Transaction transaction2 = new Transaction(new Money(-50), new Money(50));
        transactions.addTransaction(transaction2);
        assertEquals(2, transactions.getTransactions().size());
        assertEquals(transaction2, transactions.getTransactions().get(1));
    }
}
