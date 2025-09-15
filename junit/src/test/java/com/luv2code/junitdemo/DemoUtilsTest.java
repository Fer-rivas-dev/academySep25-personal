package com.luv2code.junitdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DemoUtilsTest {
	
	@Test
	void testEqualsAndNotEquals(){
		
		// set up 
		DemoUtils demoUtils = new DemoUtils();
		
		int expected = 6;
		
		// execute 
		int actual = demoUtils.add(2, 4);
		
		// assert 
		Assertions.assertEquals(expected, actual, "2+4 must be 6");
		
		expected = 10;
		
		actual = demoUtils.add(8, 2);
		
		Assertions.assertEquals(expected, actual, "8+2 must be 10");
	}

}
