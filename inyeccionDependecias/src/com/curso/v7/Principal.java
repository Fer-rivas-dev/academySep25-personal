package com.curso.v7;

public class Principal {

	public static void main(String[] args) {
		System.out.println("V7 InyeccionDependencias");
		
		Calculadora cal = new Calculadora();
		
		//INYECCION DE DEPENDENCIAS
		cal.ope = new Suma();
		cal.ejecutaOperacion(8, 4); 
		
		cal.ope = new Resta();
		cal.ejecutaOperacion(8, 4); 
		
		cal.ope = new Multi();
		cal.ejecutaOperacion(8, 4); 
		
		cal.ope = new Division();
		cal.ejecutaOperacion(8, 4); 
		
		cal.ope = new Suma();
		cal.ejecutaOperacion(9, 6); 
		
		cal.ope = new Potencia();
		cal.ejecutaOperacion(8, 4); 
		

	}

}
