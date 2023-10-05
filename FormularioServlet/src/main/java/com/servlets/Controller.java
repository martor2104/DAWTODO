package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.model.Persona;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nombre = request.getParameter("Nombre");
		String apellidos = request.getParameter("apellidos");
		String Correo = request.getParameter("mail");
		String Comentario = request.getParameter("comentario");
		String Idiomas = request.getParameter("idiomas");
		Persona.genero Genero;
		List<String> conocimiento = new ArrayList<String>();
		
		conocimiento.add(request.getParameter("java"));
		conocimiento.add(request.getParameter("c"));
		conocimiento.add(request.getParameter("basic"));
		conocimiento.add(request.getParameter("html"));
		while(conocimiento.remove(null));
		
		if(request.getParameter("genero") == "Hombre ") {
			Genero = Persona.genero.HOMBRE;
		}else {
			Genero = Persona.genero.MUJER;
		}
		
		
	request.setAttribute("NOMBRE", nombre);
	request.setAttribute("APELLIDOS", apellidos);
	request.setAttribute("CORREO", Correo);
	request.setAttribute("COMENTARIO", Comentario);
	request.setAttribute("IDIOMAS", Idiomas);
	request.setAttribute("GENERO", Genero);
	request.setAttribute("CONOCIMIENTO", conocimiento);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
	dispatcher.forward(request, response);
		
	}

}
