package com.luv2code.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoUtilsTest {


	@Test
	void testEqualsAndNotEquals() {

		// set up
		DemoUtils demoUtils = new DemoUtils();

		int expected = 6;
		int unexpected = 8;

		// execute
		int actual = demoUtils.add(2, 4);

		// assert
		assertEquals(expected, actual, "2+4 must be 6");
		assertNotEquals(unexpected, actual, "2+4 must not be 8");

		expected = 10;

		actual = demoUtils.add(8, 2);

		assertEquals(expected, actual, "8+2 must be 10");
	}

	@Test
	void testNullAndNotNull() {

		DemoUtils demoUtils = new DemoUtils();

		String str1 = null;
		String str2 = "luv2code";

		assertNull(demoUtils.checkNull(str1), "Objeto debería ser null");
		assertNotNull(demoUtils.checkNull(str1), "Object should not be null");

	}

}
