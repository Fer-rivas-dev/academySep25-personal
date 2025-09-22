package com.curso.v1;

public class Principal {

	public static void main(String[] args) throws InterruptedException { 
		
		System.out.println("Inicio Programa V1"); //Thread main
		
		Runnable runn = () -> System.out.println("Hello");
		
		Thread myThread = new Thread(runn); //Thread myThread
		
		myThread.start(); //Execute Thread
		
		Thread.sleep(1); //Thread main  
		
		System.out.println("Fin Programa");

	}
	
}
