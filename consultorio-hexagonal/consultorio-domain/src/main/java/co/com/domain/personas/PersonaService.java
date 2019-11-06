package co.com.domain.personas;

import java.util.List;

public interface PersonaService {
	public List<Persona> obtenerPersonas();

	public Persona getPersona(Long personaId);

	public void savePersona(Persona persona);

	public void deletePersona(Long personaId);

	public void updatePersona(Persona persona);

}
