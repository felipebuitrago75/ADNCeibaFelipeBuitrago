package com.ceiba.consultorio.aplicacion.manejador.citas;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorEliminarCita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioEliminarCita;

public class ManejadorEliminarCitaTest {
	@Test
	void execute() {
		ServicioEliminarCita service = mock(ServicioEliminarCita.class);
		ManejadorEliminarCita handler = new ManejadorEliminarCita(service);

		assertDoesNotThrow(() -> handler.ejecutar(1L));
	}

}
