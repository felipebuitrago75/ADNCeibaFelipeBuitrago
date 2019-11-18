package com.ceiba.consultorio.dominio.servicio.cita;

import org.springframework.stereotype.Service;

import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;
import com.ceiba.consultorio.dominio.util.Utilitarios;

@Service
public class ServicioCrearCita {
	private final Double COSTO_BASE = 35.000;
	private RepositorioCita repositorioCita;
	private Utilitarios util;

	public ServicioCrearCita(RepositorioCita repositorioCita, Utilitarios util) {

		this.repositorioCita = repositorioCita;
		this.util = util;
	}

	public void ejecutar(Cita cita) {
		Double valorCita = COSTO_BASE * this.util.calcularCostoPorcentualExtraPorDia(cita.getFechaCita());
		valorCita = valorCita - this.util.verificarDescuentos(valorCita, cita);
		cita.setCostoCita(valorCita);
		this.repositorioCita.guardar(cita);
	}
}
