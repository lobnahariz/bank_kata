package org.sg.bankkata.models;

import java.math.BigDecimal;

public class Money {

	public static final Money ZERO = new Money(0);
	private final BigDecimal amount;

	public Money(double amount) {
		this.amount = BigDecimal.valueOf(amount);
	}

	public Money(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Money add(Money other) {
		return new Money(amount.add(other.getAmount()));
	}

	public Money subtract(Money other) {
		return new Money(amount.subtract(other.getAmount()));
	}

	public boolean lessThan(Money other) {
		return amount.compareTo(other.getAmount()) < 0;
	}

	public Money abs() {
		return new Money(amount.abs());
	}

	public Money negate() {
		return new Money(amount.negate());
	}

	@Override
	public String toString() {
		return amount.toString();
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Money money = (Money) o;
		return Double.compare(money.amount.intValue(), amount.intValue()) == 0;
	}
}
