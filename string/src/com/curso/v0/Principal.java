package com.curso.v0;

public class Principal {
	
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "Hello";
		String s4 = new String("Hello");
		
		//Objects 2
		
		StringBuilder sb1 = new StringBuilder("Hola");
		StringBuilder sb2 = new StringBuilder("Hola");
		
		System.out.println("***String***");

		System.out.println(s3.equals(s4)); //true 
		System.out.println(s3 == s4); //false
		
		System.out.println("***StringBuilder***");
		
		System.out.println(sb1.equals(sb2)); //false 
		System.out.println(sb1 == sb2); //false


		
	}

}
