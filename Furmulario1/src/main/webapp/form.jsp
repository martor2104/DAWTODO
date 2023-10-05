<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%String java = request.getParameter("java");
	String c = request.getParameter("c");
	String basic = request.getParameter("basic");
	String html = request.getParameter("html");
	
	java = (java == null) ? "" : java;
	c = (c == null) ? "" : c;
	basic = (basic == null) ? "" : basic;
	html = (html == null) ? "" : html;
	%>


	<%= "Nombre: " + request.getParameter("Nombre") %> <br>
	<%= "Apellidos: " + request.getParameter("apellidos") %><br>
	<%= "Correo: " + request.getParameter("mail") %><br>
	<%= "Comentarios: " + request.getParameter("comentario") %><br>
	<%= "Conocimientos: " + java + " " + c + " " + basic + " " + html %><br>
	<%= "Idiomas: " + request.getParameter("idiomas") %><br>
	<%= "Género: " + request.getParameter("genero") %><br>

	
</body>
</html>