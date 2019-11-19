package com.ceiba.consultorio.dominio.servicio.cita;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;

import databuilder.ComandoCitaDataBuilder;

public class ServicioConsultarCitasTest {

	@Test
	void obtenerCitas() {
		RepositorioCita repositorioCita = mock(RepositorioCita.class);
		ComandoCita citaCreada = new ComandoCitaDataBuilder().build();
		List<ComandoCita> listaCitas = new ArrayList<ComandoCita>();
		listaCitas.add(citaCreada);
		Mockito.when(repositorioCita.buscarTodos()).thenReturn(listaCitas);
		ServicioObtenerCitas service = new ServicioObtenerCitas(repositorioCita);

		List<ComandoCita> results = service.ejecutar();

		assertFalse(results.isEmpty());
	}

}