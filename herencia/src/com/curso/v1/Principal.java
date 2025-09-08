package com.curso.v1;

class Ave{
	void volar() {
		System.out.println("Ave volar");
	}
}

class Pato extends Ave{
	@Override
	void volar() {
		System.out.println("Pato volar");
	}
}

public class Principal {

	public static void main(String[] args) {
		
		Ave ave = new Pato(); 
		ave.volar(); //Pato volar  

	}

}
