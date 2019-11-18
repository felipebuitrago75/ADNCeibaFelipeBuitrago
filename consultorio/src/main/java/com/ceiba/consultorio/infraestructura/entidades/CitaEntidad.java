package com.ceiba.consultorio.infraestructura.entidades;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITA")
public class CitaEntidad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "FECHA_CITA", nullable = false)
	private LocalDate fechaCita;
	@Column(name = "COSTO_CITA", nullable = false)
	private Double costoCita;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private PersonaEntidad persona;

	public CitaEntidad(Long id, LocalDate fechaCita, Double costoCita, PersonaEntidad persona) {
		super();
		this.id = id;
		this.fechaCita = fechaCita;
		this.costoCita = costoCita;
		this.persona = persona;
	}

	public CitaEntidad() {

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

	public PersonaEntidad getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntidad persona) {
		this.persona = persona;
	}

}
