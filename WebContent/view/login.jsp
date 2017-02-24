<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estiloLogin.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monitoria-Login</title>
</head>
<body>

<div class="col-md-12">
				<div class="page-header">
					<h1>
						Monitoramento de Gastos<br> <small>Governo do Estado
							de Pernambuco</small>
					</h1>
				</div>
				<ul class="nav nav-tabs">
					<li><a href="#">Home</a></li>
					<li><a href="#">Serviços</a></li>
					<li><a href="#">Contato</a></li>
				    <li class="active"><a href="#">Entrar</a></li>
					
					
				
				</ul>
</div>

<div id="formulario">				
<form class="form-inline">
<h3>LOGIN:</h3>

<div class="form-group">
<input type="text" class="form-control" id="cpf" placeholder="Seu CPF">
</div>
	<br><br>		
<div class="form-group">
<input type="password" class="form-control" id="senha" placeholder="Sua Senha">
</div>
	<br><br>
<div class="checkbox">
<label> <input type="checkbox"> Remember me
</label>

</div>
<button type="submit" class="btn btn-default">Entrar</button>

</form>
</div>

</body>
</html>