package com.ceiba.consultorio.aplicacion.manejadores.persona;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersona;

@Service
public class ManejadorObtenerPersona {

	private final ServicioObtenerPersona servicioObtenerPersona;

	public ManejadorObtenerPersona(ServicioObtenerPersona servicioObtenerPersona) {

		this.servicioObtenerPersona = servicioObtenerPersona;
	}

	public ComandoPersona ejecutar(Long id) {
		return this.servicioObtenerPersona.ejecutar(id);
	}
}
