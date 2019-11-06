package co.com.domain.personas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
	@Autowired
	private PersonaRepository repository;

	public PersonaServiceImpl(PersonaRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Persona> obtenerPersonas() {
		return repository.findAll();
	}

	@Override
	public Persona getPersona(Long personaId) {
		Optional<Persona> optPer = repository.findById(personaId);
		return optPer.get();
	}

	@Override
	public void savePersona(Persona persona) {
		repository.save(persona);

	}

	@Override
	public void deletePersona(Long personaId) {
		repository.deleteById(personaId);

	}

	@Override
	public void updatePersona(Persona persona) {

		repository.save(persona);

	}

}
