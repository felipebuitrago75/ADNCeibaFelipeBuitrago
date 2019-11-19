package com.ceiba.consultorio.infraestructura.entidad;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

public class PersonaEntidadTest {
	@Test
	void getter_setter() {

		Long id = 1L;
		String nombre = "Felipe";
		Integer edad = 1;
		Integer numeroIdentificacion = 123;
		PersonaEntidad persona = new PersonaEntidad(id, nombre, edad, numeroIdentificacion);

		persona.setId(id);
		persona.setEdad(edad);
		persona.setNombre(nombre);
		persona.setNumeroIdentificacion(numeroIdentificacion);

		// assert
		assertEquals(id, persona.getId());
		assertEquals(edad, persona.getEdad());
		assertEquals(nombre, persona.getNombre());
		assertEquals(numeroIdentificacion, persona.getNumeroIdentificacion());
	}
}
