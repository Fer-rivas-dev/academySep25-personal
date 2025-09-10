package com.curso.v10;

public class Calculadora {
	
	//BAJO ACOPLAMIENTO
	private Operacion ope; 
	
	void ejecutaOperacion(int x, int y){
		System.out.print(ope.getClass().getSimpleName());
		System.out.println(" x:"+x+", y:"+y);
		System.out.println(ope.ejecuta(x,y));
	}

	public Operacion getOperacion() {
		return ope;
	}

	public void setOperacion(Operacion ope) { //INYECCION POR SETTER
		this.ope = ope;
	}
	
	

}
