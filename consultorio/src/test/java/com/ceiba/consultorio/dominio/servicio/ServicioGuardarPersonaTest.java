package com.ceiba.consultorio.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioCrearPersona;

import databuilder.PersonaDataBuilder;

public class ServicioGuardarPersonaTest {
	@Test
	void crearPersona() {
		Persona persona = new PersonaDataBuilder().build();
		RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);
		ServicioCrearPersona service = new ServicioCrearPersona(repositorioPersona);

		assertDoesNotThrow(() -> service.ejecutar(persona));
	}

}
