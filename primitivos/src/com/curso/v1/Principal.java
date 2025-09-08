package com.curso.v1;

public class Principal {

	public static void main(String[] args) {
		int i = 10;
		String cadena = "Hello";
		StringBuilder sb = new StringBuilder("Hola");
		
		transforma(i,cadena,sb);
		
		System.out.println(i); //10 //PRIMITIVO
		System.out.println(cadena); //Hello //INMUTABLE 
		System.out.println(sb); //Hola Mundo //MUTABLE
	}

	private static void transforma(int i, String cadena, StringBuilder sb) {
		i = i + 10;
		cadena.concat(" World");
		sb.append(" Mundo");
	}

}
