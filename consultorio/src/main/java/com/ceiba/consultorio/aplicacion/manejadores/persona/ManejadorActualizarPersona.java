package com.ceiba.consultorio.aplicacion.manejadores.persona;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.aplicacion.fabrica.FabricaPersona;
import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioCrearPersona;

public class ManejadorActualizarPersona {


	private final ServicioCrearPersona servicioCrearPersona;
	private final FabricaPersona fabricaPersona;

	public ManejadorActualizarPersona(ServicioCrearPersona servicioCrearPersona, FabricaPersona fabricaPersona) {

		this.servicioCrearPersona = servicioCrearPersona;
		this.fabricaPersona = fabricaPersona;
	}

	public void ejecutar(ComandoPersona comandoPersona) {
		Persona persona = this.fabricaPersona.crearPersona(comandoPersona);
		this.servicioCrearPersona.ejecutar(persona);
	}

}
