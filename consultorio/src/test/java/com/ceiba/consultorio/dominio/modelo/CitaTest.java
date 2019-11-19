package com.ceiba.consultorio.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.dominio.excepciones.PersonaException;

import databuilder.CitaDataBuilder;
import databuilder.PersonaDataBuilder;

public class CitaTest {

	@Test
	void instanciaIdFechaCitaNull() {
		assertThrows(PersonaException.class, () -> new CitaDataBuilder().fechaNull(1L));
	}

	@Test
	void instanciaEdadNull() {
		assertThrows(PersonaException.class, () -> new CitaDataBuilder().PersonaNull(1L));
	}

	@Test
	void instanciaCorrecta() {
		Cita cita = new CitaDataBuilder().build();

		assertNotNull(cita);
	}

	@Test
	void getter_setter() {

		Long id = 123L;
		LocalDate fechaCita = LocalDate.now();
		Double costoCita = 35000.00;
		Persona persona = new PersonaDataBuilder().build();
		Cita cita = new Cita(id, fechaCita, costoCita, persona);

		cita.setId(id);
		cita.setFechaCita(fechaCita);
		cita.setCostoCita(costoCita);
		cita.setPersona(persona);

		assertEquals(id, cita.getId());
		assertEquals(fechaCita, cita.getFechaCita());
		assertEquals(costoCita, cita.getCostoCita());
		assertEquals(persona, cita.getPersona());
	}
}
