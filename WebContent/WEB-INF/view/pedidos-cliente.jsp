<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Pedidos </title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/estilos.css">
	</head>
	
	<body>
		<h1> Lista de pedidos - ${cliente.nombre } ${cliente.apellidos} </h1>
		
		<hr>
		
		<p> (Listando...) </p>
		
		<hr>
		
		<input type="button" value="Nuevo pedido" onclick="window.location.href='formulario_nuevo_pedido/'+${cliente.id}; return false;"/>
	</body>
</html>