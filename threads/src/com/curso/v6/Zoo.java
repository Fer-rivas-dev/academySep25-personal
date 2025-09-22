package com.curso.v6;

public class Zoo {
    public static void pause() {
        try {
        	System.out.println("pause()");
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println("Thread finished!");
        }
    }

    public static void main(String[] unused) {
    	System.out.println("Main begin");
    	
        Thread job = new Thread(() -> pause());
        job.start();
        
        System.out.println("Main method finished!");
    }
    
    //Main begin
    //Main method finished! ó pause()
    //DORMINDO 10 SEGUNDOS
  
}