package com.curso.v2;

class Ave{
	void volar() {
		System.out.println("Ave volar");
	}
}

class Pato extends Ave{
	void volar() {
		System.out.println("Pato volar");
	}
	
	void volarPato() {
		System.out.println("volarPato()");
	}
}

public class Principal {

	public static void main(String[] args) {
		
		Ave ave = new Pato(); 
		((Pato)ave).volarPato();

	}

}
