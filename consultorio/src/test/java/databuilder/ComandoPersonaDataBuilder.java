package databuilder;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;

public class ComandoPersonaDataBuilder {
	private String nombre;
	private Integer edad;
	private Integer numeroIdentificacion;
	private Long id;

	public ComandoPersonaDataBuilder() {
		this.nombre = "Pepito Perez";
		this.edad = 25;
		this.numeroIdentificacion = 12345;
		this.id = 1L;
	}

	public ComandoPersona conId(Long id) {
		return new ComandoPersona(id, nombre, edad, numeroIdentificacion);
	}

	public ComandoPersona build() {
		return new ComandoPersona(id, nombre, edad, numeroIdentificacion);
	}
}
