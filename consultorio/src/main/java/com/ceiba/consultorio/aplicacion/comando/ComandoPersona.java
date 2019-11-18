package com.ceiba.consultorio.aplicacion.comando;

public class ComandoPersona {

	private Long id;

	private String nombre;

	private Integer edad;
	
	private Integer numeroIdentificacion;




	public ComandoPersona(Long id, String nombre, Integer edad, Integer numeroIdentificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.numeroIdentificacion = numeroIdentificacion;
	}


	public ComandoPersona() {
		super();
	}


	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}


	public Integer getEdad() {
		return edad;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
