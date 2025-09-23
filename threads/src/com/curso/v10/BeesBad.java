package com.curso.v10;

public class BeesBad {
	
	public static void main(String[] args) {
		try {
			new BeesBad().go();
		}catch(Exception e){
			System.out.println("Throw to main");
		}
	}

	synchronized private void go() throws InterruptedException {
		Thread t1 = new Thread();
		t1.start(); 
		System.out.println(1);
		t1.wait(5000); //t1 NO posee el candado, lo posee this (main)
		System.out.println(2);
	}

}
