package com.ceiba.consultorio.aplicacion.manejadores.cita;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.aplicacion.fabrica.FabricaCita;
import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioCrearCita;

@Component
public class ManejadorCrearCita {

	private final ServicioCrearCita servicioCrearCita;
	private final FabricaCita fabricaCita;

	public ManejadorCrearCita(ServicioCrearCita servicioCrearCita, FabricaCita fabricaCita) {

		this.servicioCrearCita = servicioCrearCita;
		this.fabricaCita = fabricaCita;
	}

	@Transactional
	public void ejecutar(ComandoCita comandoCita) {
		Cita cita = this.fabricaCita.crearCita(comandoCita);
		this.servicioCrearCita.ejecutar(cita);
	}
}
