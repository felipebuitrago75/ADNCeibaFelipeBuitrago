package databuilder;

import com.ceiba.consultorio.dominio.modelo.Persona;

public class PersonaDataBuilder {
	private String nombre;
	private Integer edad;
	private Integer numeroIdentificacion;
	private Long id;

	public PersonaDataBuilder() {
		this.nombre = "Pepito Perez";
		this.edad = 25;
		this.numeroIdentificacion = 12345;
		this.id = 1L;
	}

	public Persona conId(Long id) {
		return new Persona(id, nombre, edad, numeroIdentificacion);
	}

	public Persona nombreNull(Long id) {
		return new Persona(id, null, edad, numeroIdentificacion);
	}

	public Persona edadNull(Long id) {
		return new Persona(id, nombre, null, numeroIdentificacion);
	}

	public Persona numeroIdentificacionNull(Long id) {
		return new Persona(id, nombre, edad, null);
	}

	public Persona build() {
		return new Persona(id, nombre, edad, numeroIdentificacion);
	}
}
