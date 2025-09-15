package com.luv2code.junitdemo.v4;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoUtilsTest {

	DemoUtils demoUtils;

	@BeforeEach
	void setupBeforeEach() {
		demoUtils = new DemoUtils();
	}

	@DisplayName("Timeout")
	@Test
	void testTimeout() {
		assertTimeoutPreemptively(
			Duration.ofSeconds(3), 
			() -> demoUtils.checkTimeout(), 
			"Method should execute in 3 seconds"
		);
	}
	
	@DisplayName("Timeout2")
	@Test
	void testTimeout2() {
		assertTimeoutPreemptively(
			Duration.ofSeconds(1), 
			() -> demoUtils.checkTimeout2(), 
			"Method should execute in 1 seconds"
		);
	}

}
