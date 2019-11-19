package com.ceiba.consultorio.aplicacion.comando;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import databuilder.ComandoPersonaDataBuilder;

public class ComandoPersonaTest {
	@Test
	void getters() {
		ComandoPersona command = new ComandoPersona();
		assertNull(command.getId());
		assertNull(command.getEdad());
		assertNull(command.getNombre());
		assertNull(command.getNumeroIdentificacion());
	}

	@Test
	void setters() {
		ComandoPersona command = new ComandoPersonaDataBuilder().build();
		command.setId(null);
		command.setNombre(null);

		command.setNumeroIdentificacion(null);
		command.setEdad(null);

		assertNull(command.getId());
		assertNull(command.getNombre());
		assertNull(command.getNumeroIdentificacion());
		assertNull(command.getEdad());

	}

	@Test
	void one_arg_constructor() {
		ComandoPersona command = new ComandoPersona(1L, null, 25, 1097400317);
		assertNull(command.getNombre());
		assertNotNull(command.getId());
	}

}
