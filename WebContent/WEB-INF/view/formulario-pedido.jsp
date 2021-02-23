<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Nuevo pedido </title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/estilos.css">
	</head>
	
	<body>
		<h1> Registro nuevo pedido - ${cliente.nombre } ${cliente.apellidos }</h1>
		
		<hr>
		
		<form:form action=" registrar_pedido/${cliente.id} " modelAttribute="pedido" method="POST">
			
			<form:hidden path="id" />
			
			<table>
				<tr>
					<td> Forma pago: </td>
					<td> <form:input path="formaPago"/></td>				
				</tr>
				
				<tr>
					<td> Fecha: </td>
					<td> 
						<form:input type="date" path="fecha" cssClass="form-control" /> 
					</td>				
				</tr>
				
				<tr>
					<td colspan	="2"> 
						<input type="submit" value="Registrar"> 
					</td>
				</tr>
			
			</table>
		</form:form>
	</body>
</html>