package com.ceiba.consultorio.aplicacion.manejador;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorObtenerPersonas;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersonas;

import databuilder.ComandoPersonaDataBuilder;

public class ManejadorConsultarPersonasTest {
	@Test
	void execute() {

		ComandoPersona command = new ComandoPersonaDataBuilder().build();
		List<ComandoPersona> listaPersonas = new ArrayList<>();
		listaPersonas.add(command);
		ServicioObtenerPersonas service = mock(ServicioObtenerPersonas.class);
		doReturn(listaPersonas).when(service).ejecutar();
		ManejadorObtenerPersonas handler = new ManejadorObtenerPersonas(service);

		// act - assert
		assertFalse(handler.ejecutar().isEmpty());
	}
}
