package com.curso.v11;

public class Inyector {
	
	static Operacion ope1 = new Suma();
	static Operacion ope2 = new Resta();
	static Operacion ope3 = new Multi();
	static Operacion ope4 = new Division();
	static Operacion ope5 = new Potencia();
	
	public static Calculadora asignar(TipoOperacion to) {
		
		switch (to) {
			case SUMA: 
				return new Calculadora(ope1); 
			case RESTA: 
				return new Calculadora(ope2); 
			case MULTI: 
				return new Calculadora(ope3); 
			case DIVISION: 
				return new Calculadora(ope4);  
			case POTENCIA: 
				return new Calculadora(ope5); 
			default:
				throw new IllegalArgumentException("Operacion NO definida");
		}
		
	}

	

}
