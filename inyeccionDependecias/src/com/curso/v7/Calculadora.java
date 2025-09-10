package com.curso.v7;

public class Calculadora {
	
	//BAJO ACOPLAMIENTO
	Operacion ope; //INYECCION POR VARIABLE
	
	void ejecutaOperacion(int x, int y){
		System.out.print(ope.getClass().getSimpleName());
		System.out.println(" x:"+x+", y:"+y);
		System.out.println(ope.ejecuta(x,y));
	}

}
