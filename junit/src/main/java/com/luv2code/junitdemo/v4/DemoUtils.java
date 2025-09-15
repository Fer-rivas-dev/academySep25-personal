package com.luv2code.junitdemo.v4;

public class DemoUtils {
	
	public static void main(String[] args) throws InterruptedException {
		DemoUtils du = new DemoUtils();
		du.checkTimeout();
	}

	public void checkTimeout() throws InterruptedException {
		System.out.println("I am going to sleep");
		Thread.sleep(2000); //DORMIR 2 SEGUNDOS
		System.out.println("Sleeping over");
	}
	
	public void checkTimeout2() {
		for (int x=0;  x<500_000; x++) {
			System.out.println(x);
		}
	}
	

}
