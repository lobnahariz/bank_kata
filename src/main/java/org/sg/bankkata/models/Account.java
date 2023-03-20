package org.sg.bankkata.models;

import java.util.Collections;
import java.util.List;

import org.sg.bankkata.exception.InsufficientFundsException;

public class Account {

	private final Transactions transactions;
	private Money balance;

	public Account(Money balance) {
		this.balance = balance;
		this.transactions = new Transactions();
	}

	public Money getBalance() {
		return balance;
	}

	public void deposit(Money amount) {
		balance = balance.add(amount);
		addTransaction(amount);
	}

	public void withdraw(Money amount) throws InsufficientFundsException {
		if (balance.lessThan(amount)) {
			throw new InsufficientFundsException("Insufficient funds");
		}
		balance = balance.subtract(amount);
		addTransaction(amount.negate());
	}

	public List<Transaction> getTransactions() {
		return Collections.unmodifiableList(transactions.getTransactions());
	}

	public String printHistory() {
		StringBuilder sb = new StringBuilder();
		sb.append("OPERATION | DATE       | AMOUNT | BALANCE\n");

		for (Transaction transaction : transactions.getTransactions()) {
			sb.append(transaction.getAmount().lessThan(Money.ZERO) ? "WITHDRAWAL" : "DEPOSIT   ");
			sb.append(" | ");
			sb.append(transaction.getDate()).append(" | ");
			sb.append(transaction.getAmount().abs()).append(" | ");
			sb.append(transaction.getBalance()).append("\n");
		}

		return sb.toString();
	}

	private void addTransaction(Money amount) {
		Transaction transaction = new Transaction(amount, balance);
		transactions.addTransaction(transaction);
	}
}
