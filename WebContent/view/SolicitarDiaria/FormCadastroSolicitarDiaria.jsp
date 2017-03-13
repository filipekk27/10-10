<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solicitar Diaria</title>
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/estiloAlterar.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Sugestão</title>
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script>
	$(document).ready(function() {

		$("#estado").change(function() {
			var uf = $('#estado').val();
			$.get("listarCidade", {
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
			$.get("listarCidade2", {
				'cod_cidade' : uf
			}, function(dados) {
				$('#cidade2').html(dados);
			});
		});
	});
</script>
<script>
	$(document).ready(function() {

		$("#gerarValor").click(function() {
			var origem = $('#CidOrigem').val();
			var destino = $('#CidDestino').val();
			$.get("exibirValor", {
				'origem' : origem,
				'destino' : destino
			}, function(dados) {
				$('#valor').html(dados);
			});
		});
	});
</script>
<body>
	<c:import url="../topo.jsp" />
	<div id="formulario">
		<form action="cadastarSolicitacao" method="post">
			<%--Listar cidades --%>
			<input type="hidden" name="IdUsuario" value="${usuarioLogado.idUser}">
			<input type="hidden" name="unidadeGestora" value="${usuarioLogado.uGestora}">
			<div class="form-group">
				<label for="DataIda">Data Partida</label><br> <input
					type="text" class="form-control" name="DataIda"> <label
					for="DataVolta">Data Volta</label><br> <input type="text"
					class="form-control" name="DataVolta">
			</div>

			<div class="form-group">
				<input type="radio" name="tipoDiaria" value="P"> <label
					for="Nome">Parcial</label> <input type="radio" name="tipoDiaria"
					value="I"> <label for="Nome">Integral</label>
			</div>
			<div class="form-group">
				<label for="Justificativa">Justificativa</label><br>
				<textarea name="Justificativa"> </textarea>

			</div>
			<div class="form-group">
				<label>Origem</label> <br> <select id="estado" required="true">
					<%--Lista os estados --%>
					<option value="">Selecione a UF</option>
					<c:forEach var="uf" items="${ListarEstados}">

						<option value="${uf.codigo}">${uf.UF}</option>

					</c:forEach>
				</select>
			</div>
			<div class="form-group" id="cidade"></div>
			<div class="form-group">
				<%--Lista os estados --%>
				<label>Destino</label> <br> <select id="estado2"
					required="true">
					<option value="">Selecione a UF</option>
					<c:forEach var="uf" items="${ListarEstados}">

						<option value="${uf.codigo}">${uf.UF}</option>

					</c:forEach>
				</select>
				<div class="form-group" id="cidade2"></div>

				<button type="button" id="gerarValor">Consultar Diaria</button>
			</div>
			<div class="form-group" id="valor"></div>
			<button type="submit" class="btn btn-primary">Solicitar</button>
		</form>

	</div>
</body>
</html>