package com.ceiba.consultorio.aplicacion.comando;

import java.time.LocalDate;

public class ComandoCita {
	private Long id;

	private LocalDate fechaCita;

	private Double costoCita;

	private ComandoPersona persona;

	public ComandoCita(Long id, LocalDate fechaCita, Double costoCita, ComandoPersona persona) {

	}

	public ComandoCita() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Double getCostoCita() {
		return costoCita;
	}

	public void setCostoCita(Double costoCita) {
		this.costoCita = costoCita;
	}

	public ComandoPersona getPersona() {
		return persona;
	}

	public void setPersona(ComandoPersona persona) {
		this.persona = persona;
	}

}
