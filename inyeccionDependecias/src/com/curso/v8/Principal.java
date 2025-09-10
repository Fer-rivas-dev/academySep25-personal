package com.curso.v8;

public class Principal {

	public static void main(String[] args) {
		System.out.println("V8 InyeccionDependencias");
		
		Calculadora cal = new Calculadora();
		
		//INYECCION DE DEPENDENCIAS
		Inyector.asignar(cal,"SUMA"); //@Autowired
		cal.ejecutaOperacion(8, 4);  //12
		
		Inyector.asignar(cal,"RESTA"); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		Inyector.asignar(cal,"MULTI"); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		Inyector.asignar(cal,"POTENCIA"); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		
		Inyector.asignar(cal,"DIV"); //@Autowired
		cal.ejecutaOperacion(8, 4);  //4
		

	}

}
