package com.book.v0;

public class CheckResultsWithSleepAndInterrupt {

	private static int counter = 0;

	public static void main(String[] a) {

		final Thread mainThread = Thread.currentThread(); //Thread main

		new Thread(() -> { //Thread 2
							for (int i = 0; i < 10_000_000; i++) {
								System.out.println(counter);
								counter++;
							}
							//Lanzar la exception InterruptedException;
							mainThread.interrupt(); 
							//Interrumpir el sueño al thread main
		}).start();

		while (counter < 10_000_000) {
			System.out.println("Not reached yet");
			try {
				Thread.sleep(10_000); // 10 SECOND //Orden: Niño vete a dormir
			} catch (InterruptedException e) { 
				System.out.println("ME INTERRUMPIERON DE MI SUEÑO");
				System.out.println("Interrupted!");
			}
		}

		System.out.println("Reached: " + counter);
	}
}