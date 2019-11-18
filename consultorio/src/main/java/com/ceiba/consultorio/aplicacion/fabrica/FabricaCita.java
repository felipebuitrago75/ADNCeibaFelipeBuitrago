package com.ceiba.consultorio.aplicacion.fabrica;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.modelo.Persona;

@Component
public class FabricaCita {

	private ModelMapper modelMapper = new ModelMapper();

	public Cita crearCita(ComandoCita comandoCita) {
		return new Cita(comandoCita.getId(), comandoCita.getFechaCita(), comandoCita.getCostoCita(),
				modelMapper.map(comandoCita.getPersona(), Persona.class));
	}

}
