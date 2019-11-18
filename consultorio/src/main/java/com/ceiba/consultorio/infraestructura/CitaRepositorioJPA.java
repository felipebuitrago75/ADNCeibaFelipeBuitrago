package com.ceiba.consultorio.infraestructura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.consultorio.infraestructura.entidades.CitaEntidad;

@Repository
public interface CitaRepositorioJPA extends JpaRepository<CitaEntidad, Long> {

}
