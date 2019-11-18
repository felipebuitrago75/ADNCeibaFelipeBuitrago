package com.ceiba.consultorio.dominio.servicio.cita;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;

@Service
public class ServicioEliminarCita {
	private RepositorioCita repositorioCita;

	public ServicioEliminarCita(RepositorioCita repositorioCita) {

		this.repositorioCita = repositorioCita;
	}

	public void ejecutar(Long id) {
		this.repositorioCita.eliminar(id);
	}

}
