package com.curso.v10;

public class Inyector {
	
	static Operacion ope1 = new Suma();
	static Operacion ope2 = new Resta();
	static Operacion ope3 = new Multi();
	static Operacion ope4 = new Division();
	static Operacion ope5 = new Potencia();
	
	public static void asignar(Calculadora cal, TipoOperacion to) {
		
		switch (to) {
			case SUMA: 
				cal.setOperacion(ope1); 
				break;
			case RESTA: 
				cal.setOperacion(ope2); 
				break;
			case MULTI: 
				cal.setOperacion(ope3); 
				break;
			case DIVISION: 
				cal.setOperacion(ope4); 
				break;
			case POTENCIA: 
				cal.setOperacion(ope5); 
		}
		
	}

	

}
