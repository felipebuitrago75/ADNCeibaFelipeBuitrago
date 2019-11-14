package com.ceiba.consultorio.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.modelo.Persona;

@Component
public class FabricaPersona {

	public Persona crearPersona(ComandoPersona comandoPersona) {
		return new Persona(comandoPersona.getId(), comandoPersona.getNombre(), comandoPersona.getEdad(),
				comandoPersona.getNumeroIdentificacion());
	}

}
