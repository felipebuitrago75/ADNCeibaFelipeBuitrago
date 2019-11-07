package com.ceiba.consultorio.infraestructura.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PERSONA")
public class PersonaEntidad {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "EDAD", nullable = false)
	private Integer edad;

	public Long getId() {
		return id;
	}

	public PersonaEntidad(Long id, String nombre, Integer edad) {
		//validaciones datos
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	public PersonaEntidad() {
		
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}





}
