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
		<input type="text" name="nameTema" value="${pView.tema.nombreTema}" hidden />
		
		<p>Pregunta: ${pView.tema.pregunta}
		
		</p>
		
		<p>
			Nivel de Estudios: <select name="nivelestudio">
				<c:forEach var="nivelestudio" items="${pView.nivelEstudios}">
					<option value="${nivelestudio}">${nivelestudio}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			Puntuación: <select name="puntuacion">
  							<option value="cero">0</option>
  							<option value="uno">1</option>
  							<option value="dos">2</option>
  							<option value="tres">3</option>
  							<option value="cuatro">4</option>
  							<option value="cinco">5</option>
  							<option value="seis">6</option>
  							<option value="siete">7</option>
  							<option value="ocho">8</option>
  							<option value="nueve">9</option>
  							<option value="diez">10</option>
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