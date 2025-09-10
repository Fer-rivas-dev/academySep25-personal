package com.curso.v10;

enum TipoOperacion {
	SUMA,
	RESTA,
	MULTI,
	DIVISION,
	POTENCIA
}

public class Principal {

	public static void main(String[] args) {
		System.out.println("V10");
		
		Calculadora cal = new Calculadora();
		
		//INYECCION DE DEPENDENCIAS
		Inyector.asignar(cal,TipoOperacion.SUMA); //@Autowired
		cal.ejecutaOperacion(8, 4);  //12
		
		Inyector.asignar(cal,TipoOperacion.RESTA); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		Inyector.asignar(cal,TipoOperacion.MULTI); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		Inyector.asignar(cal,TipoOperacion.POTENCIA); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		Inyector.asignar(cal,TipoOperacion.DIVISION); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		

	}

}
