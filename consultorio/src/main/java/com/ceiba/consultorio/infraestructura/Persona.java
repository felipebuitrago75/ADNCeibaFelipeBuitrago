package com.ceiba.consultorio.infraestructura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PERSONA")
public class Persona {


	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "EDAD")
	private Integer edad;

	public Long getId() {
		return id;
	}

	public Persona(Long id, String nombre, Integer edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona() {
		super();
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
