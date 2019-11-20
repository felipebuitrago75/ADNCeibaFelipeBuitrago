package com.ceiba.consultorio.infraestructura.repositorio;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.infraestructura.CitaRepositorioJPA;
import com.ceiba.consultorio.infraestructura.adaptador.repositorio.RepositorioCitaImpl;
import com.ceiba.consultorio.infraestructura.entidades.CitaEntidad;

import databuilder.CitaDataBuilder;
import databuilder.CitaEntidadDataBuilder;

public class CitaRepositorioTest {
	@Test
	void CrearCita() {
		CitaEntidad cita = new CitaEntidadDataBuilder().build();
		Cita citaModelo = new CitaDataBuilder().build();
		CitaRepositorioJPA citaRepositorio = mock(CitaRepositorioJPA.class);
		RepositorioCitaImpl repositorioCitaImpl = new RepositorioCitaImpl(citaRepositorio);

		assertDoesNotThrow(() -> citaRepositorio.save(cita));
		assertDoesNotThrow(() -> repositorioCitaImpl.guardar(citaModelo));

	}

	@Test
	void obtenerPersona() {
		CitaEntidad citaEntidad = new CitaEntidadDataBuilder().build();
		Optional<CitaEntidad> persona = Optional.of(citaEntidad);
		CitaRepositorioJPA citaRepositorio = mock(CitaRepositorioJPA.class);
		RepositorioCitaImpl repositorioCitaImpl = new RepositorioCitaImpl(citaRepositorio);

		when(citaRepositorio.findById(1L)).thenReturn(persona);

		assertNotNull(repositorioCitaImpl.buscarCita(1L));

	}

	@Test
	void obtenerPersonas() {
		CitaEntidad citaEntidad = new CitaEntidadDataBuilder().build();
		List<CitaEntidad> listaCitaEntidad = new ArrayList<>();
		listaCitaEntidad.add(citaEntidad);

		CitaRepositorioJPA citaRepositorio = mock(CitaRepositorioJPA.class);
		RepositorioCitaImpl repositorioCitaImpl = new RepositorioCitaImpl(citaRepositorio);

		when(citaRepositorio.findAll()).thenReturn(listaCitaEntidad);

		assertNotNull(repositorioCitaImpl.buscarTodos());

	}

	@Test
	void eliminarPersona() {

		CitaRepositorioJPA citaRepositorio = mock(CitaRepositorioJPA.class);
		RepositorioCitaImpl repositorioCitaImpl = new RepositorioCitaImpl(citaRepositorio);

		assertDoesNotThrow(() -> citaRepositorio.deleteById(1L));
		assertDoesNotThrow(() -> repositorioCitaImpl.eliminar(1L));

	}

}
