package com.ceiba.consultorio.dominio.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.modelo.Cita;

@Service
public class Utilitarios {

	public Double calcularCostoPorcentualExtraPorDia(LocalDate fechaCita) {
		DayOfWeek day = DayOfWeek.of(fechaCita.get(ChronoField.DAY_OF_WEEK));
		switch (day) {
		case SATURDAY:
		case SUNDAY:
			return 1.35;
		default:
			return 1.0;
		}
	}

	public Double verificarDescuentos(Double valorCita, Cita cita) {

		if (cita.getPersona().getEdad() >= 60) {
			return valorCita * calcularCostoPorcentualDescuento(cita.getFechaCita());

		} else if (calcularIdentificacionPalindromo(cita.getPersona().getNumeroIdentificacion().toString())) {
			return valorCita * 0.05;
		}
		return 0.0;
	}

	private boolean calcularIdentificacionPalindromo(String numeroIdentificacion) {
		boolean valor = true;
		int i;
		int indice;
		String cadenaIdentificacion = "";
		for (int x = 0; x < numeroIdentificacion.length(); x++) {
			if (numeroIdentificacion.charAt(x) != ' ')
				cadenaIdentificacion += numeroIdentificacion.charAt(x);
		}
		numeroIdentificacion = cadenaIdentificacion;
		indice = numeroIdentificacion.length();
		// Se recorre el arreglo de caracteres de adelante hacia atras y de atras hacia
		// adelante
		for (i = 0; i < (numeroIdentificacion.length()); i++) {
			if (!numeroIdentificacion.substring(i, i + 1).equals(numeroIdentificacion.substring(indice - 1, indice))) {
				valor = false;
				break;
			}
			indice--;
		}
		return valor;
	}

	private Double calcularCostoPorcentualDescuento(LocalDate fechaCita) {
		DayOfWeek day = DayOfWeek.of(fechaCita.get(ChronoField.DAY_OF_WEEK));
		switch (day) {
		case MONDAY:
		case TUESDAY:
			return 0.1;
		default:
			return 0.0;
		}
	}

}
