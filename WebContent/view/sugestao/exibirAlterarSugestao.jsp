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
		<c:when test="${usuarioLogado.nivel=='ADM'}">
			<c:import url="../topo.jsp" />

			<center>
			<h3>Alterar Sugestao</h3>
				<div id="formulario">
					<form class="form-inline" action="alterarSugestao" method="post">
					<div class="form-group">
							<input type="hidden" class="form-control" name="idSD"
								value="${exibirSugestao.idSD}">
						</div>
						<br>
						<div class="form-group">
							
							<br /> <label for="Cargo">Cargo</label><br> <select
								name="cargo" required="true">
								<option value="${exibirSugestao.cargo.id}">${exibirSugestao.cargo.nome}</option>
								<c:forEach items="${listarCargoUsuario}" var="cargo">
									<option value="${cargo.id}">${cargo.nome}</option>
								</c:forEach>
							</select>
							<br>
						</div>
						
						<div class="form-group">
							
							<br /> <label for="UG">Unidade Gestora</label><br> <select
								name="ug" required="true">
								<option value="${exibirSugestao.ug.codigo}">${exibirSugestao.ug.nome}</option>
								<c:forEach items="${listarUGestora}" var="ug">
									<option value="${ug.codigo}">${ug.nome}</option>
								</c:forEach>
							</select>
						</div>
						<br>
					
                             <div class="form-group">
                             <br>
                             <label for="valores">Valor</label><br>
							<input type="text" class="form-control" name="valores" maxlength="8"
								value="${exibirSugestao.valores}">
						</div>

						<br><br>
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