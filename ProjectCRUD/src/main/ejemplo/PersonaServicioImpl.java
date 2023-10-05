package com.ejemplo.servicio;

import com.ejemplo.modelo.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaServicioImpl implements PersonaServicio {
    private static PersonaServicioImpl instancia;
    private final String url = "jdbc:mysql://localhost:3306/mi_bbdd_ejemplo";
    private final String user = "root";
    private final String password = "691449303";
    
    public PersonaServicioImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized PersonaServicioImpl obtenerInstancia() {
        if (instancia == null) {
            instancia = new PersonaServicioImpl();
        }
        return instancia;
    }
    
    @Override
    public Boolean createPersona(Persona persona) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        
        	String sql = "INSERT INTO personas (nombre, apellido, fecha_nacimiento, lugar_nacimiento) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, persona.getNombre());
                statement.setString(2, persona.getApellido());
                statement.setDate(3, new java.sql.Date(persona.getFechaNacimiento().getTime()));
                statement.setString(4, persona.getLugarNacimiento());
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public List<Persona> getAllPersonas() {
        List<Persona> personas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM personas";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    // Asumiendo que tu modelo de Persona tiene un constructor adecuado
                    Persona persona = new Persona(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getDate("fecha_nacimiento"),
                        resultSet.getString("lugar_nacimiento")
                    );
                    personas.add(persona);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    @Override
    public Persona readPersona(Long id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM personas WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String apellido = resultSet.getString("apellido");
                        Date fechaNacimiento = resultSet.getDate("fecha_nacimiento");
                        String lugarNacimiento = resultSet.getString("lugar_nacimiento");
                        return new Persona(id, nombre, apellido, fechaNacimiento, lugarNacimiento);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean updatePersona(Persona persona) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
        	
        	String sql = "UPDATE personas SET nombre = ?, apellido = ?, fecha_nacimiento = ?, lugar_nacimiento = ? WHERE id = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, persona.getNombre());
                statement.setString(2, persona.getApellido());
                statement.setDate(3, new java.sql.Date(persona.getFechaNacimiento().getTime()));
                statement.setString(4, persona.getLugarNacimiento());
                statement.setLong(5, persona.getId());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletePersona(Long id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
      
        	String sql = "DELETE FROM personas WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0; // retorna true si se ha eliminado al menos un registro
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // retorna false si ocurre una excepción o no se elimina ningún registro
    }

    // Implementa aquí los demás métodos de la interfaz, como updatePersona, deletePersona, readPersona, etc.

}
