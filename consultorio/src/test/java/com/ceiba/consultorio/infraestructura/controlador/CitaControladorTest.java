package com.ceiba.consultorio.infraestructura.controlador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorCrearCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorEliminarCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorObtenerCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorObtenerCitas;
import com.ceiba.consultorio.infraestructura.controladores.CitaControlador;

import databuilder.ComandoCitaDataBuilder;

public class CitaControladorTest {

	private ManejadorCrearCita manejadorCrearCita = mock(ManejadorCrearCita.class);
	private ManejadorEliminarCita manejadorEliminarCita = mock(ManejadorEliminarCita.class);
	private ManejadorObtenerCita manejadorObtenerCita = mock(ManejadorObtenerCita.class);
	private ManejadorObtenerCitas manejadorObtenerCitas = mock(ManejadorObtenerCitas.class);

	@Test
	void agregarCita() {
		ComandoCita cita = new ComandoCitaDataBuilder().build();

		CitaControlador service = new CitaControlador(manejadorCrearCita, manejadorEliminarCita, manejadorObtenerCitas,
				manejadorObtenerCita);

		assertDoesNotThrow(() -> service.agregarCita(cita));
	}

	@Test
	void eliminarCita() {
		CitaControlador service = new CitaControlador(manejadorCrearCita, manejadorEliminarCita, manejadorObtenerCitas,
				manejadorObtenerCita);
		assertDoesNotThrow(() -> service.eliminarCita(1L));

	}

	@Test
	void BuscarCita() {

		CitaControlador service = new CitaControlador(manejadorCrearCita, manejadorEliminarCita, manejadorObtenerCitas,
				manejadorObtenerCita);

		assertDoesNotThrow(() -> service.buscarCita(1L));
	}

	@Test
	void buscarCitas() {

		CitaControlador service = new CitaControlador(manejadorCrearCita, manejadorEliminarCita, manejadorObtenerCitas,
				manejadorObtenerCita);

		assertDoesNotThrow(() -> service.obtenerCitas());
	}
}
