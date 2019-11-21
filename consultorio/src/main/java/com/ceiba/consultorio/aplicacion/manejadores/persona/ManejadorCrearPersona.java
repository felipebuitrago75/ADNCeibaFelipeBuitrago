package com.ceiba.consultorio.aplicacion.manejadores.persona;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.aplicacion.fabrica.FabricaPersona;
import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioCrearPersona;

@Component
public class ManejadorCrearPersona {

	private final ServicioCrearPersona servicioCrearPersona;
	private final FabricaPersona fabricaPersona;

	public ManejadorCrearPersona(ServicioCrearPersona servicioCrearPersona, FabricaPersona fabricaPersona) {

		this.servicioCrearPersona = servicioCrearPersona;
		this.fabricaPersona = fabricaPersona;
	}

	@Transactional
	public void ejecutar(ComandoPersona comandoPersona) {
		Persona persona = this.fabricaPersona.crearPersona(comandoPersona);
		this.servicioCrearPersona.ejecutar(persona);
	}
}
