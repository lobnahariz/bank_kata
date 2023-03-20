package org.sg.bankkata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.sg.bankkata.models.Money;

public class MoneyTest {

	@Test
	public void testAdd() {
		Money m1 = new Money(10);
		Money m2 = new Money(20);

		Money result = m1.add(m2);

		assertEquals(new Money(30), result);
	}

	@Test
	public void testSubtract() {
		Money m1 = new Money(30);
		Money m2 = new Money(20);

		Money result = m1.subtract(m2);

		assertEquals(new Money(10), result);
	}

	@Test
	public void testLessThan() {
		Money m1 = new Money(10);
		Money m2 = new Money(20);

		assertTrue(m1.lessThan(m2));
		assertFalse(m2.lessThan(m1));
	}

	@Test
	public void testAbs() {
		Money m1 = new Money(-10);

		Money result = m1.abs();

		assertEquals(new Money(10), result);
	}

	@Test
	public void testNegate() {
		Money m1 = new Money(10);

		Money result = m1.negate();

		assertEquals(new Money(-10), result);
	}

	@Test
	public void testEquals() {
		Money m1 = new Money(10);
		Money m2 = new Money(10);
		Money m3 = new Money(20);

		assertEquals(m1, m2);
		assertNotEquals(m1, m3);
	}

	@Test
	public void testToString() {
		Money m1 = new Money(10);

		String result = m1.toString();

		assertEquals("10.0", result);
	}
}
