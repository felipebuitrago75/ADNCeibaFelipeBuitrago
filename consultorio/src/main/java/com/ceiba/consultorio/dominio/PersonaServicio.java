package com.ceiba.consultorio.dominio;

import java.util.List;

import com.ceiba.consultorio.infraestructura.Persona;

public interface PersonaServicio {

	public void agregarPersona(Persona persona);

	public void eliminarPersona(Long id);

	public Persona buscarPersonaId(Long id);

	public List<Persona> obtenerPersonas();

}
