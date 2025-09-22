package com.curso.v0;

class MyRunnable implements Runnable{
	public void run() {
		System.out.println("Hello");
	}
}

public class Principal {

	public static void main(String[] args) throws InterruptedException { 
		System.out.println("Inicio Programa"); //Thread main
		
		Runnable runn = new MyRunnable();
		
		Thread myThread = new Thread(runn); //Thread myThread
		
		myThread.start(); //Execute Thread
		
		Thread.sleep(100); //Thread main  
		
		System.out.println("Fin Programa");

		
	}
	
}
