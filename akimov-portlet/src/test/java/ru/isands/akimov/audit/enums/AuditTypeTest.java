package ru.isands.akimov.audit.enums;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * @author akimov
 * created at 23.01.20 17:18
 */
public class AuditTypeTest {

	private static final int MAX_DB_COLUMN_LENGTH = 75;

	@Test
	public void testEnumNameLength() {
		for (AuditType value : AuditType.values()) {
			if (value.toString().length() > MAX_DB_COLUMN_LENGTH) {
				fail(String.format("%s is too long for database column", value.toString()));
			}
		}
	}

}