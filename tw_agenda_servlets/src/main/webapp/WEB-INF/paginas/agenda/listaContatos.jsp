<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de contatos...</title>
</head>
<body>
	<h3>Lista de contatos</h3>
	<p style="color: red;">${mensagemErro}</p>
	<table border="1" style="padding:5" style="spacing:1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Idade</th>
				<th>Telefone</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${listaContatos}" var="contato">
				<tr>
					<td>${contato.nome}</td>
					<td>${contato.idade}</td>
					<td>${contato.telefone}</td>
					<td>
						<a href="agenda/editar?id=${contato.id}">Editar</a> |
						<a href="agenda/excluir?id=${contato.id}">Excluir</a>
					</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<a href="agenda/incluir">Criar novo contato...</a>
</body>
</html>