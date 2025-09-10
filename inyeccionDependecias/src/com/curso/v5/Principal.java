package com.curso.v5;

public class Principal {

	public static void main(String[] args) {
		System.out.println("V5");
		
		Calculadora cal = new Calculadora();
		
		cal.multiplicar(8,4);
		cal.sumar(8, 4);
		cal.restar(8, 4);
		cal.dividir(8, 4);
	}

}
