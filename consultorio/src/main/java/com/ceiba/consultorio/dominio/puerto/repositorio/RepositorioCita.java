package com.ceiba.consultorio.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.modelo.Cita;

public interface RepositorioCita {

	void guardar(Cita cita);

	void eliminar(Long id);

	List<ComandoCita> buscarTodos();

	ComandoCita buscarCita(Long id);
}
