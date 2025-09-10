package com.curso.v3;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("V3");
		
		int resultado = 0;
		
		Operacion ope0 = new Operacion();
		
		resultado = ope0.ejecuta(8, 4);
		
		System.out.println("Resultado: "+resultado); //0

		Operacion ope1 = new Suma();
		
		resultado = ope1.ejecuta(8, 4);
		
		System.out.println("Resultado: "+resultado); //12
		
		Operacion ope2 = new Resta();
		
		resultado = ope2.ejecuta(8, 4);
		
		System.out.println("Resultado: "+resultado); //4
	}

}
