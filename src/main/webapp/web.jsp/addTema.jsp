<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddTemaView</title>
</head>
<body>
	<h2>
		Vista de <b>Añadir Tema</b>
	</h2>
	<c:set var="pView" scope="request" value="${tema}" />
	<div>${pView.update()}</div>
	<form action="/JEE_ECP/jsp/addTema" method="post" accept-charset="UTF-8">
		<p>
			Nombre del Tema: <input name="nombreTema" type="text" />${pView.errorMsg}</p>
		<p>
			Pregunta: <input name="pregunta" type="text" />${pView.errorMsg}</p>
		<p>
			<input type="submit" value="Añadir" />
		</p>
	</form>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
</body>
</html>