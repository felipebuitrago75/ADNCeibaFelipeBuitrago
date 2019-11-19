package com.ceiba.consultorio.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.aplicacion.fabrica.FabricaPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorCrearPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioCrearPersona;

import databuilder.ComandoPersonaDataBuilder;

public class ManejadorCrearPersonaTest {
	@Test
	void execute() {
		ComandoPersona command = new ComandoPersonaDataBuilder().build();
		ServicioCrearPersona service = mock(ServicioCrearPersona.class);
		FabricaPersona fabricaPersona = new FabricaPersona();
		ManejadorCrearPersona handler = new ManejadorCrearPersona(service, fabricaPersona);

		assertDoesNotThrow(() -> handler.ejecutar(command));
	}
}
