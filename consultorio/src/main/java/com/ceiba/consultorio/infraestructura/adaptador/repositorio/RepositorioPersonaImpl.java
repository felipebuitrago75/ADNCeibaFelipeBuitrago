package com.ceiba.consultorio.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
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

	@Override
	public void eliminar(Long id) {
		repositorioPersonaJpa.deleteById(id);
	}

	@Override
	public List<ComandoPersona> buscarTodos() {
		List<PersonaEntidad> listaPersonas = repositorioPersonaJpa.findAll();
		List<ComandoPersona> listaPersonasComando = new ArrayList<>();
		for (PersonaEntidad persona : listaPersonas) {
			ComandoPersona comandoPersona = modelMapper.map(persona, ComandoPersona.class);
			listaPersonasComando.add(comandoPersona);
		}
		return listaPersonasComando;
	}

	@Override
	public ComandoPersona buscarPersona(Long id) {
		Optional<PersonaEntidad> personaEntidad = repositorioPersonaJpa.findById(id);
		return personaEntidad.isPresent() ? modelMapper.map(personaEntidad.get(), ComandoPersona.class) : null;
	}

}
