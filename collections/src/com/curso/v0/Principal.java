package com.curso.v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {
	
	public static void main(String[] args) {
		String cliente1 = "Juan Pérez";

		String cliente2 ="María García";

		String cliente3 = "Carlos López";

		List<String> clientesEsperados = Arrays.asList(cliente1, cliente2, cliente3);
		List<String> clientes = Arrays.asList(cliente1, cliente2, cliente3);
		
		System.out.println(clientesEsperados.equals(clientes));
		
		clientesEsperados = new ArrayList<>();
		clientesEsperados.add(cliente1);
		clientesEsperados.add(cliente2);
		clientesEsperados.add(cliente3);
		//clientesEsperados.add(null);
		
		clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		
		System.out.println(clientesEsperados.equals(clientes));


		
	}

}
