package com.ceiba.consultorio.dominio.servicio.persona;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;

public class ServicioObtenerPersona {

	private RepositorioPersona repositorioPersona;

	public ServicioObtenerPersona(RepositorioPersona repositorioPersona) {

		this.repositorioPersona = repositorioPersona;
	}

	public ComandoPersona ejecutar(Long id) {
		return this.repositorioPersona.buscarPersona(id);
	}
}
