package com;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Sumas {

	/**
	 * Servlet implementation class Saluda
	 */
	public class Saluda extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    /**
	     * Default constructor. 
	     * @return 
	     */
	    public void Suma() {
	        // TODO Auto-generated constructor stub
	    }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Integer num1 = Integer.parseInt(request.getParameter("num1"));
        Integer num2 = Integer.parseInt(request.getParameter("num2"));;
        out.print("<h1>GET</h1>");
        out.print("El reslutado es " + num1 + " " + num2);
        
        out.close();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaFormularioPOST(request, response);
	}
	
	public void procesaFormularioPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Integer num1 = Integer.parseInt(request.getParameter("nombre"));
        Integer num2 = Integer.parseInt(request.getParameter("apellido"));
        out.print("<h1>POST</h1>");
        out.print("El resultado es " + num1 + " " + num2 + "!");
        out.close();
	}
}
