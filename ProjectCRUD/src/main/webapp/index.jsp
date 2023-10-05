<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Solicitud</h1>
	<p>Despues de introducir tus datos oprime el botón "enviar"</p>
	<form action="Controller1" method="post">
		<table cellspacing="3" cellpadding="3" border="1">
			<tr>
				<td align="right">Id: </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td align="right">Nombre:</td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td align="right">Descripción:</td>
				<td><input type="text" name="descripcion"></td>
			</tr>
			<tr>
				<td align="right">Peso:</td>
				<td><input type="text" name="peso"></td>
			</tr>
			<tr>
				<td align="right"> Stock: </td>
				<td><input type="text" name="stock"></td>
			</tr>
		</table>
		<input type="reset" value="Borrar"> <input type="submit" value="Enviar">	
	</form>
</body>
</html>