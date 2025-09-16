package com.mongodb.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
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

	@Test
	@DisplayName("Consulta de todos los clientes")
	void buscarClientes() {
		Cliente cliente1 = new Cliente("Juan Pérez", "juan@email.com", "123456789");
		cliente1.setId("1");

		Cliente cliente2 = new Cliente("María García", "maria@email.com", "987654321");
		cliente2.setId("2");

		Cliente cliente3 = new Cliente("Carlos López", "carlos@email.com", "555666777");
		cliente3.setId("3");

		List<Cliente> clientesEsperados = Arrays.asList(cliente1, cliente2, cliente3);
		List<Cliente> clientes = Arrays.asList(cliente1, cliente2, cliente3);

		when(clienteRespository.findAll())
				.thenReturn(clientesEsperados);

		assertEquals(
				clientes,
				clienteService.findAll());

		verify(clienteRespository, times(1)).findAll();
	}

	@Test
	@DisplayName("Actualización de un cliente")
	void actualizarCliente() {
		String clienteId = "1";

		Cliente clienteExistente = new Cliente("Juan Pérez", "juan@email.com", "123456789");
		clienteExistente.setId(clienteId);

		Cliente clienteActualizado = new Cliente("Juan Pérez García", "juan.garcia@email.com", "987654321");

		Cliente clienteEsperado = new Cliente("Juan Pérez García", "juan.garcia@email.com", "987654321");
		clienteEsperado.setId(clienteId);

		when(clienteRespository.findById(clienteId))
				.thenReturn(Optional.of(clienteExistente));

		when(clienteRespository.save(clienteExistente))
				.thenReturn(clienteEsperado);

		Cliente resultado = clienteService.update(clienteId, clienteActualizado);

		assertEquals(clienteEsperado, resultado);

		verify(clienteRespository, times(1)).findById(clienteId);
		verify(clienteRespository, times(1)).save(clienteExistente);
	}

	@Test
	@DisplayName("Guardar un cliente")
	void guardarCliente() {
		Cliente clienteParaGuardar = new Cliente("Ana Martínez", "ana@email.com", "111222333");

		Cliente clienteGuardado = new Cliente("Ana Martínez", "ana@email.com", "111222333");
		clienteGuardado.setId("10");

		when(clienteRespository.save(clienteParaGuardar))
				.thenReturn(clienteGuardado);

		Cliente resultado = clienteService.save(clienteParaGuardar);

		assertEquals(clienteGuardado, resultado);

		verify(clienteRespository, times(1)).save(clienteParaGuardar);
	}

	@Test
	@DisplayName("Eliminar un cliente")
	void eliminarCliente() {
		String clienteId = "5";

		assertDoesNotThrow(() -> clienteService.deleteById(clienteId));

		verify(clienteRespository, times(1)).deleteById(clienteId);
	}

}
