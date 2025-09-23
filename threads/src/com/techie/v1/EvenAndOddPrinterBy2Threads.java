package com.techie.v1;

public class EvenAndOddPrinterBy2Threads implements Runnable {
	
	Object object; //Candado con su llave //Monitor
	static int count = 1;
	
	public EvenAndOddPrinterBy2Threads(Object object) {
		this.object = object;
	}
	
	@Override
	public void run() {
		while (count<=10) {
			if (count%2==0 && Thread.currentThread().getName().equals("even")) { 
				synchronized(object) { //EJECUTAR UN SOLO HILO
					System.out.println("Thread name: "+Thread.currentThread().getName()+
							", value: "+count);
					count++;
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (count%2!=0 && Thread.currentThread().getName().equals("odd")) { 
				synchronized(object) { //EJECUTAR UN SOLO HILO
					System.out.println("Thread name: "+Thread.currentThread().getName()+
							", value: "+count);
					count++;
					object.notify();
				}
			}	
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Begin main");
		
		Object lock = new Object();
		
		Runnable r1 = new EvenAndOddPrinterBy2Threads(lock);
		Runnable r2 = new EvenAndOddPrinterBy2Threads(lock); 
		
		new Thread(r1,"even").start();
				
		new Thread(r2,"odd").start(); 
		
		System.out.println("End main");
		
		//Thread name: odd, value 1
		//Thread name: even, value 2
		//Thread name: odd, value 3
		//Thread name: even, value 4
		//Thread name: odd, value 6
		//Thread name: even, value 7
	}

}
