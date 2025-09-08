package com.curso.v6;

public class Principal {

	public static void main(String[] args) {

		Empleado emp1 = new Empleado("Filologo");
		Empleado emp2 = new Empleado("Epeneto");
		Empleado emp3 = new Empleado("Andronico");
		Empleado emp4 = new Empleado("Erasto");

		System.out.println(emp1.nombre); //Filologo
		System.out.println(emp1.contador); //1
		
		System.out.println(emp2.nombre); //Epeneto
		System.out.println(emp2.contador); //1
		
		System.out.println(emp3.nombre); //Andronico
		System.out.println(emp3.contador); //1
		
		System.out.println(emp4.nombre); //Erasto
		System.out.println(emp4.contador); //1
		
	}

}
