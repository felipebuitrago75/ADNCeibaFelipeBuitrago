package com.ceiba.consultorio.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.dominio.excepciones.PersonaException;

import databuilder.PersonaDataBuilder;

public class PersonaTest {

	@Test
	void instanciaIdNombreNull() {
		assertThrows(PersonaException.class, () -> new PersonaDataBuilder().nombreNull(1L));
	}

	@Test
	void instanciaEdadNull() {
		assertThrows(PersonaException.class, () -> new PersonaDataBuilder().edadNull(1L));
	}

	@Test
	void instanciaNumeroIdentificacionNull() {
		assertThrows(PersonaException.class, () -> new PersonaDataBuilder().edadNull(1L));
	}

	@Test
	void instanciaCorrecta() {
		Persona persona = new PersonaDataBuilder().build();

		assertNotNull(persona);
	}

	@Test
	void getter_setter() {

		Long id = 123L;
		String nombre = "Felipe";
		Integer edad = 25;
		Integer numeroIdentificacion = 1097400317;
		Persona persona = new Persona(id, nombre, edad, numeroIdentificacion);

		persona.setId(id);
		persona.setNombre(nombre);
		persona.setEdad(edad);
		persona.setNumeroIdentificacion(numeroIdentificacion);

		assertEquals(id, persona.getId());
		assertEquals(nombre, persona.getNombre());
		assertEquals(edad, persona.getEdad());
		assertEquals(numeroIdentificacion, persona.getNumeroIdentificacion());
	}
}
