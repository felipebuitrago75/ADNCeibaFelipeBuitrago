package com.ceiba.consultorio.dominio.servicio.cita;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;

import databuilder.ComandoCitaDataBuilder;

public class ServicioConsultarCitaTest {

	@Test
	void obtenerCita() {
		RepositorioCita repositorioCita = mock(RepositorioCita.class);
		ComandoCita citaCreada = new ComandoCitaDataBuilder().build();
		Mockito.when(repositorioCita.buscarCita(1L)).thenReturn(citaCreada);
		ServicioObtenerCita service = new ServicioObtenerCita(repositorioCita);

		ComandoCita resultado = service.ejecutar(1L);

		assertNotNull(resultado);
	}

}