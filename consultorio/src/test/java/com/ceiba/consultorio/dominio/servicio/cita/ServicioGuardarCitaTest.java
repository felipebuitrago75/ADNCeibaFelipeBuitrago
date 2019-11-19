package com.ceiba.consultorio.dominio.servicio.cita;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;

import databuilder.CitaDataBuilder;

public class ServicioGuardarCitaTest {
	@Test
	void crearCita() {
		Cita cita = new CitaDataBuilder().build();
		RepositorioCita repositorioCita = mock(RepositorioCita.class);
		ServicioCrearCita service = new ServicioCrearCita(repositorioCita);

		assertDoesNotThrow(() -> service.ejecutar(cita));
	}

}
