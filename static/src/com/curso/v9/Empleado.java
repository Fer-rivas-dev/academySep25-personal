package com.curso.v9;

public class Empleado {
	
	//Variables de instancia de clase
	String nombre; //null
	
	//Variable de Clase
	private static int contador; //0
	
	Empleado(String nombre) { 
		this.nombre = nombre;
		contador++;
	}
	
	static int getContador() {
		return contador;
	}

}
