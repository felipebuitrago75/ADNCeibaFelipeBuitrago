package com.ceiba.consultorio.dominio.servicio.persona;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;

@Service
public class ServicioCrearPersona {

	private RepositorioPersona repositorioPersona;

	public ServicioCrearPersona(RepositorioPersona repositorioPersona) {

		this.repositorioPersona = repositorioPersona;
	}

	public void ejecutar(Persona persona) {
		this.repositorioPersona.guardar(persona);
	}
}
