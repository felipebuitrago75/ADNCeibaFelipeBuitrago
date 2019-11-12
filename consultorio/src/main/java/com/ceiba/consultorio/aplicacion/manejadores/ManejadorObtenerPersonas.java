package com.ceiba.consultorio.aplicacion.manejadores;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.servicio.ServicioObtenerPersonas;
@Service
public class ManejadorObtenerPersonas {

	private final ServicioObtenerPersonas servicioObtenerPersonas;

	public ManejadorObtenerPersonas(ServicioObtenerPersonas servicioObtenerPersonas) {

		this.servicioObtenerPersonas = servicioObtenerPersonas;
	}

	public List<ComandoPersona> ejecutar() {
		return this.servicioObtenerPersonas.ejecutar();
	}
}
