<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VerVotacionesView</title>
</head>
<body>

	<h2>
		Vista de <b>Ver Votaciones</b>
	</h2>
	
	<c:forEach var="posicion" items="${verVotaciones.mapaNumeroVotos}">
  		Tema: <c:out value="${posicion.key}" /><br/>
  		Numero de Votos: <c:out value="${posicion.value}" /><br/><br/>
	</c:forEach>

	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>
	
</body>
</html>