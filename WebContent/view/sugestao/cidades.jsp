<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%--Listar cidades --%>
				<label>Cidade Origem</label> <br> <select name="cidade"
					id="cidade">
					<option value="">Selecione a cidade</option>
					<c:forEach var="cd" items="${cidade}">

						<option value="${cd.cod_cidade}">${cd.nome}</option>

					</c:forEach>
				</select>
</body>
</html>