<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solicitud</title>
</head>
<body>
	<h1>Solicitud</h1>
	<p>Despues de introducir tus datos oprime el botón "enviar"</p>
	<form action="Controller">
		<table cellspacing="3" cellpadding="3" border="1">
			<tr>
				<td align="right">Nombre:</td>
				<td><input type="text" name="Nombre"></td>
			</tr>
			<tr>
				<td align="right">Apellidos:</td>
				<td><input type="text" name="apellidos"></td>
			</tr>
			<tr>
				<td align="right">Correo:</td>
				<td><input type="text" name="mail"></td>
			</tr>
		</table>
		<p>
			Eres: <input type="radio" name="genero" value="masculino" checked>
			Hombre <input type="radio" name="genero" value="femenino">Mujer<br>
			Selecciona lo que sabes: <br> <input type="checkbox" name="java"
				value="java"> Java <input type="checkbox" name="c" value="c">C/C++
			<input type="checkbox" name="basic" value="basic">Basic <input
				type="checkbox" name="html" value="html">HTML <br>
		</p>
		<table cellspacing="5" cellpadding="5" border="0">
			<tr>
				<td align="center">Selecciona los idiomas que comprendes:</td>
					<td><select name="idiomas" multiple>
						<option selected>Español</option>
						<option>Inglés</option>
						<option>Frances</option>
						<option>Alemán</option>
				</select></td>
			</tr>

			<tr>
			<td align="center">Comentarios adicionales</td>
				<td><textarea name="comentario" rows="3" cols="20"></textarea>
				</td>

			</tr>
		</table>
		<input type="reset" value="Borrar"> <input type="submit" value="Enviar">
		

	</form>
</body>
</html>