package com.ceiba.consultorio.dominio.servicio.cita;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;

public class ServicioEliminarCitaTest {

	@Test
	void eliminarCita() {
		RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
		ServicioEliminarCita servicio = new ServicioEliminarCita(repositorioCita);

		assertDoesNotThrow(() -> servicio.ejecutar(1L));
	}

}
