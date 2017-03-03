<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estiloAlterar.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Sugestão</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="ajax.js"></script>
<script>
	$(document).ready(function() {

		$("#estado").change(function() {
			var uf = $('#estado').val();
			$.get("exibirCidade", {
				'cod_cidade' : uf
			}, function(dados) {
				$('#cidade').html(dados);
			});
		});
	});
</script>
<script>
	$(document).ready(function() {

		$("#estado2").change(function() {
			var uf = $('#estado2').val();
			$.get("exibirCidade", {
				'cod_cidade' : uf
			}, function(dados) {
				$('#cidade2').html(dados);
			});
		});
	});
</script>

</head>
<body>
	<c:import url="../topo.jsp" />
	<div id="formulario">
		<h3>Cadastrar Sugestão diaria</h3>
		<form action="">

			<div class="form-group">
				<form:errors path="SugestaoDiaria.cargo" cssStyle="color:red" />
				<label for="Cargo">Cargo</label><br> <select name="cargo"
					required="true">
					<option value="">Selecione o cargo</option>
					<%-- listar cargos no select --%>
					<c:forEach items="${listarCargoUsuario}" var="cargo">
						<option value="${cargo.id}">${cargo.nome}</option>
					</c:forEach>
				</select>
			</div>


			<div class="form-group">
				<form:errors path="SugestaoDiaria.ug" cssStyle="color:red" />
				<label for="UG">Unidade Gestora</label><br> <select name="ug"
					required="true">
					<%-- listar ug no select --%>
					<option value="">Selecione a UG</option>
					<c:forEach items="${listarUGestora}" var="ug">
						<option value="${ug.codigo}">${ug.nome}</option>
					</c:forEach>
				</select>
			</div>


			<div class="form-group">
				<label>Origem</label> <br> <select name="estado" id="estado">
					<%--Lista os estados --%>
					<option value="">Selecione a UF</option>
					<c:forEach var="uf" items="${ListarEstados}">

						<option value="${uf.codigo}">${uf.UF}</option>

					</c:forEach>
				</select>
			</div>
			<div class="form-group" id="cidade">
				<%--Listar cidades --%>
			
			</div>

			<div class="form-group">
				<%--Lista os estados --%>
				<label>Destino</label> <br> <select name="estado2" id="estado2">
					<option value="">Selecione a UF</option>
					<c:forEach var="uf" items="${ListarEstados}">

						<option value="${uf.codigo}">${uf.UF}</option>


					</c:forEach>
				</select>

			</div>
			<%--Listar cidades --%>
			<div class="form-group" id="cidade2">
				
			</div>


			<div class="form-group">
				<label for="Nome">Valores</label><br> <input type="number"
					class="form-control" name="valores" size="10"><br>
			</div>

			<button type="submit" class="btn btn-primary">Sugerir</button>
		</form>

	</div>

	<center>
		<c:import url="../menu.jsp" />
	</center>
</body>
</html>