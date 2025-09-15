package com.curso.v2;

interface Predicado{
	boolean probar(String cadena);
}

class LongitudNombre implements Predicado{
	@Override
	public boolean probar(String nombre) {
		return nombre.length() > 5;
	}
}

// x -> x.length() > 5;

class TerminaNombreX implements Predicado{
	@Override
	public boolean probar(String nombre) {
		return 'x' == nombre.charAt(nombre.length()-1);
	}
}

//z -> 'x' == z.charAt(z.length()-1);


class NombreVacio implements Predicado{
	@Override
	public boolean probar(String cadena) {
		return cadena.isBlank();
	}
}

//w -> w.isBlank();

public class Principal {
	
	public static void main(String[] args) {
		
		System.out.println("V2");
		
		String nombre = "Patrobas";
		//VERIFICAR SI NOMBRE LONGITUD MAYOR A 5
		boolean resultado = false;
		
		Predicado ln = new LongitudNombre();
		resultado = ln.probar(nombre);
		System.out.println(resultado);
		
		Predicado tx = new TerminaNombreX();
		resultado = tx.probar(nombre);
		System.out.println(resultado);
		
		Predicado nv = new NombreVacio();
		resultado = nv.probar(nombre);
		System.out.println(resultado);
		
	}

}
