package com.curso.v3;

public class Principal {

	public static void main(String[] args) {
		int i = 10;
		String cadena = "Hello";
		StringBuilder sb = new StringBuilder("Hola");
		
		cadena = transforma(i,cadena,sb);
		
		System.out.println(i); //10 //PRIMITIVO
		System.out.println(cadena); //Hello World //INMUTABLE 
		System.out.println(sb); //Hola Mundo //MUTABLE
	}

	private static String transforma(int i, String cadena, StringBuilder sb) {
		i = i + 10;
		cadena = cadena.concat(" World");
		sb.append(" Mundo");
		
		return cadena;
	}

}
