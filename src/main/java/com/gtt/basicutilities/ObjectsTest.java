package com.gtt.basicutilities;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * @author tiantiangao
 */
public class ObjectsTest {

	@Test
	public void test() {
		testEquals();
		testHashCode();
		testToString();
		testCompare();
	}

	private void testEquals() {
		assertTrue(Objects.equal("a", "a"));
		assertFalse(Objects.equal("a", null));
		assertFalse(Objects.equal(null, "a"));
		assertTrue(Objects.equal(null, null));
	}

	private void testHashCode() {
		assertNotSame(Objects.hashCode("a", "b", "c"), Objects.hashCode("c", "b", "a"));
	}

	private void testToString() {
		assertEquals("Object{name=test, age=18}",
				MoreObjects.toStringHelper(Object.class).add("name", "test").add("age", 18).toString());
	}

	private void testCompare() {
		assertEquals(-1, Ints.compare(1, 2));
		assertEquals(1, Ints.compare(2, 1));
		assertEquals(0, Ints.compare(1, 1));

		assertEquals(1, ComparisonChain.start().compare(1, 1).compare("aString", "aString").compare(true, false).result());
	}
}
