package com.curso.v3;

interface Predicado{
	boolean probar(String cadena);
}

// x -> x.length() > 5;

// z -> 'x' == z.charAt(z.length()-1);

// w -> w.isBlank();

public class Principal {
	
	public static void main(String[] args) {
		
		System.out.println("V3");
		
		String nombre = "Patrobas";
		//VERIFICAR SI NOMBRE LONGITUD MAYOR A 5
		boolean resultado = false;
		
		Predicado pre1 = x -> x.length() > 5;
		resultado = pre1.probar(nombre);
		System.out.println(resultado);
		
		Predicado pre2 = z -> 'x' == z.charAt(z.length()-1);
		resultado = pre2.probar(nombre);
		System.out.println(resultado);
		
		Predicado pre3 = w -> w.isBlank();
		resultado = pre3.probar(nombre);
		System.out.println(resultado);
		
	}

}
