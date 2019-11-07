package databuilder;

import com.ceiba.consultorio.aplicacion.comando.ComandoPersona;

public class ComandoPersonaDataBuilder {
    private String nombre;
    private Integer edad;

    public ComandoPersonaDataBuilder() {
        this.nombre = "Pepito Perez";
        this.edad=25;
    }

    public ComandoPersonaDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoPersona build() {
        return new ComandoPersona(1L,nombre,edad);
    }
}
