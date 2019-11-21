package com.ceiba.consultorio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.modelo.Persona;
import com.ceiba.consultorio.infraestructura.adaptador.repositorio.RepositorioCitaImpl;
import com.ceiba.consultorio.infraestructura.adaptador.repositorio.RepositorioPersonaImpl;
import com.ceiba.consultorio.infraestructura.entidades.CitaEntidad;
import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

import databuilder.CitaDataBuilder;
import databuilder.PersonaDataBuilder;

@RunWith(SpringRunner.class)
@AutoConfigureTestEntityManager
@Transactional
@SpringBootTest
public class IntegracionTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RepositorioPersonaImpl repositorioPersonaImpl;

	@Autowired
	private RepositorioCitaImpl repositorioCitaImpl;

	@Test
	public void guardarCita() {
		Persona persona = new PersonaDataBuilder().build();

		repositorioPersonaImpl.guardar(persona);

		PersonaEntidad PersonaEncontrada = entityManager.find(PersonaEntidad.class, persona.getId());

		assertEquals(persona.getNombre(), PersonaEncontrada.getNombre());

		Cita cita = new CitaDataBuilder().build();
		cita.setPersona(persona);

		repositorioCitaImpl.guardar(cita);

		CitaEntidad citaEntidad = entityManager.find(CitaEntidad.class, 2L);
		assertEquals(cita.getCostoCita(), citaEntidad.getCostoCita());
	}

}
