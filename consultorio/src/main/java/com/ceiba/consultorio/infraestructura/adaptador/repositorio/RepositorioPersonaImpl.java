package com.ceiba.consultorio.infraestructura.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;
import com.ceiba.consultorio.infraestructura.PersonaRepositorioJPA;
import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

@Repository
public class RepositorioPersonaImpl implements RepositorioPersona {

	private final PersonaRepositorioJPA repositorioPersonaJpa;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioPersonaImpl(PersonaRepositorioJPA repositorioPersonaJpa) {
		this.repositorioPersonaJpa = repositorioPersonaJpa;
	}

	@Override
	public void guardar(Persona persona) {
		PersonaEntidad personaEntidad = modelMapper.map(persona, PersonaEntidad.class);
		repositorioPersonaJpa.save(personaEntidad);

	}

}
