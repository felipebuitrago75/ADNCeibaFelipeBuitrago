package com.ceiba.consultorio.aplicacion.comando;

import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import databuilder.ComandoCitaDataBuilder;

public class ComandoCitaTest {
	@Test
	void getters() {
		ComandoCita command = new ComandoCita();
		assertNull(command.getId());
		assertNull(command.getCostoCita());
		assertNull(command.getFechaCita());
		assertNull(command.getPersona());
	}

	@Test
	void setters() {
		ComandoCita command = new ComandoCitaDataBuilder().build();
		command.setId(null);
		command.setFechaCita(null);

		command.setCostoCita(null);
		command.setPersona(null);

		assertNull(command.getId());
		assertNull(command.getCostoCita());
		assertNull(command.getFechaCita());
		assertNull(command.getPersona());

	}

}
