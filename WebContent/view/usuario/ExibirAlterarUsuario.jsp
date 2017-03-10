<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Usuario</title>
</head>
<body>
	<c:choose>
		<c:when test="${usuarioLogado.nivel=='ADM'}">
			<c:import url="../topo.jsp" />

			<center>
				<div id="formulario">
					<form class="form-inline" action="AlterarUsuario" method="post">

						<h3>Alterar Usuario</h3>
						<div class="form-group">
							<input type="hidden" class="form-control" name="idUser"
								value="${exibirUsuario.idUser}">
						</div>

						<div class="form-group">
							<form:errors path="usuario.nome" cssStyle="color:red" />
							<br /> <label for="Nome">Nome</label><br> <input
								type="text" class="form-control" name="nome"
								value="${exibirUsuario.nome}" size="35" Maxlength="60"
								Minlength="8"><br>
						</div>
						<br>
						<div class="form-group">
							<form:errors path="usuario.endereco" cssStyle="color:red" />
							<br /> <label for="Endereco">Endereço</label><br> <input
								type="text" class="form-control" name="endereco"
								value="${exibirUsuario.endereco}" size="54" Maxlength="60"
								Minlength="10"><br>
						</div>
						<br>
						<div class="form-group">
							<form:errors path="usuario.dataNascimento" cssStyle="color:red" />
							<br /> <label for="dataNascimento">Data de Nascimento</label><br>
							<input type="text" class="form-control" name="dataNascimento"
								value="${exibirUsuario.dataNascimento}" size="8" Maxlength="10"
								Minlength="10"><br>
						</div>
						<br>
						<div class="form-group">
							<form:errors path="usuario.cargo" cssStyle="color:red" />
							<br /> <label for="Cargo">Cargo</label><br> <select
								name="cargo" required="true">
								<option value="${exibirUsuario.cargo.id}">${exibirUsuario.cargo.nome}</option>
								<c:forEach items="${listarCargoUsuario}" var="cargo">
									<option value="${cargo.id}">${cargo.nome}</option>
								</c:forEach>
							</select>
						</div>
						<br>
						<div class="form-group">
							<form:errors path="usuario.uGestora" cssStyle="color:red" />
							<br /> <label for="UG">Unidade Gestora</label><br> <select
								name="uGestora" required="true">
								<option value="${exibirUsuario.uGestora.codigo}">${exibirUsuario.uGestora.nome}</option>
								<c:forEach items="${listarUGestora}" var="ug">
									<option value="${ug.codigo}">${ug.nome}</option>
								</c:forEach>
							</select>
						</div>
						<br>
						<%--  Exibir radio ja com o value do banco --%>
						<div class="form-group">
							<label for="Status">Ativo</label>
							<c:choose>
								<c:when test="${exibirUsuario.situacao=='ATIVO'}">
									<input type="radio" class="form-control" name="Situacao"
										value="ATIVO" checked="true">
									<br>
								</c:when>
								<c:otherwise>
									<input type="radio" class="form-control" name="Situacao"
										value="ATIVO">
								</c:otherwise>
							</c:choose>
							<label for="Status">Inativo</label>
							<c:choose>
								<c:when test="${exibirUsuario.situacao=='INATIVO'}">
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
						<%--  Exibir radio ja com o value do banco --%>
						<div class="form-group">
							<label for="Status">Administrador</label>
							<c:choose>
								<c:when test="${exibirUsuario.nivel=='ADM'}">
									<input type="radio" class="form-control" name="Nivel"
										value="ADM" checked="true">
									<br>
								</c:when>
								<c:otherwise>
									<input type="radio" class="form-control" name="Nivel"
										value="ADM">
								</c:otherwise>
							</c:choose>
							<label for="Status">Usuario comum</label>
							<c:choose>
								<c:when test="${exibirUsuario.situacao=='INATIVO'}">
									<input type="radio" class="form-control" name="Nivel"
										value="USUARIO" checked="true">
									<br>
								</c:when>
								<c:otherwise>
									<input type="radio" class="form-control" name="Nivel"
										value="USUARIO">
								</c:otherwise>
							</c:choose>
						</div>
						<br>
						<button type="submit" class="btn btn-primary">Alterar</button>
					</form>
				</div>
			</center>

			<br>
			<center></center>
		</c:when>
		<c:otherwise>
		<jsp:forward page="../index.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>