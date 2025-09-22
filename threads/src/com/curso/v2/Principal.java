package com.curso.v2;

public class Principal {

	public static void main(String[] args) throws InterruptedException { 
		
		System.out.println("Inicio Programa V2"); //Thread main
				
		new Thread(() -> System.out.println("Hello")).start(); //Thread myThread
		
		Thread.sleep(1); //Thread main  
		
		System.out.println("Fin Programa");

	}
	
}
