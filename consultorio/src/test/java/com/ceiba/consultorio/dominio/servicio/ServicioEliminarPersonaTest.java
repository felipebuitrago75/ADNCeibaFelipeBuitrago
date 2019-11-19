package com.ceiba.consultorio.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioEliminarPersona;

public class ServicioEliminarPersonaTest {

	@Test
	void eliminarPersona() {
		RepositorioPersona repositorioPersona = Mockito.mock(RepositorioPersona.class);
		ServicioEliminarPersona servicio = new ServicioEliminarPersona(repositorioPersona);

		assertDoesNotThrow(() -> servicio.ejecutar(1L));
	}

}
