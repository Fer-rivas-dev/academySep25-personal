package com.curso.v7;

public class Potencia implements Operacion {
	
	@Override
	public int ejecuta(int x, int y) {
		return (int)Math.pow(x, y);
	}

}
