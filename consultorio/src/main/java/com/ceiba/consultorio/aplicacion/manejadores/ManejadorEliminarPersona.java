package com.ceiba.consultorio.aplicacion.manejadores;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.servicio.ServicioEliminarPersona;
@Service
public class ManejadorEliminarPersona {

	private final ServicioEliminarPersona servicioEliminarPersona;

	public ManejadorEliminarPersona(ServicioEliminarPersona servicioEliminarPersona) {

		this.servicioEliminarPersona = servicioEliminarPersona;
	}

	public void ejecutar(Long id) {
		this.servicioEliminarPersona.ejecutar(id);
	}
}
