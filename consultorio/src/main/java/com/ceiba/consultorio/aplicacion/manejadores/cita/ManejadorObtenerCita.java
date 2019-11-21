package com.ceiba.consultorio.aplicacion.manejadores.cita;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioObtenerCita;

@Service
public class ManejadorObtenerCita {

	private final ServicioObtenerCita servicioObtenerCita;

	public ManejadorObtenerCita(ServicioObtenerCita servicioObtenerCita) {
		super();
		this.servicioObtenerCita = servicioObtenerCita;
	}

	@Transactional
	public ComandoCita ejecutar(Long id) {
		return this.servicioObtenerCita.ejecutar(id);
	}
}
