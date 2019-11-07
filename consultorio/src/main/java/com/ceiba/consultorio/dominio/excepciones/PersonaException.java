package com.ceiba.consultorio.dominio.excepciones;

public class PersonaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PersonaException(String message) {
		super(message);
	}
}
