package com.ejemplo.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.ejemplo.modelo.Persona;

public class PersonaServicioImplMock implements PersonaServicio{
	
	private static PersonaServicioImplMock instancia;
    private final Map<Long, Persona> personas = new HashMap<>();
    
 // Método estático para obtener la instancia única
    public static synchronized PersonaServicioImplMock obtenerInstancia() {
        if(instancia == null) {
            instancia = new PersonaServicioImplMock();
        }
        return instancia;
    }

	public PersonaServicioImplMock() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			personas.put(1L, new Persona(1L, "Juan", "Perez", sdf.parse("01-01-1990"), "Sevilla"));
			personas.put(2L, new Persona(2L, "María", "Gómez", sdf.parse("21-01-1993"), "Malaga"));
			personas.put(3L, new Persona(3L, "Raul", "Rodriguez", sdf.parse("21-12-2016"), "Malaga"));
			personas.put(4L, new Persona(4L, "Juan", "Mayo", sdf.parse("10-05-1986"), "Sevilla"));
			personas.put(5L, new Persona(5L, "Luis", "Romero", sdf.parse("21-01-1993"), "Malaga"));
			personas.put(6L, new Persona(6L, "Carmen", "Lopez", sdf.parse("21-08-2017"), "Cádiz"));
			
		}catch(ParseException e) {
			System.out.println(e.toString());
		}
	}
	

	@Override
	public Boolean createPersona(Persona persona) {
		try {
			Long newId = 1L;
			
			if (!personas.keySet().isEmpty()) {
			    newId = personas.keySet().stream().max(Long::compare).orElse(0L) + 1;
			    
			}
	
		    persona.setId(newId); // Asegurarse de que la persona tenga el nuevo ID asignado
		    System.out.println(persona.toString());
		    personas.put(newId, persona);
		    return true; // Persona creada exitosamente
		}catch(Exception e) {
			return false;
		}
	    
	}


    @Override
    public Persona readPersona(Long id) {
        return personas.get(id); // Retorna null si la persona con el id proporcionado no existe
    }

    @Override
    public Boolean updatePersona(Persona persona) {
        if(!personas.containsKey(persona.getId())) {
            return false; // Persona no existe
        }
        personas.put(persona.getId(), persona); // Actualiza la persona existente
        return true;
    }

    @Override
    public Boolean deletePersona(Long id) {
        if(personas.remove(id) == null) {
            return false; // Persona no existía
        }
        return true; // Persona eliminada exitosamente
    }
	@Override
	public List<Persona> getAllPersonas() {
		return new ArrayList<Persona>(personas.values());
	
	}



}
