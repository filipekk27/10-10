<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estiloCadastrar.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro usuario</title>
</head>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script>
	$(document).ready(function() { // jQuery  p/ verificar senhas

		$("#confirmaSenha").focusout(function() {
			var s = $('#senha').val();
			var cs = $('#confirmaSenha').val();
			if (s != cs) {
				$('#result').text("as senhas nao sao iguais")
			} else {
				$('#result').remove();
			}

		});
	});
</script>
<body>
	<c:choose>
		<c:when test="${usuarioLogado.nivel=='ADM'}">

			<c:import url="../topo.jsp" />
			<br>
			<c:import url="../usuarioLogado.jsp" />

			<div id="formulario">
				<h3>Cadastro de Usuario</h3>
				<form action="cadastrarUsuario" method="post" class="form-inline">

					<div class="form-group">


						<div id="constrain_error">${msgErrorPkUser}</div>
						<label for="Cpf">CPF*</label><br> <input type="text"
							class="form-control" name="cpf" placeholder="Apenas Numeros"
							size="11" Maxlength="11" Minlength="11" required><br>
						<form:errors path="usuario.cpf" cssStyle="color:red" />
						<br>
					</div>

					<div class="form-group">

						<br /> <label for="Nome">Nome*</label><br> <input
							type="text" class="form-control" name="nome"
							placeholder="Apenas Letras" size="35" Maxlength="60"
							Minlength="8" required><br>
						<form:errors path="usuario.nome" cssStyle="color:red" />
						<br>
					</div>
					<br>
					<div class="form-group">

						<br />
						<div id="constrain_error">${msgErrorPkUser}</div>
						<label for="Email">E-mail*</label><br> <input type="text"
							class="form-control" name="email"
							placeholder="exemplo@exemplo.com" size="30" Maxlength="60"
							Minlength="13" required><br>
						<form:errors path="usuario.email" cssStyle="color:red" />
						<br>
					</div>

					<div class="form-group">

						<br /> <label for="dataNascimento">Data de Nascimento*</label><br>
						<input type="text" class="form-control" name="dataNascimento"
							placeholder="00/00/0000" size="8" Maxlength="10" Minlength="10"
							required><br>
						<form:errors path="usuario.dataNascimento" cssStyle="color:red" />
						<br>
					</div>

					<br>
					<div class="form-group">

						<br /> <label for="Endereco">Endereço</label><br> <input
							type="text" class="form-control" name="endereco"
							placeholder="exemplo exemplo exemplo" size="54"><br>
						<br>
					</div>
					<br>
					<div class="form-group">

						<br /> <label for="Senha">Senha*:</label><br>
						<p id="result" cssStyle="color:red"></p>
						<input type="password" class="form-control" name="senha"
							id="senha" placeholder="senha" Maxlength="8" Minlength="6"
							required><br>
						<form:errors path="usuario.senha" cssStyle="color:red" />
						<br> <br /> <label for="Senha">Confirmar Senha*:</label><br>
						<input type="password" class="form-control" id="confirmaSenha"
							placeholder="senha" Maxlength="8" Minlength="6" required><br>
						<form:errors path="usuario.senha" cssStyle="color:red" />
						<br>
					</div>
					<br>
					<div class="form-group">

						<br /> <label for="Cargo">Cargo*</label><br> <select
							name="cargo" required="true">
							<option value="">Selecione o cargo</option>
							<c:forEach items="${listarCargoUsuario}" var="cargo">
								<c:if test="${cargo.situacao=='ATIVO'}">
									<option value="${cargo.id}">${cargo.nome}</option>
								</c:if>
							</c:forEach>
						</select>
						<form:errors path="usuario.cargo" cssStyle="color:red" />
					</div>
					<br>
					<div class="form-group">

						<br /> <label for="UG">Unidade Gestora*</label><br> <select
							name="uGestora" required="true">
							<option value="">Selecione a UG</option>
							<c:forEach items="${listarUGestora}" var="ug">
								<c:if test="${ug.situacao=='ATIVO'}">
									<option value="${ug.codigo}">${ug.nome}</option>
								</c:if>
							</c:forEach>
						</select>
						<form:errors path="usuario.uGestora" cssStyle="color:red" />
					</div>
					<br> <br>
					<div class="form-group">
						<label for="Status">Situação de Usuario*:</label><br> <input
							type="radio" class="form-control" name="Situacao" value="ATIVO"
							required>
						<form:errors path="usuario.situacao" cssStyle="color:red" />

						<label for="Status">Ativo</label> <input type="radio"
							class="form-control" name="Situacao" value="INATIVO" required>
						<label for="Status">Inativo</label>
					</div>
					<br>
					<div class="form-group">


						<label for="Status">Tipo de Usuario*:</label><br> <input
							type="radio" class="form-control" name="Nivel" value="ADM"
							required> <label for="Status">Administrador</label> <input
							type="radio" class="form-control" name="Nivel" value="USUARIO"
							required> <label for="Status">Usuario comum*</label> <br>

						<input type="radio" class="form-control" name="Nivel"
							value="GESTORUG" required> <label for="Status">Gestor
							UG*</label> <br>
					</div>
					<br> <br>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<jsp:forward page="../index.jsp" />
		</c:otherwise>
	</c:choose>
</body>
</html>