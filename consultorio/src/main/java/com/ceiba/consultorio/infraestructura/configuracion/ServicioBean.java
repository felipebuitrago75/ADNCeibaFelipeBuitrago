package com.ceiba.consultorio.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioPersona;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioCrearCita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioEliminarCita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioObtenerCita;
import com.ceiba.consultorio.dominio.servicio.cita.ServicioObtenerCitas;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioCrearPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioEliminarPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersona;
import com.ceiba.consultorio.dominio.servicio.persona.ServicioObtenerPersonas;

@Configuration
public class ServicioBean {

	@Bean
	public ServicioCrearCita crearServicioCrearCita(RepositorioCita repositorioCita) {
		return new ServicioCrearCita(repositorioCita);
	}

	@Bean
	public ServicioEliminarCita crearServicioEliminarCita(RepositorioCita repositorioCita) {
		return new ServicioEliminarCita(repositorioCita);
	}

	@Bean
	public ServicioObtenerCita crearServicioObtenerCita(RepositorioCita repositorioCita) {
		return new ServicioObtenerCita(repositorioCita);
	}

	@Bean
	public ServicioObtenerCitas crearServicioObtenerCitas(RepositorioCita repositorioCita) {
		return new ServicioObtenerCitas(repositorioCita);
	}

	@Bean
	public ServicioCrearPersona crearServicioCrearPersona(RepositorioPersona repositorioPersona) {

		return new ServicioCrearPersona(repositorioPersona);
	}

	@Bean
	public ServicioEliminarPersona crearServicioEliminarPersona(RepositorioPersona repositorioPersona) {

		return new ServicioEliminarPersona(repositorioPersona);
	}

	@Bean
	public ServicioObtenerPersonas crearServicioObtenerPersonas(RepositorioPersona repositorioPersona) {

		return new ServicioObtenerPersonas(repositorioPersona);
	}

	@Bean
	public ServicioObtenerPersona crearServicioObtenerPersona(RepositorioPersona repositorioPersona) {

		return new ServicioObtenerPersona(repositorioPersona);
	}
}
