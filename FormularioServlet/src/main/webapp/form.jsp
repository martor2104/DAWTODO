<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Nombre: ${NOMBRE} <br>
	Apellidos: ${APELLIDOS}<br>
	Correo: ${CORREO}<br>
	Comentarios: ${COMENTARIO}<br>
	Conocimientos: 
	<c:forEach var="s" items="${CONOCIMIENTO}">
		 ${s} &nbsp;
	</c:forEach><br>
	Idiomas: ${IDIOMAS}<br>
	Género: ${GENERO}<br>
	
</body>
</html>