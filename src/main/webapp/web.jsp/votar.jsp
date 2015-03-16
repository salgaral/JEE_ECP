<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VotarView</title>
</head>
<body>
	<h2>
		Vista de <b>Votar Tema</b>
	</h2>
	<c:set var="pView" scope="request" value="${votar}" />
	<div>${pView.update()}</div>
	<form action="/JEE_ECP/jsp/votar" method="post" accept-charset="UTF-8">

		<p>Temas Actuales:</p>
	
		<p>Nombre del Tema: <select name="nombretema">
			<c:forEach var="tema" items="${pView.temas}">
				<option value="${tema.nombreTema}">${tema.nombreTema}</option>
			</c:forEach>
		</select>
		</p>
		
		<p>
			Nivel de Estudios: <select name="nivelestudio">
				<c:forEach var="nivelestudio" items="${pView.nivelEstudios}">
					<option value="${nivelestudio}">${nivelestudio}</option>
				</c:forEach>
			</select>
		</p>
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