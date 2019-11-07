package com.ceiba.consultorio.dominio.modelo;

import com.ceiba.consultorio.dominio.validador.validadorArgumento;

public class Persona {

	private static final String CAMPO_OBLIGATORIO = "Este campo es obligatorio ";
	private Long id;

	private String nombre;

	private Integer edad;

	public Long getId() {
		return id;
	}

	public Persona(Long id, String nombre, Integer edad) {

		validadorArgumento.validarCampoObligatorio(nombre, CAMPO_OBLIGATORIO);
		validadorArgumento.validarCampoObligatorio(edad, CAMPO_OBLIGATORIO);
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persona() {

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
