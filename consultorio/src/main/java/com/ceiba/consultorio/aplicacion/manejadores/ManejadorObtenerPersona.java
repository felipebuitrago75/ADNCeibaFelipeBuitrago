package com.ceiba.consultorio.aplicacion.manejadores;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.servicio.ServicioObtenerPersona;

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
