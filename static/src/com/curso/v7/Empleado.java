package com.curso.v7;

public class Empleado {
	
	//Variables de instancia de clase
	String nombre; //null
	
	//Variable de Clase
	static int contador; //0
	
	Empleado(String nombre) { 
		this.nombre = nombre;
		contador++;
	}

}
