<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DeleteTemaView</title>
</head>
<body>
	<h2>
		Vista de <b>Borrar Tema</b>
	</h2>
	<c:set var="pView" scope="request" value="${deleteTema}" />
	<div>${pView.update()}</div>
	
	<form action="/JEE_ECP/jsp/deleteTema" method="post">
		<p>
		Nombre del Tema: <select name="nombreTema">
			<c:forEach var="tema" items="${pView.temas}">
				<option value="${tema.id}">${tema.nombreTema}</option>
			</c:forEach>
		</select>
		</p>
		<p>
			Introduzca la autenticación: <input name="autenticacion" type="text" required/>${pView.errorMsg}
		</p>
		<p>
			<input type="submit" value="Borrar" />
		</p>
	</form>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>

</body>
</html>