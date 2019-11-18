package com.ceiba.consultorio.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;
import com.ceiba.consultorio.infraestructura.CitaRepositorioJPA;
import com.ceiba.consultorio.infraestructura.entidades.CitaEntidad;

@Repository
public class RepositorioCitaImpl implements RepositorioCita {

	private final CitaRepositorioJPA citaRepositorioJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioCitaImpl(CitaRepositorioJPA citaRepositorioJPA) {
		this.citaRepositorioJPA = citaRepositorioJPA;
	}

	@Override
	public void guardar(Cita cita) {
		CitaEntidad citaEntidad = modelMapper.map(cita, CitaEntidad.class);

		citaRepositorioJPA.save(citaEntidad);

	}

	@Override
	public void eliminar(Long id) {
		citaRepositorioJPA.deleteById(id);
	}

	@Override
	public List<ComandoCita> buscarTodos() {
		List<CitaEntidad> listaCitas = citaRepositorioJPA.findAll();
		List<ComandoCita> listaCitasComando = new ArrayList<>();
		for (CitaEntidad cita : listaCitas) {
			ComandoCita comandoCita = modelMapper.map(cita, ComandoCita.class);
			listaCitasComando.add(comandoCita);
		}
		return listaCitasComando;
	}

	@Override
	public ComandoCita buscarCita(Long id) {
		Optional<CitaEntidad> citaEntidad = citaRepositorioJPA.findById(id);
		return citaEntidad.isPresent() ? modelMapper.map(citaEntidad.get(), ComandoCita.class) : null;
	}

}
