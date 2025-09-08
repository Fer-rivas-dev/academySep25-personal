package com.curso.v3;

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

class Aguila extends Ave{
	@Override
	void volar() {
		System.out.println("Aguila volar");
	}
}

public class Principal {

	public static void main(String[] args) {
		
		Ave ave;
		
		ave = new Pato(); 
		ave.volar(); //Pato volar  
		
		ave = new Aguila();
		ave.volar(); //Aguila volar

	}

}
