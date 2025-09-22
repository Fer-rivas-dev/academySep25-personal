package com.curso.v4;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		Runnable printInventory = 
				() -> System.out.println("Printing zoo inventory, "
								+ Thread.currentThread().getName());
		
		Runnable printRecords = () -> {
			for (int i = 0; i < 3; i++)
				System.out.println("Printing record: " + i);
		};
		
		System.out.println("begin"); // Thread main 1
		
		Thread thread2 = new Thread(printInventory);
		thread2.setName("Thread2");
		thread2.start();
		
		new Thread(printRecords).start(); //Thread 3
		
		Thread thread4 = new Thread(printInventory);
		thread4.setName("Thread4");
		thread4.start();
		
		System.out.println("end");
		

	}

}
