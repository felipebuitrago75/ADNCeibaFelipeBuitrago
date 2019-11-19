package com.ceiba.consultorio.aplicacion.manejador.citas;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorObtenerCitas;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioObtenerCitas;

import databuilder.ComandoCitaDataBuilder;

public class ManejadorConsultarCitasTest {
	@Test
	void execute() {

		ComandoCita command = new ComandoCitaDataBuilder().build();
		List<ComandoCita> listaCitas = new ArrayList<>();
		listaCitas.add(command);
		ServicioObtenerCitas service = mock(ServicioObtenerCitas.class);
		doReturn(listaCitas).when(service).ejecutar();
		ManejadorObtenerCitas handler = new ManejadorObtenerCitas(service);

		// act - assert
		assertFalse(handler.ejecutar().isEmpty());
	}
}
