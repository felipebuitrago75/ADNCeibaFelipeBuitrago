package com.ceiba.consultorio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.dominio.servicio.ServicioCrearPersona;
import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

@RunWith(SpringRunner.class)
@AutoConfigureTestEntityManager
@Transactional
@SpringBootTest
public class ConsultorioApplicationTests {

	@Autowired
	private TestEntityManager entityManager;

	private final ServicioCrearPersona servicioCrearPersona;

	public ConsultorioApplicationTests(ServicioCrearPersona servicioCrearPersona) {
		this.servicioCrearPersona = servicioCrearPersona;
	}

	@Test
	public void guardarPersona() {
		Persona persona = new Persona();
		persona.setNombre("Pepito perez");
		persona.setEdad(27);
		this.servicioCrearPersona.ejecutar(persona);
		PersonaEntidad personaEncontrada = entityManager.find(PersonaEntidad.class, 1L);

		assertEquals(persona.getNombre(), personaEncontrada.getNombre());
	}

}
