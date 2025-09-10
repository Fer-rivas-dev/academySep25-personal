package com.curso.v5;

public class Calculadora {
	
	//ALTO ACOMPLAMIENTO (MALA PRACTICA)
	Suma suma = new Suma();
	Resta resta = new Resta();
	Multi multi = new Multi();
	Division div = new Division();
	
	void sumar(int x, int y){
		System.out.println("Suma: " + suma.ejecuta(x,y));
	}

	void restar(int x, int y){
		System.out.println("Resta: " + resta.ejecuta(x,y));
	}
	
	void multiplicar(int x, int y){
		System.out.println("Multi: " + multi.ejecuta(x,y));
	}

	void dividir(int x, int y){
		System.out.println("Divide: " + div.ejecuta(x,y));
	}
}
