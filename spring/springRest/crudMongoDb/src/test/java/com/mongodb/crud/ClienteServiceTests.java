package com.mongodb.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.mongodb.crud.model.Cliente;
import com.mongodb.crud.repository.ClienteRepository;
import com.mongodb.crud.service.ClienteService;

@SpringBootTest
public class ClienteServiceTests {
	
	@MockitoBean
    private ClienteRepository clienteRespository;
	
	@Autowired
	private ClienteService clienteService;

	@Test
	@DisplayName("Consulta de un cliente")
	void buscarClienteId() {
		Cliente cliente = new Cliente("Filologo Pérez", "filologo@email.com", "123456789");
		cliente.setId("5");
		
		Cliente clienteEsperado = new Cliente("Filologo Pérez", "filologo@email.com", "123456789");
		clienteEsperado.setId("5");

		when(clienteRespository.findById("5"))
				//REGRESAR EL CLIENTE 5
				.thenReturn(Optional.of(clienteEsperado));

		assertEquals(
				//COMPARAR LOS DOS CLIENTES CON ID 5 Y DEBEN SER IGUALES
				Optional.of(cliente),
				clienteService.findById("5"));
		
		verify(clienteRespository, times(1)).findById("5");
	}
	
}
