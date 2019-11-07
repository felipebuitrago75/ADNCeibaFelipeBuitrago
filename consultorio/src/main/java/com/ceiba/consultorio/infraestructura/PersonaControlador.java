package com.ceiba.consultorio.infraestructura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consultorio.dominio.PersonaServicio;

@RestController
public class PersonaControlador {
	@Autowired
	private PersonaServicio personaServicio;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/agregarPersona")
	public void agregarPersona(Persona persona) {
		personaServicio.agregarPersona(persona);
		;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/eliminarPersona/{ID}")
	public void eliminarPersona(@PathVariable(name = "ID") Long id) {
		personaServicio.eliminarPersona(id);
		;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerPersonas")
	public List<Persona> obtenerPersonas() {
		return personaServicio.obtenerPersonas();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/buscarPersona/{ID}")
	public Persona buscarPersona(@PathVariable(name = "ID") Long id) {
		return personaServicio.buscarPersonaId(id);
	}

}
