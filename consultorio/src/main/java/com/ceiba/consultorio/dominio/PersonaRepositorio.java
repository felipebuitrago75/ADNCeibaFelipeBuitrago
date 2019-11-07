package com.ceiba.consultorio.dominio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.consultorio.infraestructura.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long> {


}
