package com.ceiba.consultorio.aplicacion.manejadores.cita;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.servicio.cita.ServicioEliminarCita;

@Service
public class ManejadorEliminarCita {

	private final ServicioEliminarCita servicioEliminarCita;

	public ManejadorEliminarCita(ServicioEliminarCita servicioEliminarCita) {
		super();
		this.servicioEliminarCita = servicioEliminarCita;
	}

	public void ejecutar(Long id) {
		this.servicioEliminarCita.ejecutar(id);
	}
}
