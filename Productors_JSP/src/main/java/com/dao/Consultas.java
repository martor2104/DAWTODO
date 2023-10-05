package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import com.Producto;

public class Consultas {
	public static LinkedList<Producto> getProductos(){
		LinkedList<Producto> productList = new LinkedList<Producto>();
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://172.22.0.35/productos", "root", "usuario");
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from producto");
			while(rs.next()) {
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
