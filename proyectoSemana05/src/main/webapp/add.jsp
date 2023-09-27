<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insercion</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>REGISTRAR COLABORADOR</h1>
	<form action="grabar">
		<input type="hidden" name="op" value="3" />
		<table class="table">
			<tr>
				<td>DNI</td><td><input name="txtid" maxlength="8"/></td>
			</tr>
			<tr>
				<td>APELLIDOS</td><td><input name="txtape" maxlength="50"/></td>
			</tr>
			<tr>
				<td>NOMBRES</td><td><input name="txtnom" maxlength="50"/></td>
			</tr>
			<tr>
				<td>EDAD</td><td><input name="txteda" maxlength="2"/></td>
			</tr>
			<tr>
				<td>SEXO</td><td><input name="txtsex" maxlength="1" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Grabar" /></td>
			</tr>
		</table>
	</form>
	<a href=index.jsp>Regresar al Listado</a>
</body>
</html>