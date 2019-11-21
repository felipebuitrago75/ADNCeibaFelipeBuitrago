package com.ceiba.consultorio.aplicacion.manejadores.persona;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.consultorio.dominio.servicio.persona.ServicioEliminarPersona;

@Service
public class ManejadorEliminarPersona {

	private final ServicioEliminarPersona servicioEliminarPersona;

	public ManejadorEliminarPersona(ServicioEliminarPersona servicioEliminarPersona) {

		this.servicioEliminarPersona = servicioEliminarPersona;
	}

	@Transactional
	public void ejecutar(Long id) {
		this.servicioEliminarPersona.ejecutar(id);
	}
}
