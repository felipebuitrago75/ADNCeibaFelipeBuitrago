package com.ceiba.consultorio.aplicacion;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.PersonaServicio;
import com.ceiba.consultorio.infraestructura.PersonaRepositorioJPA;
import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

@Service
public class PersonaServicioImpl implements PersonaServicio {

	@Autowired
	private PersonaRepositorioJPA personaRepositorioJPA;
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public void agregarPersona(PersonaEntidad personaEntidad) {

		try {
			Optional<PersonaEntidad> optLibro = personaRepositorioJPA.findById(personaEntidad.getId());
			PersonaEntidad libroActualizar = optLibro.get();
			personaRepositorioJPA.save(libroActualizar);
		} catch (NoSuchElementException nse) {

			personaRepositorioJPA.save(personaEntidad);
		}

	}

	@Override
	public void eliminarPersona(Long id) {
		personaRepositorioJPA.deleteById(id);
	}

	@Override
	public PersonaEntidad buscarPersonaId(Long id) {
		try {
			Optional<PersonaEntidad> optLibro = personaRepositorioJPA.findById(id);
			return optLibro.get();
		} catch (NoSuchElementException nse) {
			return null;
		}

	}

	@Override
	public List<PersonaEntidad> obtenerPersonas() {
		String consultaLibrosDisponibles = "SELECT p FROM Persona p ";
		return entityManager.createQuery(consultaLibrosDisponibles).getResultList();
	}

	public boolean esPalindromo(String isbn) {

		// Variable con el valor a retornar incial
		boolean valor = true;
		int i, indice;
		String cadenaIsbn = "";
		for (int x = 0; x < isbn.length(); x++) {
			if (isbn.charAt(x) != ' ')
				cadenaIsbn += isbn.charAt(x);
		}
		isbn = cadenaIsbn;
		indice = isbn.length();
		// Se recorre el arreglo de caracteres de adelante hacia atras y de atras hacia
		// adelante
		for (i = 0; i < (isbn.length()); i++) {
			if (isbn.substring(i, i + 1).equals(isbn.substring(indice - 1, indice)) == false) {
				valor = false;
				break;
			}
			indice--;
		}
		return valor;
	}

}
