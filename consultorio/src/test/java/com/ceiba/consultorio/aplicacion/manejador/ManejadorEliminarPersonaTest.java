package com.ceiba.consultorio.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorEliminarPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioEliminarPersona;

public class ManejadorEliminarPersonaTest {
	@Test
	void execute() {
		ServicioEliminarPersona service = mock(ServicioEliminarPersona.class);
		ManejadorEliminarPersona handler = new ManejadorEliminarPersona(service);

		assertDoesNotThrow(() -> handler.ejecutar(1L));
	}

}
