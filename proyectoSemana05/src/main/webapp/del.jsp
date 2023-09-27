<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidades.Colaboradores" %>
<%@ page import="negocio.BSColaboradores" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Suprimir</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>CONFIRMAR BAJA DE COLABORADOR</h1>
	<%
		String Id = request.getParameter("id");
		BSColaboradores ObjBD = new BSColaboradores();
		Colaboradores ObjC = new Colaboradores();
		ObjC = ObjBD.Buscar(Id);
	%>
	<form action="grabar">
		<input type="hidden" name="op" value="2" />
		<table class="table">
			<tr>
				<td>DNI</td><td><input name="txtid" value=<%=ObjC.getId()%> readonly /></td>
			</tr>
			<tr>
				<td>APELLIDOS</td><td><input name="txtape" value='<%=ObjC.getApellidos()%>' readonly/></td>
			</tr>
			<tr>
				<td>NOMBRES</td><td><input name="txtnom" value='<%=ObjC.getNombres()%>' readonly/></td>
			</tr>
			<tr>
				<td>EDAD</td><td><input name="txteda" value=<%=ObjC.getEdad()%> readonly/></td>
			</tr>
			<tr>
				<td>SEXO</td><td><input name="txtsex" value=<%=ObjC.getSexo()%> readonly/></td>
			</tr>
			<tr>
				<td>FOTO</td><td><img src=img/<%=ObjC.getId()%>.jpg width="200" height="200"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Confirmar" /></td>
			</tr>
		</table>
	</form>
	<a href=index.jsp>Regresar al Listado</a>
</body>
</html>