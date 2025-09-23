package com.curso.v10;

public class Bees {
	
	public static void main(String[] args) {
		try {
			new Bees().go();
		}catch(Exception e){
			System.out.println("Throw to main");
		}
	}

	private void go() throws InterruptedException {
		
		Thread t1 = new Thread();
		t1.start(); 
		System.out.println(1);
		
		synchronized(t1) {
			t1.wait(5000);
		}
		
		System.out.println(2);
		
	}

}
