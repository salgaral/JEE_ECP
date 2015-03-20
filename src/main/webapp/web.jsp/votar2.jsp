<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>
		Vista de <b>Votar Tema 2</b>
	</h2>
	<c:set var="pView" scope="request" value="${votar}" />

	<form action="/JEE_ECP/jsp/votar2" method="post" accept-charset="UTF-8">
	
		<p>Tema Seleccionado: ${pView.tema.nombreTema}</p>
		<input type="text" name="id" value="${pView.tema.id}" hidden />
		
		<p>Pregunta: ${pView.tema.pregunta}
		
		</p>
		
		<p>
			Nivel de Estudios: <select name="nivelEstudios">
				<c:forEach var="nivelestudio" items="${pView.nivelEstudios}">
					<option value="${nivelestudio}">${nivelestudio}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Puntuación: <select name="valor">
  							<option value="0">0</option>
  							<option value="1">1</option>
  							<option value="2">2</option>
  							<option value="3">3</option>
  							<option value="4">4</option>
  							<option value="5">5</option>
  							<option value="6">6</option>
  							<option value="7">7</option>
  							<option value="8">8</option>
  							<option value="9">9</option>
  							<option value="10">10</option>
						</select>${pView.errorMsg}
		</p>
		<p>

			<input type="submit" value="Votar" />
		</p>
	</form>
	<p>
		<a href="/JEE_ECP/jsp/home">Volver a Home</a>
	</p>

</body>
</html>