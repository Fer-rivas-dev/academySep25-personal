package com.curso.v10;

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
		
		System.out.println("V10");

		PatoDummy dummy = new PatoDummy();
		System.out.println(dummy.tipo);
		dummy.volar();
		
		Pato pato = dummy;
		System.out.println(pato.tipo);
		pato.volar();
		
		Ave ave = pato;
		System.out.println(ave.tipo);
		ave.volar();
		
		Object objecto = ave;
		//objecto.volar(); //Object NO SABE volar()
		
		//ave = null;
		
		
	}

}
