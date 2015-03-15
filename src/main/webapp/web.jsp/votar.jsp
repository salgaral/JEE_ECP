<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VotarView</title>
</head>
<body>
	<h2>
		Vista de <b>Votar Tema</b>
	</h2>
	<c:set var="pView" scope="request" value="${tema}" />
	<div>${pView.update()}</div>
	<form action="/JEE_ECP/jsp/votar" method="post" accept-charset="UTF-8">

		<p>Temas Actuales:</p>
		<ul>
			<c:forEach var="tema" items="${rView.temas}">
				<p>Tema</p>
				<p>${tema}</p>
			</c:forEach>
		</ul>

		<p>
			Nombre del Tema: <input name="nombreTema" type="text" />${pView.errorMsg}</p>
		<p>
			IP: <input name="ip" type="text" />${pView.errorMsg}</p>
		<p>
			Nivel de Estudios: <select name="nivelestudio">
				<c:forEach var="nivelestudio" items="${pView.nivelestudios}">
					<option value="${nivelestudio}">${nivelestudio}</option>
				</c:forEach>
			</select>
		<p>
			Valor: <input name="valor" type="text" />${pView.errorMsg}</p>
		<p>

			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
</body>
</html>