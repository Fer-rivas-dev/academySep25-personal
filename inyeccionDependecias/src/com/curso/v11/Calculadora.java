package com.curso.v11;

public class Calculadora {
	
	//BAJO ACOPLAMIENTO
	private Operacion ope; 

	//INYECCION POR CONSTRUCTOR
	public Calculadora(Operacion ope) {
		this.ope = ope;
	}
	
	void ejecutaOperacion(int x, int y){
		System.out.print(ope.getClass().getSimpleName());
		System.out.println(" x:"+x+", y:"+y);
		System.out.println(ope.ejecuta(x,y));
	}

}
