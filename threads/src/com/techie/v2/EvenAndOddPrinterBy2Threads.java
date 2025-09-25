package com.techie.v2;


class myRunnable1 implements Runnable{
	
	Object object; //Monitor //Candado con su llave
	
	public myRunnable1(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		while (EvenAndOddPrinterBy2Threads.count<=10) {
			if (EvenAndOddPrinterBy2Threads.count%2==0 && Thread.currentThread().getName().equals("even")) { 
				synchronized(object) { //EJECUTAR UN SOLO HILO
					System.out.println("Thread name: "+Thread.currentThread().getName()+
							", value: "+EvenAndOddPrinterBy2Threads.count);
					EvenAndOddPrinterBy2Threads.count++;
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (EvenAndOddPrinterBy2Threads.count%2!=0 && Thread.currentThread().getName().equals("odd")) { 
				synchronized(object) { //EJECUTAR UN SOLO HILO
					System.out.println("Thread name: "+Thread.currentThread().getName()+
							", value: "+EvenAndOddPrinterBy2Threads.count);
					EvenAndOddPrinterBy2Threads.count++;
					object.notify();
				}
			}	
		}
	}

}

class myRunnable2 implements Runnable{
	
	Object object; //Monitor //Candado con su llave
	
	public myRunnable2(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		while (EvenAndOddPrinterBy2Threads.count<=10) {
			if (EvenAndOddPrinterBy2Threads.count%2==0 && Thread.currentThread().getName().equals("even")) { 
				synchronized(object) { //EJECUTAR UN SOLO HILO
					System.out.println("Thread name: "+Thread.currentThread().getName()+
							", value: "+EvenAndOddPrinterBy2Threads.count);
					EvenAndOddPrinterBy2Threads.count++;
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (EvenAndOddPrinterBy2Threads.count%2!=0 && Thread.currentThread().getName().equals("odd")) { 
				synchronized(object) { //EJECUTAR UN SOLO HILO
					System.out.println("Thread name: "+Thread.currentThread().getName()+
							", value: "+EvenAndOddPrinterBy2Threads.count);
					EvenAndOddPrinterBy2Threads.count++;
					object.notify();
				}
			}	
		}
	}

}


public class EvenAndOddPrinterBy2Threads {
	
	static int count = 1;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Begin main V2");
		
		Object lock = new Object();
		
		Runnable r1 = new myRunnable1(lock);
		Runnable r2 = new myRunnable2(lock); 
		
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
