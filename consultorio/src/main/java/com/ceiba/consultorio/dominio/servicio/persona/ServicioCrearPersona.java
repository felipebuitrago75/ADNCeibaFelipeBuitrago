package com.ceiba.consultorio.dominio.servicio.persona;

import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;

public class ServicioCrearPersona {

	private RepositorioPersona repositorioPersona;

	public ServicioCrearPersona(RepositorioPersona repositorioPersona) {

		this.repositorioPersona = repositorioPersona;
	}

	public void ejecutar(Persona persona) {
		this.repositorioPersona.guardar(persona);
	}
}
