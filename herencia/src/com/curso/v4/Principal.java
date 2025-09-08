package com.curso.v4;

import java.util.Random;

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

class Pinguino extends Ave{
	@Override
	void volar() {
		System.out.println("Pinguino no volar");
	}
}

public class Principal {

	public static void main(String[] args) {
		Ave ave = getAve();
		ave.volar(); 
	}

	private static Ave getAve() {
		
		Ave[] aves = {
				new Ave(), //0
				new Pato(), //1
				new Aguila(), //2
				new Pinguino() //3
		};
		
		int aleatorio = new Random().nextInt(aves.length);
		System.out.println("Aleatorio: "+aleatorio);
		return aves[aleatorio];
	}

}
