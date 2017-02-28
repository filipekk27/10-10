<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estiloConsultar.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Usuario</title>
</head>
<body>
	<c:import url="../topo.jsp" />

	<div id="formulario">
		<form action="listarCargo" class="form-inline">
			<h3>Consultar Usuario</h3>
			<div class="form-group">
				<label for="Nome">#</label><br> <input type="text"
					class="form-control" name="nome" placeholder="#"><br>
			</div>
			<br> <br>
			<button type="submit" class="btn btn-primary">Consultar</button>
		</form>
		<br>
	</div>
	<br>
	<table id="tabela" class="table table-striped">
		<tr style='background-color: #E6E6E6; font-weight: bold;'>

			<td>Id</td>
			<td>Nome</td>
			<td>Cargo</td>
			<td>UG</td>
			<td>Cpf</td>
			<td>E-mail</td>
			<td>Endereco</td>
			<td>Data Cadastro</td>
			<td>Data Nascimento</td>
			<td>Senha</td>
			<td>Status</td>
			<td>Ações</td>


			<c:forEach var="user" items="${ListarUsuario}">
				<tr>
					<c:if test="${user.situacao=='ATIVO'}">
						<td>${user.id}</td>
						<td>${user.nome}</td>
						<td>${user.cargo.nome}</td>
						<td>${user.uGestora.nome}</td>
						<td>${user.cpf}</td>
						<td>${user.email}</td>
						<td>${user.endereco}</td>
						<td><fmt:formatDate value="${user.dataCadastro}"
								pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${user.dataNascimento}"
								pattern="dd/MM/yyyy" /></td>
						<td>${user.senha}</td>
						<td>${user.situacao}</td>
						<td>
						<a href="exibirAlterarUsuario?id=${user.id}">Alterar</a>
						</td>
					</c:if>
				</tr>

			</c:forEach>
	</table>
	<center>
		<c:import url="../menu.jsp" />
	</center>
</body>
</html>