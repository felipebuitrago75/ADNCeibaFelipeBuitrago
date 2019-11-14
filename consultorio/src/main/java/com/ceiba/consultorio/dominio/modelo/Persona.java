package com.ceiba.consultorio.dominio.modelo;

import com.ceiba.consultorio.dominio.validador.ValidadorArgumento;

public class Persona {

	private static final String CAMPO_OBLIGATORIO = "Este campo es obligatorio ";
	private Long id;

	private String nombre;

	private Integer edad;

	private Integer numeroIdentificacion;

	public Long getId() {
		return id;
	}

	public Persona(Long id, String nombre, Integer edad, Integer numeroIdentificacion) {

		ValidadorArgumento.validarCampoObligatorio(nombre, CAMPO_OBLIGATORIO);
		ValidadorArgumento.validarCampoObligatorio(edad, CAMPO_OBLIGATORIO);
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.numeroIdentificacion = numeroIdentificacion; 
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

	public Integer getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(Integer numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

}
