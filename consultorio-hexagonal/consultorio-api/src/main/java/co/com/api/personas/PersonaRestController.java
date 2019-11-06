package co.com.api.personas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.domain.personas.Persona;
import co.com.domain.personas.PersonaService;

@RestController
public class PersonaRestController {

	@Autowired
	private PersonaService personaService;

	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	@GetMapping("/api/personas")
	public List<Persona> obtenerPersonas() {
		List<Persona> personas = personaService.obtenerPersonas();
		return personas;
	}

	@GetMapping("/api/personas/{personaId}")
	public Persona getPersona(@PathVariable(name = "personaId") Long personaId) {
		return personaService.getPersona(personaId);
	}

	@PostMapping("/api/personas")
	public void savePersona(Persona persona) {
		personaService.savePersona(persona);
		System.out.println("Employee Saved Successfully");
	}

	@DeleteMapping("/api/personas/{personaId}")
	public void deletePersona(@PathVariable(name = "personaId") Long personaId) {
		personaService.deletePersona(personaId);
		System.out.println("Employee Deleted Successfully");
	}

	@PutMapping("/api/personas/{personaId}")
	public void updatePersona(@RequestBody Persona persona, @PathVariable(name = "personaId") Long personaId) {
		Persona per = personaService.getPersona(personaId);
		if (per != null) {
			personaService.updatePersona(persona);
		}

	}

}