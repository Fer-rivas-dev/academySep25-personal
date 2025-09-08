package com.curso.v1;

import java.util.Objects;

public class Cliente {
	
	String nombre;
	int edad;
	
	public Cliente(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public boolean equals(Object obj) {
		Cliente other = (Cliente) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}

}
