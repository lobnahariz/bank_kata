package org.sg.bankkata.models;

import java.util.ArrayList;
import java.util.List;

public class Transactions {

	private final List<Transaction> transactions;

	public Transactions() {
		this.transactions = new ArrayList<>();
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
}
