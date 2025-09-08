package com.curso.v1;

public class Principal {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Patrobas",20);
		Cliente c999 = new Cliente("Patrobas",20);
		
		System.out.println(c1.equals(c999)); //true
		System.out.println(c1 == c999); //false
	}

}
