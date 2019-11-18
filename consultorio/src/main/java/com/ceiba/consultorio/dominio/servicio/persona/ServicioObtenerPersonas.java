package com.ceiba.consultorio.dominio.servicio.persona;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;

@Service
public class ServicioObtenerPersonas {

	private RepositorioPersona repositorioPersona;

	public ServicioObtenerPersonas(RepositorioPersona repositorioPersona) {

		this.repositorioPersona = repositorioPersona;
	}

	public List<ComandoPersona> ejecutar() {
		return this.repositorioPersona.buscarTodos();
	}
}
