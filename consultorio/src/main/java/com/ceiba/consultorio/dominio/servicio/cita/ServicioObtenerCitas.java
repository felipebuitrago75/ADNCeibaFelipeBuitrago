package com.ceiba.consultorio.dominio.servicio.cita;

import java.util.List;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;

public class ServicioObtenerCitas {

	private RepositorioCita repositorioCita;

	public ServicioObtenerCitas(RepositorioCita repositorioCita) {

		this.repositorioCita = repositorioCita;
	}

	public List<ComandoCita> ejecutar() {
		return this.repositorioCita.buscarTodos();
	}
}
