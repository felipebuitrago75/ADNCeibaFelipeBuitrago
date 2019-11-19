package com.ceiba.consultorio.dominio.servicio.cita;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;

public class ServicioObtenerCita {

	private RepositorioCita repositorioCita;

	public ServicioObtenerCita(RepositorioCita repositorioCita) {

		this.repositorioCita = repositorioCita;
	}

	public ComandoCita ejecutar(Long id) {
		return this.repositorioCita.buscarCita(id);
	}
}
