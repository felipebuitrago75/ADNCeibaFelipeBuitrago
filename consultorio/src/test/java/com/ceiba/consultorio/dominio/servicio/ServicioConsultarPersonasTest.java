package com.ceiba.consultorio.dominio.servicio;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersonas;

import databuilder.ComandoPersonaDataBuilder;

public class ServicioConsultarPersonasTest {

	@Test
	void obtenerPersonas() {
		RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);
		ComandoPersona personaCreada = new ComandoPersonaDataBuilder().build();
		List<ComandoPersona> listaPersonas = new ArrayList<ComandoPersona>();
		listaPersonas.add(personaCreada);
		Mockito.when(repositorioPersona.buscarTodos()).thenReturn(listaPersonas);
		ServicioObtenerPersonas service = new ServicioObtenerPersonas(repositorioPersona);

		List<ComandoPersona> results = service.ejecutar();

		assertFalse(results.isEmpty());
	}

}