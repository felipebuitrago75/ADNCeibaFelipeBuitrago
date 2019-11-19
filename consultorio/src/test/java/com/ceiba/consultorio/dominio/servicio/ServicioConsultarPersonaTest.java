package com.ceiba.consultorio.dominio.servicio;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersona;

import databuilder.ComandoPersonaDataBuilder;

public class ServicioConsultarPersonaTest {

	@Test
	void obtenerPersonas() {
		RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);
		ComandoPersona personaCreada = new ComandoPersonaDataBuilder().build();
		Mockito.when(repositorioPersona.buscarPersona(1L)).thenReturn(personaCreada);
		ServicioObtenerPersona service = new ServicioObtenerPersona(repositorioPersona);

		ComandoPersona resultado = service.ejecutar(1L);

		assertNotNull(resultado);
	}

}