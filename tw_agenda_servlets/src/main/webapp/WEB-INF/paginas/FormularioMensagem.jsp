<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Digite seu nome...</title>
</head>
<body>
	<form method="post" action="/tw_agenda_servlets/mensagem" enctype="application/x-www-form-urlencoded">
		<p>Digite seu nome:</p>
		<p><input type="text" name="nomeUsuario"></input></p>
		<button type="submit">Enviar!</button>
	</form>
</body>
</html>