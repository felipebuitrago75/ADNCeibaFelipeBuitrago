package com.ceiba.consultorio.aplicacion.manejadores.persona;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersonas;

@Service
public class ManejadorObtenerPersonas {

	private final ServicioObtenerPersonas servicioObtenerPersonas;

	public ManejadorObtenerPersonas(ServicioObtenerPersonas servicioObtenerPersonas) {

		this.servicioObtenerPersonas = servicioObtenerPersonas;
	}

	@Transactional
	public List<ComandoPersona> ejecutar() {
		return this.servicioObtenerPersonas.ejecutar();
	}
}
