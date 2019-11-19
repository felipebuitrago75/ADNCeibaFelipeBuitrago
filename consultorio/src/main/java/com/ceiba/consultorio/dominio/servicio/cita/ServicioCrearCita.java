package com.ceiba.consultorio.dominio.servicio.cita;

import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.puerto.repositorio.RepositorioCita;
import com.ceiba.consultorio.dominio.util.Utilitarios;

public class ServicioCrearCita {
	private static final Double COSTO_BASE = 35000.0;
	private RepositorioCita repositorioCita;

	public ServicioCrearCita(RepositorioCita repositorioCita) {

		this.repositorioCita = repositorioCita;
	}

	public void ejecutar(Cita cita) {
		Utilitarios util = new Utilitarios();
		Double valorCita = COSTO_BASE * util.calcularCostoPorcentualExtraPorDia(cita.getFechaCita());
		valorCita = valorCita - util.verificarDescuentos(valorCita, cita);
		cita.setCostoCita(valorCita);
		this.repositorioCita.guardar(cita);
	}
}
