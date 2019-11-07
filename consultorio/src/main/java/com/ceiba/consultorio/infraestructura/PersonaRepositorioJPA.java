package com.ceiba.consultorio.infraestructura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

@Repository
public interface PersonaRepositorioJPA extends JpaRepository<PersonaEntidad, Long> {


}
