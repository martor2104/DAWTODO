package com.servlets;

import java.io.IOException;

import com.dao.ProductoServicioImpl;
import com.model.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller1
 */
public class Controller1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("DUGE");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoServicioImpl imagenDao = new ProductoServicioImpl();
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String peso = request.getParameter("peso");
		String stock = request.getParameter("stock");
		
		
		
		
		imagenDao.createProducto(new Producto(Long.parseLong(id), nombre, descripcion, Float.parseFloat(peso), Integer.parseInt(stock)));
		
	}

}
