<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<br>
	<c:import url="../usuarioLogado.jsp" />
	<c:choose>
		<c:when test="${usuarioLogado.nivel=='GESTORUG'}">
			<table id="tabela" class="table table-striped">
				<tr style='background-color: #E6E6E6; font-weight: bold;'>


					<td>Motivo</td>
					<td>Origem</td>
					<td>Destino</td>
					<td>Partida</td>
					<td>Volta</td>
					<td>Tipo diaria</td>
					<td>Valor diaria</td>
					<td>Nome Usuario</td>
					<td>Justificativa Gestor</td>
					<td>Nome Gestor</td>
					<td>Status</td>
					<td>Ação</td>

				</tr>
				<c:forEach var="sd" items="${ListarSolicitacaoGestor}">
					<tr>

						<td>${sd.justificativa}</td>
						<td>${sd.cidOrigem}</td>
						<td>${sd.cidDestino}</td>
						<td><fmt:formatDate value="${sd.dataIda}"
								pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${sd.dataVolta}"
								pattern="dd/MM/yyyy" /></td>
						<td>${sd.tipoDiaria}</td>
						<td>${sd.valorDiaria}</td>
						<td>${sd.idUsuario.nome}</td>
						<td>${sd.justificativaGestor}</td>
						<td>${sd.idGestor.nome}</td>
						<c:choose>
							<c:when test="${sd.def=='Aceitado'}">
								<td bgcolor="green">${sd.def}</td>
							</c:when>
							<c:when test="${sd.def=='Recusado'}">
								<td bgcolor="red">${sd.def}</td>
							</c:when>
							<c:otherwise>
								<td bgcolor="yellow">${sd.def}</td>
							</c:otherwise>
						</c:choose>
						<td><a
							href="ExibiralterarSolicitacao?idSolicitacao=${sd.codSD}">Alterar</a></td>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<table id="tabela" class="table table-striped">
				<tr style='background-color: #E6E6E6; font-weight: bold;'>


					<td>Motivo</td>
					<td>Origem</td>
					<td>Destino</td>
					<td>Partida</td>
					<td>Volta</td>
					<td>Tipo diaria</td>
					<td>Valor diaria</td>
					<td>Justificativa Gestor</td>
					<td>Nome Gestor</td>
					<td>Status</td>

				</tr>
				<c:forEach var="sd" items="${acompanharSolicitacao}">
					<tr>

						<td>${sd.justificativa}</td>
						<td>${sd.cidOrigem}</td>
						<td>${sd.cidDestino}</td>
						<td><fmt:formatDate value="${sd.dataIda}"
								pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${sd.dataVolta}"
								pattern="dd/MM/yyyy" /></td>
						<td>${sd.tipoDiaria}</td>
						<td>${sd.valorDiaria}</td>
						<td>${sd.justificativaGestor}</td>
						<td>${sd.idGestor.nome}</td>
						<c:choose>
							<c:when test="${sd.def=='Aceitado'}">
								<td bgcolor="green">${sd.def}</td>
							</c:when>
							<c:when test="${sd.def=='Recusado'}">
								<td bgcolor="red">${sd.def}</td>
							</c:when>
							<c:otherwise>
								<td bgcolor="yellow">${sd.def}</td>
							</c:otherwise>
						</c:choose>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>