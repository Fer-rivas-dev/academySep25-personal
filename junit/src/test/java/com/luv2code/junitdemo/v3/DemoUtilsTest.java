package com.luv2code.junitdemo.v3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.luv2code.junitdemo.DemoUtils;

public class DemoUtilsTest {

	DemoUtils demoUtils;

	@BeforeEach
	void setupBeforeEach() {
		demoUtils = new DemoUtils();
		System.out.println("@BeforeEach executes before the execution of each test method");
	}

	@AfterEach
	void tearDownAfterEach() {
		System.out.println("Running @AfterEach\n");
	}

	@BeforeAll
	static void setupBeforeEachClass() {
		System.out.println("@BeforeAll executes only once before all test methods execution in the class\n");
	}

	@AfterAll
	static void tearDownAfterAll() {
		System.out.println("@AfterAll executes only once after all test methods execution in the class");
	}

	@Test
	@DisplayName("Equals and Not Equals")
	void testEqualsAndNotEquals() {

		int expected = 6;
		int unexpected = 8;

		// execute
		int actual = demoUtils.add(2, 4);

		// assert
		assertEquals(expected, actual, "2+4 must be 6");
		assertNotEquals(unexpected, actual, "2+4 must not be 8");

		expected = 10;

		actual = demoUtils.add(8, 2);
		System.out.println("Running test: testEqualsAndNotEquals");

		assertEquals(expected, actual, "8+2 must be 10");
	}

	@Test
	@DisplayName("Null and Not Null")
	void testNullAndNotNull() {

		String str1 = null;
		String str2 = "luv2code";

		System.out.println("Running test: testNullAndNotNull");

		assertNull(demoUtils.checkNull(str1), "Objeto debería ser null");
		assertNotNull(demoUtils.checkNull(str2), "Object should not be null");

	}

	@DisplayName("Same and Not Same")
	@Test
	void testSameAndNotSame() {
		
		String str = "Luv2Code academy";

		assertSame(demoUtils.getAcademy(), 
				   demoUtils.getAcademyDuplicate(), 
				   "Objects should refer to same object");

		assertNotSame(str, 
					  demoUtils.getAcademy(),
					  "Objects not should refer to same object");
	}

}
