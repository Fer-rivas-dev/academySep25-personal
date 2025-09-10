package com.curso.v1;

public class Principal {

	public static void main(String[] args) {
		
		int resultado = 0;

		Suma ope1 = new Suma();
		
		resultado = ope1.ejecuta(8, 4);
		
		System.out.println("Resultado: "+resultado);
		
		Resta ope2 = new Resta();
		
		resultado = ope2.ejecuta(8, 4);
		
		System.out.println("Resultado: "+resultado);
	}

}
