package com.ceiba.consultorio.dominio.validador;

import com.ceiba.consultorio.dominio.excepciones.PersonaException;

public class validadorArgumento {

	public validadorArgumento() {
	}

	public static void validarCampoObligatorio(Object valor, String mensaje) {
		if (valor == null)
			throw new PersonaException(mensaje);
	}

}
