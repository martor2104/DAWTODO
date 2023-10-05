package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Producto;

public class ProductoServicioImpl implements ProductoServicio {
    private static ProductoServicioImpl instancia;
    private final String url = "jdbc:mysql://172.22.0.35:3306/productos";
    private final String user = "root";
    private final String password = "usuario";
    
    public ProductoServicioImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized ProductoServicioImpl obtenerInstancia() {
        if (instancia == null) {
            instancia = new ProductoServicioImpl();
        }
        return instancia;
    }
    
	@Override
	public Boolean createProducto(Producto producto) {
		  try (Connection connection = DriverManager.getConnection(url, user, password)) {
		        
	        	String sql = "INSERT INTO productos_info (id, Nombre, Descripcion, Peso, Stock) VALUES (?, ?, ?, ?, ?)";
	            
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setLong(1, producto.getId());
	                statement.setString(2, producto.getNombre());
	                statement.setString(3, producto.getDescripcion());
	                statement.setFloat(4, producto.getPeso());
	                statement.setFloat(5, producto.getStock());
	                int rowsInserted = statement.executeUpdate();
	                return rowsInserted > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	}

	@Override
	public Producto readProducto(Long id) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM productos_info WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");
                        Float peso = resultSet.getFloat("Peso");
                        Integer stock = resultSet.getInt("Stock");
                        return new Producto(id, nombre, descripcion, peso, stock);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

	@Override
	public Boolean updateProducto(Producto producto) {
		 try (Connection connection = DriverManager.getConnection(url, user, password)) {
	        	
	        	String sql = "UPDATE productos_info SET Nombre = ?, Descripcion = ?, Peso = ?, Stock = ? WHERE id = ?";
	            
	            try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                statement.setString(1, producto.getNombre());
	                statement.setString(2, producto.getDescripcion());
	                statement.setFloat(3, producto.getPeso());
	                statement.setInt(4, producto.getStock());
	                statement.setLong(5, producto.getId());
	                int rowsUpdated = statement.executeUpdate();
	                return rowsUpdated > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	}

	@Override
	public Boolean deleteProducto(Long id) {
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
		      
        	String sql = "DELETE FROM productos_info WHERE id = ?";
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

}
