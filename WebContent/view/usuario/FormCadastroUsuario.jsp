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
<body>
	<c:import url="../topo.jsp" />


	<div id="formulario">
		<h3>Cadastro de Usuario</h3>
		<form action="cadastrarUsuario" method="post" class="form-inline">

			<div class="form-group">
				<form:errors path="usuario.cpf" cssStyle="color:red" />

				<div id="constrain_error">${msgErrorPkUser}</div>
				<label for="Cpf">CPF</label><br> <input type="text"
					class="form-control" name="cpf" placeholder="Apenas Numeros"
					size="11" Maxlength="11" Minlength="11" required><br>
			</div>

			<div class="form-group">
				<form:errors path="usuario.nome" cssStyle="color:red" />
				<br /> <label for="Nome">Nome</label><br> <input type="text"
					class="form-control" name="nome" placeholder="Apenas Letras"
					size="35" Maxlength="60" Minlength="8"><br>
			</div>
			<br>
			<div class="form-group">
				<form:errors path="usuario.email" cssStyle="color:red" />
				<br />
				<div id="constrain_error">${msgErrorPkUser}</div>
				<label for="Email">E-mail</label><br> <input type="text"
					class="form-control" name="email" placeholder="exemplo@exemplo.com"
					size="30" Maxlength="30" Minlength="13"><br>
			</div>

			<div class="form-group">
				<form:errors path="usuario.dataNascimento" cssStyle="color:red" />
				<br /> <label for="dataNascimento">Data de Nascimento</label><br>
				<input type="text" class="form-control" name="dataNascimento"
					placeholder="00/00/0000" size="8" Maxlength="10" Minlength="10"><br>
			</div>

			<br>
			<div class="form-group">
				<form:errors path="usuario.endereco" cssStyle="color:red" />
				<br /> <label for="Endereco">Endereço</label><br> <input
					type="text" class="form-control" name="endereco"
					placeholder="exemplo exemplo exemplo" size="54" Maxlength="60"
					Minlength="10"><br>
			</div>
			<br>
			<div class="form-group">
				<form:errors path="usuario.senha" cssStyle="color:red" />
				<br /> <label for="Senha">Senha</label><br> <input
					type="password" class="form-control" name="senha"
					placeholder="senha" Maxlength="15" Minlength="6"><br>
			</div>
			<br>
			<div class="form-group">
				<form:errors path="usuario.cargo" cssStyle="color:red" />
				<br /> <label for="Cargo">Cargo</label><br> <select
					name="cargo" required="true">
					<option value="">Selecione o cargo</option>
					<c:forEach items="${listarCargoUsuario}" var="cargo">
						<c:if test="${cargo.situacao=='ATIVO'}">
							<option value="${cargo.id}">${cargo.nome}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<br>
			<div class="form-group">
				<form:errors path="usuario.uGestora" cssStyle="color:red" />
				<br /> <label for="UG">Unidade Gestora</label><br> <select
					name="uGestora" required="true">
					<option value="">Selecione a UG</option>
					<c:forEach items="${listarUGestora}" var="ug">
						<c:if test="${ug.situacao=='ATIVO'}">
							<option value="${ug.codigo}">${ug.nome}</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<br>
			<div class="form-group">
				<form:errors path="usuario.situacao" cssStyle="color:red" />
				<label for="Status">On</label> <input type="radio"
					class="form-control" name="Situacao" value="ATIVO"><br>

				<label for="Status">Off</label> <input type="radio"
					class="form-control" name="Situacao" value="INATIVO"><br>
			</div>
			<br> <br>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>
	<c:import url="../menu.jsp" />
</body>
</html>