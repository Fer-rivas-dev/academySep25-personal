package com.demo.v3;

class Pato {

	Object obj;

	public Pato(Object obj) {
		this.obj = obj;
	}

	void dormir() { 
		synchronized (obj) { // Obtiene el monitor del objeto Object
			System.out.println("Pato espera 5 segundos");
			try {
				obj.wait(5000); // Libera 5 segundos el monitor
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Principal {
	public static void main(String[] args) {
		System.out.println("Begin main V3");
		Object o = new Object(); // OBJECTO

		Pato pato = new Pato(o); 
		pato.dormir();

		System.out.println("End main");
	}
}
