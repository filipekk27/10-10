<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estiloConsultar.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Sugestão</title>
</head>
<body>


	<c:import url="../topo.jsp" />
	<div id="formulario">
		<form action="#" class="form-inline">

			<div class="form-group">
				<label for="Nome"> # </label><br> <input type="text"
					class="form-control" name="id" placeholder="#"><br>
			</div>
			<br> <br>
			<button type="submit" class="btn btn-primary">Consultar</button>
		</form>
		<br>
	</div>

	<table id="tabela" class="table table-striped">
		<tr style='background-color: #E6E6E6; font-weight: bold;'>

			<td>Id</td>
			<td>Justificativa</td>
			<td>Origem</td>
			<td>Destino</td>
			<td>Partida</td>
			<td>Volta</td>
			<td>Tipo diaria</td>
			<td>Valor diaria</td>

		</tr>
		<c:forEach var="sd" items="${acompanharSolicitacao}">
			<tr>
				<td>${sd.codSD}</td>
				<td>${sd.justificativa}</td>
				<td>${sd.cidOrigem}</td>
				<td>${sd.cidDestino}</td>
				<td>${sd.dataIda}</td>
				<td>${sd.dataVolta}</td>
				<td>${sd.tipoDiaria}</td>
				<td>${sd.valorDiaria}</td>
		</c:forEach>
	</table>
</body>
</html>