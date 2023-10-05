package com.ejemplo.servicio;

import java.util.List;

import com.ejemplo.modelo.Persona;

public interface PersonaServicio {
	Boolean createPersona(Persona persona);
	Persona readPersona(Long id);
	Boolean updatePersona(Persona persona);
	Boolean deletePersona(Long id);
	List<Persona> getAllPersonas();
}
