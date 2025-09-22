package com.book.v0;

public class CheckResults {

	private static int counter = 0; //COMPARTIDO

	public static void main(String[] args) {
		
		System.out.println("Thread mean begin");
		
		new Thread(() -> {

			for (int i = 0; i < 1_000_000; i++) {
				System.out.println(counter);
				counter++;
			}

		}).start();
		
		while (counter < 1_000_000) {
			System.out.println("Not reached yet");
		}
		
		System.out.println("Reached: " + counter);
	}
}