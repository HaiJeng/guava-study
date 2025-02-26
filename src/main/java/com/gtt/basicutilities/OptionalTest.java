package com.gtt.basicutilities;

import com.google.common.base.Optional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tiantiangao
 */
public class OptionalTest {

	@Test
	public void test() {
		testNotNullValue();
		testNullValue();
	}

	private void testNotNullValue() {
		Optional<Integer> possible = Optional.fromNullable(6);
		assertTrue(possible.isPresent());
		assertEquals(6, possible.get().intValue());
		assertEquals(6, possible.or(1).intValue());
		assertEquals(6, possible.orNull().intValue());
	}

	private void testNullValue() {
		Optional<Integer> absent = Optional.fromNullable(null);
		assertFalse(absent.isPresent());
		try {
			absent.get();
			fail();
		} catch (IllegalStateException e) {
			assertTrue(true);
		}
		assertEquals(1, absent.or(1).intValue());
		assertNull(absent.orNull());
	}
}
