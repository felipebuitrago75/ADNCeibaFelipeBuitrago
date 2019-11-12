package com.ceiba.consultorio.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.modelo.Persona;

public interface RepositorioPersona {

	void guardar(Persona persona);

	void eliminar(Long id);

	List<ComandoPersona> buscarTodos();

	ComandoPersona buscarPersona(Long id);
}
