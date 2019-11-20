package com.ceiba.consultorio.infraestructura.repositorio;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.infraestructura.PersonaRepositorioJPA;
import com.ceiba.consultorio.infraestructura.adaptador.repositorio.RepositorioPersonaImpl;
import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

import databuilder.PersonaDataBuilder;
import databuilder.PersonaEntidadDataBuilder;

public class PersonaRepositorioTest {
	@Test
	void CrearPersona() {
		PersonaEntidad personaEntidad = new PersonaEntidadDataBuilder().build();
		Persona persona = new PersonaDataBuilder().build();
		PersonaRepositorioJPA personaRepositorio = mock(PersonaRepositorioJPA.class);
		RepositorioPersonaImpl repositorioPersonaImpl = new RepositorioPersonaImpl(personaRepositorio);

		assertDoesNotThrow(() -> personaRepositorio.save(personaEntidad));
		assertDoesNotThrow(() -> repositorioPersonaImpl.guardar(persona));

	}

	@Test
	void obtenerPersona() {
		PersonaEntidad personaEntidad = new PersonaEntidadDataBuilder().build();
		Optional<PersonaEntidad> persona = Optional.of(personaEntidad);
		PersonaRepositorioJPA personaRepositorio = mock(PersonaRepositorioJPA.class);
		RepositorioPersonaImpl repositorioPersonaImpl = new RepositorioPersonaImpl(personaRepositorio);

		when(personaRepositorio.findById(1L)).thenReturn(persona);

		assertNotNull(repositorioPersonaImpl.buscarPersona(1L));

	}

	@Test
	void obtenerPersonas() {
		PersonaEntidad personaEntidad = new PersonaEntidadDataBuilder().build();
		List<PersonaEntidad> listaPersonaEntidad = new ArrayList<>();
		listaPersonaEntidad.add(personaEntidad);

		PersonaRepositorioJPA personaRepositorio = mock(PersonaRepositorioJPA.class);
		RepositorioPersonaImpl repositorioPersonaImpl = new RepositorioPersonaImpl(personaRepositorio);

		when(personaRepositorio.findAll()).thenReturn(listaPersonaEntidad);

		assertNotNull(repositorioPersonaImpl.buscarTodos());

	}

	@Test
	void eliminarPersona() {

		PersonaRepositorioJPA personaRepositorio = mock(PersonaRepositorioJPA.class);
		RepositorioPersonaImpl repositorioPersonaImpl = new RepositorioPersonaImpl(personaRepositorio);

		assertDoesNotThrow(() -> personaRepositorio.findById(1L));
		assertDoesNotThrow(() -> repositorioPersonaImpl.eliminar(1L));

	}

}