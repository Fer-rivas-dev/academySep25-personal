package com.curso.v8;

public class Bees {
	
	public static void main(String[] args) {
		try {
			new Bees().go();
		}catch(Exception e){
			System.out.println("Throw to main");
		}
	}

	synchronized private void go() throws InterruptedException {
		Thread t1 = new Thread();
		t1.start(); 
		System.out.println(1);
		t1.wait(5000);
		System.out.println(2);

	}

}
