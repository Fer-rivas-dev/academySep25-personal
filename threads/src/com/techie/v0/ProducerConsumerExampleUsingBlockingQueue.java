package com.techie.v0;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExampleUsingBlockingQueue {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("***Begin main***");
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		
		Thread producerThread = new Thread( () -> {
				try {
					for (int i=0; i<10; i++) {
						//pc.produce(i); //Producir del 0 al 9
						//boolean b = queue.offer(i);
						queue.put(i);
						System.out.println("Pruduced: "+ i );
						Thread.sleep(100);
					}
				}catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
		});
		
		Thread consumerThread = new Thread( () -> {
			try {
				for (int i=0; i<10; i++) {
					//pc.consume(); //Consumir del 0 al 9
					Integer integer = queue.poll();
					System.out.println("Consumed: " +i+ ", "+ integer);
					Thread.sleep(400); //Consumir tarda un poco mas de tiempo que el Producer
				}
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join(); //Thread main espera que termine el hilo producerThread
		consumerThread.join(); //Thread main espera que termine el hilo consumerThread
		
		System.out.println("***End main***");
		
	}
}
