package com.ceiba.consultorio.aplicacion.manejador;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorObtenerPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersona;

import databuilder.ComandoPersonaDataBuilder;

public class ManejadorObtenerPersonaTest {
	@Test
	void execute() {

		ComandoPersona command = new ComandoPersonaDataBuilder().build();
		ServicioObtenerPersona service = mock(ServicioObtenerPersona.class);
		doReturn(command).when(service).ejecutar(1L);
		ManejadorObtenerPersona handler = new ManejadorObtenerPersona(service);

		// act - assert
		assertNotNull(handler.ejecutar(1L));
	}
}
