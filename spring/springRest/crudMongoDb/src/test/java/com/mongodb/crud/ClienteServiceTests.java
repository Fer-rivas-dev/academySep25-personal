package com.mongodb.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.mongodb.crud.repository.ClienteRepository;
import com.mongodb.crud.service.ClienteServiceImpl;

@SpringBootTest
public class ClienteServiceTests {
	
	@MockitoBean
    private ClienteRepository clienteRespository;
	
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;

	@Test
	@DisplayName("Consulta de un cliente")
	void buscarClienteId() {
		when(clienteRespository.findById("5").
				//REGRESAR EL CLIENTE 5
				thenReturn( );
		
		assertEquals(
				//COMPARAR LOS DOS CLIENTES CON ID 5 Y DEBEN SER IGUALES
				clienteServiceImpl.findById("5"),
				
				);
		
	}
	
}
