package com.curso.v9;

public class Inyector {
	
	static Operacion ope1 = new Suma();
	static Operacion ope2 = new Resta();
	static Operacion ope3 = new Multi();
	static Operacion ope4 = new Division();
	static Operacion ope5 = new Potencia();
	
	public static void asignar(Calculadora cal, TipoOperacion to) {
		
		switch (to) {
			case SUMA: 
				cal.ope = ope1;
				break;
			case RESTA: 
				cal.ope = ope2;
				break;
			case MULTI: 
				cal.ope = ope3;
				break;
			case DIVISION: 
				cal.ope = ope4;
				break;
			case POTENCIA: 
				cal.ope = ope5;
		}
		
	}

	

}
