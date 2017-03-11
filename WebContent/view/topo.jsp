<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/estiloTop.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

<div class="page-header">

<h1>
Monitoramento de Gastos<br> <small>Governo do Estado de Pernambuco</small>
</h1>
<c:choose>
<c:when test="${usuarioLogado.nivel=='ADM'}">

<nav>
    <ul>
        <li><a href="index">Home</a></li>
        <li><a href="#">Usuário</a>
            <ul>
                <li><a href="formCadastro">Cadastrar</a></li>
                <li><a href="listarUsuario">Buscar</a></li>
               
                    
                </li>
            </ul>
        </li>
        <li><a href="#">Cargo</a>
            <ul>
                <li><a href="formCadastroCargo">Cadastrar</a></li>
                <li><a href="listarCargo">Buscar</a></li>
            </ul>
        </li>
        <li><a href="#">UG</a>
            <ul>
                <li><a href="FormCadastroUG">Cadastrar</a></li>
                <li><a href="ListarUG">Buscar</a></li>
            </ul>
        </li>
        <li><a href="#">Sugestão de Diária</a>
            <ul>
                <li><a href="formCadastroSD">Cadastrar</a></li>
                <li><a href="listarSugestao">Buscar</a></li>
            </ul>
        </li>
         <li><a href="#">Solicitação de Diária</a>
            <ul>
                <li><a href="formSolicitarDiaria">Cadastrar</a></li>
                <li><a href="listarSolicitacao">Buscar</a></li>
            </ul>
        </li>
       
    </ul>
    <form action="logout">
    <button type="submit" class="btn btn-default navbar-btn">Sair</button>
    </form>
</nav>
</c:when>
<c:when test="${usuarioLogado.nivel=='USUARIO'}">
<nav>
    <ul>
        <li><a href="index">Home</a></li>
   
         <li><a href="#">Solicitação de Diária</a>
            <ul>
                <li><a href="formSolicitarDiaria">Cadastrar</a></li>
                <li><a href="acompanharSolicitacao">Acompanhar Solicitação</a></li>
            </ul>
        </li>
       
    </ul>
    <form action="logout">
    <button type="submit" class="btn btn-default navbar-btn">Sair</button>
    </form>
    </nav>
</c:when>
<c:otherwise>
<nav>
    <ul>
        <li><a href="index">Home</a></li>
        <li><a href="@">@</a></li>
        <li><a href="@">@</a></li>
        <li><a href="FormLogin">Entrar</a></li>
       
    </ul>
    </nav>
</c:otherwise>
</c:choose>
</div>
		
</body>
</html>