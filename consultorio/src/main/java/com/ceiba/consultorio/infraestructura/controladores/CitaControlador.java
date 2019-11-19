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

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorCrearCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorEliminarCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorObtenerCita;
import com.ceiba.consultorio.aplicacion.manejadores.cita.ManejadorObtenerCitas;

@RestController
@RequestMapping(value = "/cita")
public class CitaControlador {

	private final ManejadorCrearCita manejadorCrearCita;

	private final ManejadorEliminarCita manejadorEliminarCita;

	private final ManejadorObtenerCitas manejadorObtenerCitas;

	private final ManejadorObtenerCita manejadorObtenerCita;

	public CitaControlador(ManejadorCrearCita manejadorCrearCita, ManejadorEliminarCita manejadorEliminarCita,
			ManejadorObtenerCitas manejadorObtenerCitas, ManejadorObtenerCita manejadorObtenerCita) {
		this.manejadorCrearCita = manejadorCrearCita;
		this.manejadorEliminarCita = manejadorEliminarCita;
		this.manejadorObtenerCitas = manejadorObtenerCitas;
		this.manejadorObtenerCita = manejadorObtenerCita;
	}

	@PostMapping("/agregarCita")
	public void agregarCita(@RequestBody ComandoCita comandoCita) {
		this.manejadorCrearCita.ejecutar(comandoCita);

	}

	@DeleteMapping("/eliminarCita/{ID}")
	public void eliminarCita(@PathVariable(name = "ID") Long id) {
		this.manejadorEliminarCita.ejecutar(id);

	}

	@GetMapping("/obtenerCitas")
	public List<ComandoCita> obtenerCitas() {
		return this.manejadorObtenerCitas.ejecutar();

	}

	@GetMapping("/buscarCita/{ID}")
	public ComandoCita buscarCita(@PathVariable(name = "ID") Long id) {
		return this.manejadorObtenerCita.ejecutar(id);

	}

}
