package com.ceiba.consultorio.dominio;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.dominio.util.Utilitarios;

public class UtilitariosTest {
	Utilitarios util = new Utilitarios();

	@Test
	public void validarNoCostoExtra() {

		LocalDate fechaPrueba = LocalDate.of(2019, Month.NOVEMBER, 22);

		Double resultado = util.calcularCostoPorcentualExtraPorDia(fechaPrueba);

		Assertions.assertEquals(1.0, resultado);

	}

	@Test
	public void validarCostoExtra() {

		LocalDate fechaPrueba = LocalDate.of(2019, Month.NOVEMBER, 24);

		Double resultado = util.calcularCostoPorcentualExtraPorDia(fechaPrueba);

		Assertions.assertEquals(1.35, resultado);

	}

	@Test
	public void validarVerificarDescuentosTest1() {

		LocalDate fechaPrueba = LocalDate.of(2019, Month.NOVEMBER, 18);
		Persona persona = new Persona(1L, "Felipe", 60, 1097400317);
		Cita cita = new Cita(1L, fechaPrueba, 0.0, persona);

		Double resultado = util.verificarDescuentos(10.0, cita);

		Assertions.assertEquals((10.0 * 0.1), resultado);

	}

	@Test
	public void validarVerificarDescuentosTest2() {

		LocalDate fechaPrueba = LocalDate.of(2019, Month.NOVEMBER, 18);
		Persona persona = new Persona(1L, "Felipe", 25, 1097400317);
		Cita cita = new Cita(1L, fechaPrueba, 0.0, persona);

		Double resultado = util.verificarDescuentos(10.0, cita);

		Assertions.assertEquals(0.0, resultado);

	}

	@Test
	public void validarVerificarDescuentosTest3() {

		LocalDate fechaPrueba = LocalDate.of(2019, Month.NOVEMBER, 18);
		Persona persona = new Persona(1L, "Felipe", 25, 1221);
		Cita cita = new Cita(1L, fechaPrueba, 0.0, persona);

		Double resultado = util.verificarDescuentos(10.0, cita);

		Assertions.assertEquals((10.0 * 0.05), resultado);

	}

	@Test
	public void esPalindoromoTrue() {

		boolean esPalindroma = util.calcularIdentificacionPalindromo("1221");

		Assertions.assertTrue(esPalindroma);
	}

	@Test
	public void esPalidromoFalse() {

		boolean esPalindroma = util.calcularIdentificacionPalindromo("122156");

		Assertions.assertTrue(!esPalindroma);
	}

	@Test
	public void esPalidromoEspacios() {

		boolean esPalindroma = util.calcularIdentificacionPalindromo("122 156");

		Assertions.assertTrue(!esPalindroma);
	}

	@Test
	public void calcularCostoPorcentualDescuentoTest() {

		LocalDate fechaPrueba = LocalDate.of(2019, Month.NOVEMBER, 20);
		Double resultado = util.calcularCostoPorcentualDescuento(fechaPrueba);

		Assertions.assertEquals(0.0, resultado);
		;
	}

}
