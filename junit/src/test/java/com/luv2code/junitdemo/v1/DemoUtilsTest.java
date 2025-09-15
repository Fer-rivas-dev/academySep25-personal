package com.luv2code.junitdemo.v1;

import com.luv2code.junitdemo.DemoUtils;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

public class DemoUtilsTest {
	
	@Test
	void testEqualsAndNotEquals(){
		
		// set up 
		DemoUtils demoUtils = new DemoUtils();
		
		int expected = 6;
		int unexpected = 8;
		
		// execute 
		int actual = demoUtils.add(2, 4);
		
		// assert 
		assertEquals(expected, actual, "2+4 must be 6");
		
		actual = demoUtils.add(1, 9);
		//                     8  , 10
		assertNotEquals(unexpected, actual, "1+9 must not be 8");
		
		expected = 10;
		
		actual = demoUtils.add(8, 2);
		
		assertEquals(expected, actual, "8+2 must be 10");
	}

}
