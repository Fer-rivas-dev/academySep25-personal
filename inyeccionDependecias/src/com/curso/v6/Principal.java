package com.curso.v6;

public class Principal {

	public static void main(String[] args) {
		System.out.println("V6 InyeccionDependencias");
		
		Calculadora cal = new Calculadora();
		
		cal.ejecutaOperacion(8, 4); //NullPointerException
		

	}

}
