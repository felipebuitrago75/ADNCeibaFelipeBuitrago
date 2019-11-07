package com.ceiba.consultorio.infraestructura;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.aplicacion.manejadores.ManejadorCrearPersona;

@RestController
@RequestMapping(value = "/consultorio")
public class PersonaControlador {

	private final ManejadorCrearPersona manejadorCrearPersona;

	public PersonaControlador(ManejadorCrearPersona manejadorCrearPersona) {
		this.manejadorCrearPersona = manejadorCrearPersona;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/agregarPersona")
	public void agregarPersona(@RequestBody ComandoPersona comandoPersona) {
		this.manejadorCrearPersona.ejecutar(comandoPersona);

	}
/**
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/eliminarPersona/{ID}")
	public void eliminarPersona(@PathVariable(name = "ID") Long id) {
		personaServicio.eliminarPersona(id);
		;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerPersonas")
	public List<PersonaEntidad> obtenerPersonas() {
		return personaServicio.obtenerPersonas();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/buscarPersona/{ID}")
	public PersonaEntidad buscarPersona(@PathVariable(name = "ID") Long id) {
		return personaServicio.buscarPersonaId(id);
	}
*/
}
