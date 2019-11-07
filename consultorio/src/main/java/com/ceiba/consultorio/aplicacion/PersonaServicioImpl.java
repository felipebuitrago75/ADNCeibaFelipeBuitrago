package com.ceiba.consultorio.aplicacion;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.PersonaServicio;
import com.ceiba.consultorio.dominio.PersonaRepositorio;
import com.ceiba.consultorio.infraestructura.Persona;

@Service
public class PersonaServicioImpl implements PersonaServicio {

	@Autowired
	private PersonaRepositorio personaRepositorio;
	@PersistenceContext
	private EntityManager entityManager;

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
	public static final String PALIDROMO = "los libros pal?ndromos solo se pueden utilizar en la biblioteca";
	public static final String PRESTADO = "No hay libros disponibles para prestar";
	public static final String NO_EXISTE = "El libro no existe";

	@Override
	public void agregarPersona(Persona persona) {

		try {
			Optional<Persona> optLibro = personaRepositorio.findById(persona.getId());
			Persona libroActualizar = optLibro.get();
			personaRepositorio.save(libroActualizar);
		} catch (NoSuchElementException nse) {

			personaRepositorio.save(persona);
		}

	}

	@Override
	public void eliminarPersona(Long id) {
		personaRepositorio.deleteById(id);
	}

	@Override
	public Persona buscarPersonaId(Long id) {
		try {
			Optional<Persona> optLibro = personaRepositorio.findById(id);
			return optLibro.get();
		} catch (NoSuchElementException nse) {
			return null;
		}

	}

	@Override
	public List<Persona> obtenerPersonas() {
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
