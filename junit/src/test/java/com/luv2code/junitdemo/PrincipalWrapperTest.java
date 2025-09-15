package com.luv2code.junitdemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PrincipalWrapperTest {
	
	@Test
	void booleanReturnFalse() {
		
		PrincipalWrapper pw = new PrincipalWrapper();
		
		boolean resultadoEsperado = false;
		
		assertEquals(resultadoEsperado, pw.isGreater(5, 5), "El resultado debe ser false" );
		
	}
	
	@Test
	void booleanReturnFalse2() {
		
		PrincipalWrapper pw = new PrincipalWrapper();
		
		assertFalse(pw.isGreater(5, 5), "El resultado debe ser false" );
		
	}

}
