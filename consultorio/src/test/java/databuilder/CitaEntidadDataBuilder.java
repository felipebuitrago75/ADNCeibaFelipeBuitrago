package databuilder;

import java.time.LocalDate;

import com.ceiba.consultorio.infraestructura.entidades.CitaEntidad;
import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

public class CitaEntidadDataBuilder {
	private Long id;

	private LocalDate fechaCita;

	private Double costoCita;

	private PersonaEntidad persona;

	public CitaEntidadDataBuilder() {

		this.id = 1L;

		this.fechaCita = LocalDate.now();

		this.costoCita = 35000.00;

		this.persona = new PersonaEntidadDataBuilder().build();
	}

	public CitaEntidad build() {
		return new CitaEntidad(id, fechaCita, costoCita, persona);
	}

}
