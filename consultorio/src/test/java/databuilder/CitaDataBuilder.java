package databuilder;

import java.time.LocalDate;

import com.ceiba.consultorio.dominio.modelo.Cita;
import com.ceiba.consultorio.dominio.modelo.Persona;

public class CitaDataBuilder {
	private Long id;

	private LocalDate fechaCita;

	private Double costoCita;

	private Persona persona;

	public CitaDataBuilder() {

		this.id = 1L;

		this.fechaCita = LocalDate.now();

		this.costoCita = 35000.00;

		this.persona = new PersonaDataBuilder().build();
	}

	public Cita conId(Long id) {
		return new Cita(id, fechaCita, costoCita, persona);
	}

	public Cita fechaNull(Long id) {
		return new Cita(id, null, costoCita, persona);
	}

	public Cita PersonaNull(Long id) {
		return new Cita(id, fechaCita, costoCita, null);
	}

	public Cita build() {
		return new Cita(id, fechaCita, costoCita, persona);
	}
}
