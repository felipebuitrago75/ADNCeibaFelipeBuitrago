package com.ceiba.consultorio.aplicacion.manejadores.cita;

import org.springframework.stereotype.Component;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.aplicacion.fabrica.FabricaCita;
import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioCrearCita;

@Component
public class ManejadorCrearCita {

	private final ServicioCrearCita servicioCrearCita;
	private final FabricaCita fabricaCita;

	public ManejadorCrearCita(ServicioCrearCita servicioCrearCita, FabricaCita fabricaCita) {
		super();
		this.servicioCrearCita = servicioCrearCita;
		this.fabricaCita = fabricaCita;
	}

	public void ejecutar(ComandoCita comandoCita) {
		Cita cita = this.fabricaCita.crearCita(comandoCita);
		this.servicioCrearCita.ejecutar(cita);
	}
}
