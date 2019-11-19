package com.ceiba.consultorio.dominio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersonas;

public class ServicioConsultarPersonasTest {

	@Test
	public void obtenerPersonas() {

		ComandoPersona persona = new ComandoPersona(1L, "Felipe Buitrago", 25, 1097400317);
		List<ComandoPersona> listaPersonas = new ArrayList<>();
		listaPersonas.add(persona);
		ServicioObtenerPersonas servicioObtenerPersonas = Mockito.mock(ServicioObtenerPersonas.class);
		Mockito.when(servicioObtenerPersonas.ejecutar()).thenReturn(listaPersonas);

		RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
		Mockito.when(repositorioPersona.buscarTodos()).thenReturn(listaPersonas);

		List<ComandoPersona> personasObtenidas = servicioObtenerPersonas.ejecutar();

		// assert
		Assertions.assertNotNull(personasObtenidas);
		Assertions.assertNotNull(personasObtenidas.get(0));
		Assertions.assertEquals(1L, personasObtenidas.get(0).getId());

	}

}