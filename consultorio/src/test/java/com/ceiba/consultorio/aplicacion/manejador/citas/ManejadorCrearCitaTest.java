package com.ceiba.consultorio.aplicacion.manejador.citas;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.aplicacion.fabrica.FabricaCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorCrearCita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioCrearCita;

import databuilder.ComandoCitaDataBuilder;

public class ManejadorCrearCitaTest {
	@Test
	void execute() {
		ComandoCita command = new ComandoCitaDataBuilder().build();
		ServicioCrearCita service = mock(ServicioCrearCita.class);
		FabricaCita fabricaCita = new FabricaCita();
		ManejadorCrearCita handler = new ManejadorCrearCita(service, fabricaCita);

		assertDoesNotThrow(() -> handler.ejecutar(command));
	}
}
