package com.ceiba.consultorio.aplicacion.comando;

public class ComandoPersona {

	private Long id;

	private String nombre;

	private Integer edad;

	public Long getId() {
		return id;
	}

	public ComandoPersona(Long id, String nombre, Integer edad) {

	}

	public ComandoPersona() {
		super();
	}



	public String getNombre() {
		return nombre;
	}


	public Integer getEdad() {
		return edad;
	}



}
