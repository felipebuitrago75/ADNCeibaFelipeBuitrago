package com.ceiba.consultorio.aplicacion.manejador.citas;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorObtenerCita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioObtenerCita;

import databuilder.ComandoCitaDataBuilder;

public class ManejadorObtenerCitaTest {
	@Test
	void execute() {

		ComandoCita command = new ComandoCitaDataBuilder().build();
		ServicioObtenerCita service = mock(ServicioObtenerCita.class);
		doReturn(command).when(service).ejecutar(1L);
		ManejadorObtenerCita handler = new ManejadorObtenerCita(service);

		assertNotNull(handler.ejecutar(1L));
	}
}
