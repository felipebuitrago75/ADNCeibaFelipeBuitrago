package com.ceiba.consultorio.dominio;

import java.util.List;

import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

public interface PersonaServicio {

	public void agregarPersona(PersonaEntidad personaEntidad);

	public void eliminarPersona(Long id);

	public PersonaEntidad buscarPersonaId(Long id);

	public List<PersonaEntidad> obtenerPersonas();

}
