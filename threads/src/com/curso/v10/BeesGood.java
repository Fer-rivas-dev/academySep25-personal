package com.curso.v10;

public class BeesGood {
	
	public static void main(String[] args) {
		try {
			new BeesGood().go();
		}catch(Exception e){
			System.out.println("Throw to main");
		}
	}

	synchronized private void go() throws InterruptedException {
		Thread t1 = new Thread();
		t1.start(); 
		System.out.println(1);
		
		this.wait(5000);
		
		System.out.println(2);

	}

}
