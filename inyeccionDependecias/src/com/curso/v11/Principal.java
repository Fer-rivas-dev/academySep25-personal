package com.curso.v11;

enum TipoOperacion {
	SUMA,
	RESTA,
	MULTI,
	DIVISION,
	POTENCIA
}

public class Principal {

	public static void main(String[] args) {
		System.out.println("V11");
		
		Calculadora cal;
		
		//INYECCION DE DEPENDENCIAS
		cal = Inyector.asignar(TipoOperacion.SUMA); //@Autowired
		cal.ejecutaOperacion(8, 4);  //12
		
		cal = Inyector.asignar(TipoOperacion.RESTA); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		cal = Inyector.asignar(TipoOperacion.MULTI); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		cal = Inyector.asignar(TipoOperacion.DIVISION); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		cal = Inyector.asignar(TipoOperacion.POTENCIA); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		

	}

}
