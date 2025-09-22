package com.curso.v3;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		Runnable printInventory = () -> System.out.println("Printing zoo inventory");
		
		Runnable printRecords = () -> {
			for (int i = 0; i < 3; i++)
				System.out.println("Printing record: " + i);
		};
		
		System.out.println("begin"); // Thread main 1

		new Thread(printInventory).start(); //Thread 2
		new Thread(printRecords).start(); //Thread 3
		new Thread(printInventory).start(); //Thread 4
		
		System.out.println("end");
		
		//begin

	}

}
