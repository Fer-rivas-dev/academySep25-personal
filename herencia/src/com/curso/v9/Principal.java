package com.curso.v9;

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
		System.out.println(dummy.tipo);
		dummy.volar();
		
		Pato pato = (Pato)dummy;
		System.out.println(pato.tipo);
		pato.volar();
		
		Ave ave = (Ave)pato;
		System.out.println(ave.tipo);
		ave.volar();
		
		ave = null;
		
		
	}

}
