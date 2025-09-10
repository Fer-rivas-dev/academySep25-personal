package com.curso.v6;

public class Calculadora {
	
	//INYECTAR
	Operacion ope;
	
	void ejecutaOperacion(int x, int y){
		System.out.println(ope.ejecuta(x,y));
	}

}
