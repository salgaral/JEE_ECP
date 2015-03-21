<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VotacionesView</title>
</head>
<body>

	<h2>
		Vista de <b>Ver Votaciones</b>
	</h2>
	<c:set var="pView" scope="request" value="${verVotaciones}" />
	<div>${pView.update()}</div>
	
	<c:forEach var="posicion" items="${verVotaciones.mapaNumeroVotos}">
  		Tema: <c:out value="${posicion.key}" /><br/>
  		Número de Votos: <c:out value="${posicion.value}" /><br/><br/>
	</c:forEach>
	
	<c:forEach var="posicion2" items="${verVotaciones.mapaMediaVotos}">
  		Nivel de Estudio: <c:out value="${posicion2.key}" /><br/>
  		Media de los Votos: <c:out value="${posicion2.value}" /><br/><br/>
	</c:forEach>

	<p><a href="/JEE_ECP/jsp/home">Volver a Home</a></p>
	
</body>
</html>