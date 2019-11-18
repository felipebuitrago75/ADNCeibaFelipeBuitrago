package com.ceiba.consultorio.infraestructura.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorCrearPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorEliminarPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorObtenerPersona;
import com.ceiba.consultorio.aplicacion.manejadores.persona.ManejadorObtenerPersonas;

@RestController
@RequestMapping(value = "/consultorio")
public class PersonaControlador {

	private final ManejadorCrearPersona manejadorCrearPersona;

	private final ManejadorEliminarPersona manejadorEliminarPersona;

	private final ManejadorObtenerPersonas manejadorObtenerPersonas;

	private final ManejadorObtenerPersona manejadorObtenerPersona;

	public PersonaControlador(ManejadorCrearPersona manejadorCrearPersona,
			ManejadorEliminarPersona manejadorEliminarPersona, ManejadorObtenerPersonas manejadorObtenerPersonas,
			ManejadorObtenerPersona manejadorObtenerPersona) {
		this.manejadorCrearPersona = manejadorCrearPersona;
		this.manejadorEliminarPersona = manejadorEliminarPersona;
		this.manejadorObtenerPersonas = manejadorObtenerPersonas;
		this.manejadorObtenerPersona = manejadorObtenerPersona;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/agregarPersona")
	public void agregarPersona(@RequestBody ComandoPersona comandoPersona) {
		this.manejadorCrearPersona.ejecutar(comandoPersona);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/eliminarPersona/{ID}")
	public void eliminarPersona(@PathVariable(name = "ID") Long id) {
		this.manejadorEliminarPersona.ejecutar(id);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/obtenerPersonas")
	public List<ComandoPersona> obtenerPersonas() {
		return this.manejadorObtenerPersonas.ejecutar();

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/buscarPersona/{ID}")
	public ComandoPersona buscarPersona(@PathVariable(name = "ID") Long id) {
		return this.manejadorObtenerPersona.ejecutar(id);

	}

}
