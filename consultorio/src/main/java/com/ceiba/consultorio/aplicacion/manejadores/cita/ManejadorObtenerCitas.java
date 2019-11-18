package com.ceiba.consultorio.aplicacion.manejadores.cita;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioObtenerCitas;

@Service
public class ManejadorObtenerCitas {

	private final ServicioObtenerCitas servicioObtenerCitas;

	public ManejadorObtenerCitas(ServicioObtenerCitas servicioObtenerCitas) {
		super();
		this.servicioObtenerCitas = servicioObtenerCitas;
	}

	public List<ComandoCita> ejecutar() {
		return this.servicioObtenerCitas.ejecutar();
	}
}
