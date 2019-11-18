package com.ceiba.consultorio.dominio.modelo;

import java.time.LocalDate;

import com.ceiba.consultorio.dominio.validador.ValidadorArgumento;

public class Cita {

	private static final String CAMPO_OBLIGATORIO = "Este campo es obligatorio ";
	private Long id;

	private LocalDate fechaCita;

	private Double costoCita;

	private Persona persona;

	public Cita(Long id, LocalDate fechaCita, Double costoCita, Persona persona) {
		super();
		ValidadorArgumento.validarCampoObligatorio(fechaCita, CAMPO_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(persona, CAMPO_OBLIGATORIO);
		this.id = id;
		this.fechaCita = fechaCita;
		this.costoCita = costoCita;
		this.persona = persona;
	}

	public Cita() {

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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
