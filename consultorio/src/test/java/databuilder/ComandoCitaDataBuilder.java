package databuilder;

import java.time.LocalDate;

import com.ceiba.consultorio.aplicacion.comando.ComandoCita;
import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;

public class ComandoCitaDataBuilder {
	private Long id;

	private LocalDate fechaCita;

	private Double costoCita;

	private ComandoPersona persona;

	public ComandoCitaDataBuilder() {
		this.id = 1L;
		this.fechaCita = LocalDate.now();
		this.costoCita = 35000.00;
		this.persona = new ComandoPersonaDataBuilder().build();
	}

	public ComandoCita build() {
		return new ComandoCita(id, fechaCita, costoCita, persona);
	}
}
