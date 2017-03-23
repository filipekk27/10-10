<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estiloCadastrar.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Altera��o de cargo</title>
</head>
<body>
	<c:choose>
		<c:when test="${usuarioLogado.nivel=='ADM'}">

			<c:import url="../topo.jsp" />
			<br>
			<c:import url="../usuarioLogado.jsp" />
			<div id="formulario">
				<form class="form-inline" action="alterarCargo" method="post">

					<h3>Alterar Cargo</h3>
					<div class="form-group">
						<form:errors path="cargo.nome" cssStyle="color:red" />
						<!-- bean validation  -->
						<br /> <label for="Nome">Nome:</label><br> <input
							type="text" class="form-control" name="nome" required="true"
							maxlength="40" minlength="5" value="${ExibirAlterarCargo.nome}">
					</div>
					<br> <br>
					
						<input type="hidden"  name="id"
							value="${ExibirAlterarCargo.id}" readonly>
							<input type="hidden"  name="idUsuario"
							value="${usuarioLogado.idUser}" readonly>

					

					<div class="form-group">
						<label for="Status">Situa��o do Cargo:</label><br> <label
							for="Status">Ativado</label>
						<c:choose>
							<c:when test="${ExibirAlterarCargo.situacao=='ATIVO'}">
								<input type="radio" class="form-control" name="Situacao"
									value="ATIVO" checked="true">
								<br>
							</c:when>
							<c:otherwise>
								<input type="radio" class="form-control" name="Situacao"
									value="ATIVO">
							</c:otherwise>
						</c:choose>
						<label for="Status">Desativado</label>
						<c:choose>
							<c:when test="${ExibirAlterarCargo.situacao=='INATIVO'}">
								<input type="radio" class="form-control" name="Situacao"
									value="INATIVO" checked="true">
								<br>
							</c:when>
							<c:otherwise>
								<input type="radio" class="form-control" name="Situacao"
									value="INATIVO">
							</c:otherwise>
						</c:choose>
					</div>
					<br>
					<button type="submit" class="btn btn-primary">Alterar</button>
				</form>
			</div>
			<br>

		</c:when>
		<c:otherwise>
			<jsp:forward page="../index.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>