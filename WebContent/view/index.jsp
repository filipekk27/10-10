<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estiloIndex.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monitoria de Gastos</title>
</head>

<body>

<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						Monitoramento de Gastos<br> <small>Governo do Estado
							de Pernambuco</small>
					</h1>
				</div>
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Serviços</a></li>
					<li><a href="#">Contato</a></li>
				    <li><a href="#">Entrar</a></li>
					
					
				
				</ul>
				<br>
				<br>
				<div class="jumbotron well">
					<h2>Seja Bem-Vindo!!</h2>
					<p>Nosso objetivo é acompanhar as despesas,
						mantendo uma assídua orientação aos agentes públicos para o
						equilíbrio das contas, a manutenção dos serviços e das políticas
						públicas, ressaltando a importância de não elevar as despesas..</p>
					<p></p>
				</div>

				<br>
				<br>
				<div class="row">
					<div class="col-md-4">
						<center><h2>Solicitação</h2></center>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>

					</div>
					<div class="col-md-4">
						<center><h2>Consulta</h2></center>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>

					</div>
					<div class="col-md-4">
						<center><h2>Análise</h2></center>
						<p>Donec id elit non mi porta gravida at eget metus. Fusce
							dapibus, tellus ac cursus commodo, tortor mauris condimentum
							nibh, ut fermentum massa justo sit amet risus. Etiam porta sem
							malesuada magna mollis euismod. Donec sed odio dui.</p>

					</div>
				</div>
			</div>
		</div>
	</div>
<c:import url="menu.jsp" />
</body>
</html>