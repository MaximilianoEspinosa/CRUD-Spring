<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Nuevo cliente </title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/estilos.css">
	</head>

	<body>
		<h1> Registro/modificación cliente!!! </h1>
		
		<hr>
		
		<form:form action="registrar_cliente" modelAttribute="nuevo_cliente" method="POST">
		
			<form:hidden path="id" />
		
			<table>
			
				<tr>
					<td> Nombre: </td>
					<td> <form:input path="nombre"/></td>				
				</tr>
				
				<tr>
					<td> Apellidos: </td>
					<td> <form:input path="apellidos"/></td>				
				</tr>
				
				<tr>
					<td> Email: </td>
					<td> <form:input path="email"/></td>				
				</tr>
				
				<tr>
					<td colspan	="2"> 
						<input type="submit" value="Registrar"> 
					</td>
				</tr>
			
			</table>
		</form:form>
		
		<hr>
		
		<form:form action="eliminar_cliente" modelAttribute="nuevo_cliente" method="POST">
			<form:hidden path="id" />
			<input type="submit" value="Eliminar">
		</form:form>
		
		
	</body>
</html>