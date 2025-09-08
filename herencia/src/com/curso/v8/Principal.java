package com.curso.v8;

class Ave{
	String tipo = "Ave";
	
	void volar() {
		System.out.println("Ave volar");
	}
}

class Pato extends Ave{
	//HIDDEN
	String tipo = "Pato";

	@Override
	void volar() {
		System.out.println("Pato volar");
	}
}

class PatoSilvestre extends Pato{
	String tipo = "Pato Silvestre";

	@Override
	void volar() {
		System.out.println("Pato Silvestre volar");
	}
}

class PatoDummy extends Pato{
	String tipo = "Pato Dummy";

	@Override
	void volar() {
		System.out.println("Pato Dummy volar");
	}
}


public class Principal {

	public static void main(String[] args) {

		PatoDummy dummy = new PatoDummy();
		dummy.volar();
		
		Pato pato = (Pato)dummy;
		pato.volar();
		
		Ave ave = (Ave)pato;
		ave.volar();
		
		
	}

}
