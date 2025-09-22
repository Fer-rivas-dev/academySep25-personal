package com.curso.v7;

public class Zoo {
    public static void pause() {
        try {
            Thread.sleep(10_000);
            System.out.println("pause()");
        } catch (InterruptedException e) {
            System.out.println("Thread finished!");
        }
    }

    public static void main(String[] unused) {
    	System.out.println("Main begin");
    	
        Thread job = new Thread(() -> pause());
        job.setDaemon(true);
        job.start();
        
        System.out.println("Main method finished!");
    }
    
    //Main begin
    //Main method finished! ó pause()
    //DORMINDO 10 SEGUNDOS
  
}