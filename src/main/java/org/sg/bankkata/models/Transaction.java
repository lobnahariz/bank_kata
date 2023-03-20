package org.sg.bankkata.models;

import java.time.LocalDate;

public class Transaction {

	private final Money amount;
	private final Money balance;

	public Transaction(Money amount, Money balance) {
		this.amount = amount;
		this.balance = balance;
	}

	public Money getAmount() {
		return amount;
	}

	public Money getBalance() {
		return balance;
	}

	public String getDate() {
		return LocalDate.now().toString();
	}

}
