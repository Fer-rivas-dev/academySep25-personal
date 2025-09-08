package com.curso.v8;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println(Empleado.contador); //0

		Empleado emp1 = new Empleado("Filologo");
		Empleado emp2 = new Empleado("Epeneto");
		Empleado emp3 = new Empleado("Andronico");
		Empleado emp4 = new Empleado("Erasto");

		System.out.println(emp1.nombre); //Filologo
		System.out.println(Empleado.contador); //4
		
		System.out.println(emp2.nombre); //Epeneto
		System.out.println(Empleado.contador); //4
		
		System.out.println(emp3.nombre); //Andronico
		System.out.println(Empleado.contador); //4
		
		System.out.println(emp4.nombre); //Erasto
		System.out.println(emp1.contador); //4
		
	}

}
