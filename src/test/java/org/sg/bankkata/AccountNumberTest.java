package org.sg.bankkata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.sg.bankkata.models.AccountNumber;

public class AccountNumberTest {

	@Test
	void testGetValue() {
		AccountNumber accountNumber = new AccountNumber("1234567890");
		assertEquals("1234567890", accountNumber.getValue());
	}

	@Test
	void testConstructor() {
		AccountNumber accountNumber = new AccountNumber("1234567890");
		assertNotNull(accountNumber);
	}
}
