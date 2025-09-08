package com.curso.v6;

import java.util.Random;

class Ave{
	
	String tipo = "Ave";
	
	void volar() {
		System.out.println("Ave volar");
	}
}

class Pato extends Ave{
	
	String tipo = "Pato";

	@Override
	void volar() {
		System.out.println("Pato volar");
	}
}

class Aguila extends Ave{
	
	String tipo = "Aguila";
	
	@Override
	void volar() {
		System.out.println("Aguila volar");
	}
}

class Pinguino extends Ave{
	
	String tipo = "Pinguino";

	@Override
	void volar() {
		System.out.println("Pinguino no volar");
	}
}

public class Principal {

	public static void main(String[] args) {
		Ave ave = getAve();
		
		String type = ave.tipo;
		
		if ( ave instanceof Pato)
			type = ((Pato)ave).tipo;
		
		if ( ave instanceof Aguila)
			type = ((Aguila)ave).tipo;
		
		if ( ave instanceof Pinguino)
			type = ((Pinguino)ave).tipo;
		
		System.out.println(type); 
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
