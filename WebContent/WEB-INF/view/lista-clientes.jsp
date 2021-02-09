<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Lista clientes </title>		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/estilos.css">
	</head>
	
	<body>

		<h1> Lista de clientes!!! </h1>
		
		<hr>
		
		<table border="1">
			<tr>
				<th> ID </th>
				<th> Nombre </th>
				<th> Apellidos </th>
				<th> Email </th>
			</tr>
			
			<!-- Para acceder a los atributos de cada objeto, deben poseer sus respectivos getters -->
			<c:forEach var="c" items="${clientes }">
				<tr>
					<td> ${c.id} </td>
					<td> ${c.nombre} </td>
					<td> ${c.apellidos} </td>
					<td> ${c.email} </td>
				</tr>
			</c:forEach>
		</table>
		
		<br>
		
		<input type="button" value="Registrar cliente" onclick="window.location.href='formulario_registro'; return false;"/>
		
	</body>
</html>