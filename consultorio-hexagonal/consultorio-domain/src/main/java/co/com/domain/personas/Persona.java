package co.com.domain.personas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOMBRE_PERSONA")
	private String nombrePersona;

	@Column(name = "EDAD_PERSONA")
	private Integer edadPersona;

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public Integer getEdadPersona() {
		return edadPersona;
	}

	public void setEdadPersona(Integer edadPersona) {
		this.edadPersona = edadPersona;
	}

}
