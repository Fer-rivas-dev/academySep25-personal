package com.curso.v11;

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
		
		System.out.println("V11");

		PatoDummy dummy = new PatoDummy();
		dummy.volar();
		
		Pato pato = dummy;
		pato.volar();
		
		Ave ave = pato;
		ave.volar();
		
		Object objecto = ave;
		
		Ave ave2 = (Ave)objecto;
	
		Pato pato2 = (Pato)ave2;
		
		
		if ( pato2 instanceof PatoSilvestre) { //false
			PatoSilvestre patoSilvestre = (PatoSilvestre)pato2;
			patoSilvestre.volar(); //ClassCastException
		}
		
		System.out.println("Program End");
		
	}

}
