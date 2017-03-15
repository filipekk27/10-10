<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Sugestao</title>
</head>
<body>
	<c:choose>
		<c:when test="${usuarioLogado.nivel=='GESTORUG'}">
			<c:import url="../topo.jsp" />

			<center>
			<br>			<br>
				<h3>Alterar Solicitacao</h3>
				<div id="formulario">
					<form class="form-inline" action="alterarSolicitacao" method="get">

						<input type="hidden" class="form-control" name="codSD"
							value="${exibirSolicitacao.codSD}">
						<%-- id solicitacão --%>

						<input type="hidden" class="form-control" name="idGestor"
							value="${usuarioLogado.idUser}">
						<%-- id Usuario Logado --%>

						<div class="form-group">

							<label for="JustificativaGestor">Justificativa</label><br> 
							<textarea name="justificativaGestor"></textarea>
								
						</div>
						<br>
						<div class="form-group">
						<label for="Deferimento">Aceitar</label>
							<input type="radio" name="def" id="def" value="Aceitado">
							<label for="Deferimento">Recusar</label>
							<input type="radio" name="def" id="def" value="Recusado">
						</div>

						<br>
						<br>
						<button type="submit" class="btn btn-primary">Alterar</button>
					</form>
				</div>
			</center>

			<br>
		</c:when>
		<c:otherwise>
			<jsp:forward page="../index.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>