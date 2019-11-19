package databuilder;

import com.ceiba.consultorio.infraestructura.entidades.PersonaEntidad;

public class PersonaEntidadDataBuilder {
	private String nombre;
	private Integer edad;
	private Integer numeroIdentificacion;
	private Long id;

	public PersonaEntidadDataBuilder() {
		this.nombre = "Pepito Perez";
		this.edad = 25;
		this.numeroIdentificacion = 12345;
		this.id = 1L;
	}

	public PersonaEntidad conId(Long id) {
		return new PersonaEntidad(id, nombre, edad, numeroIdentificacion);
	}

	public PersonaEntidad build() {
		return new PersonaEntidad(id, nombre, edad, numeroIdentificacion);
	}
}
