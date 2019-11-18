package com.ceiba.consultorio.dominio.servicio.persona;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;

@Service
public class ServicioEliminarPersona {

	private RepositorioPersona repositorioPersona;

	public ServicioEliminarPersona(RepositorioPersona repositorioPersona) {

		this.repositorioPersona = repositorioPersona;
	}

	public void ejecutar(Long id) {
		this.repositorioPersona.eliminar(id);
	}

}
