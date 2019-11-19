package com.ceiba.consultorio.infraestructura.entidad;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.infraestructura.entidades.CitaEntidad;
import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

import databuilder.PersonaEntidadDataBuilder;

public class CitaEntidadTest {
	@Test
	void getter_setter() {

		Long id = 1L;
		LocalDate fechaCita = LocalDate.now();
		Double costoCita = 35000.00;
		PersonaEntidad persona = new PersonaEntidadDataBuilder().build();
		CitaEntidad cita = new CitaEntidad(id, fechaCita, costoCita, persona);

		cita.setId(id);
		cita.setFechaCita(fechaCita);
		cita.setCostoCita(costoCita);
		cita.setPersona(persona);

		// assert
		assertEquals(id, cita.getId());
		assertEquals(fechaCita, cita.getFechaCita());
		assertEquals(costoCita, cita.getCostoCita());
		assertEquals(persona, cita.getPersona());
	}

}
