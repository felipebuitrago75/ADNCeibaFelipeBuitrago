package com.ceiba.consultorio.infraestructura.controlador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorCrearPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorEliminarPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorObtenerPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorObtenerPersonas;
import com.ceiba.consultorio.infraestructura.controladores.PersonaControlador;

import databuilder.ComandoPersonaDataBuilder;

public class PersonaControladorTest {

	private ManejadorCrearPersona manejadorCrearPersona = mock(ManejadorCrearPersona.class);
	private ManejadorEliminarPersona manejadorEliminarPersona = mock(ManejadorEliminarPersona.class);
	private ManejadorObtenerPersona manejadorObtenerPersona = mock(ManejadorObtenerPersona.class);
	private ManejadorObtenerPersonas manejadorObtenerPersonas = mock(ManejadorObtenerPersonas.class);

	@Test
	void agregarPersona() {
		ComandoPersona persona = new ComandoPersonaDataBuilder().build();

		PersonaControlador service = new PersonaControlador(manejadorCrearPersona, manejadorEliminarPersona,
				manejadorObtenerPersonas, manejadorObtenerPersona);

		assertDoesNotThrow(() -> service.agregarPersona(persona));
	}

	@Test
	void eliminarPersona() {
		PersonaControlador service = new PersonaControlador(manejadorCrearPersona, manejadorEliminarPersona,
				manejadorObtenerPersonas, manejadorObtenerPersona);
		assertDoesNotThrow(() -> service.eliminarPersona(1L));

	}

	@Test
	void buscarPersona() {
		PersonaControlador service = new PersonaControlador(manejadorCrearPersona, manejadorEliminarPersona,
				manejadorObtenerPersonas, manejadorObtenerPersona);
		assertDoesNotThrow(() -> service.buscarPersona(1L));

	}

	@Test
	void buscarPersonas() {
		PersonaControlador service = new PersonaControlador(manejadorCrearPersona, manejadorEliminarPersona,
				manejadorObtenerPersonas, manejadorObtenerPersona);
		assertDoesNotThrow(() -> service.obtenerPersonas());

	}
}
