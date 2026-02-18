<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<title>Adoções</title>
</head>
<body>

	<div class="home">
		<h1>Sistema de Adoções</h1>
		<ol>
			<li><a href="router?controller=Animais&acao=cadastrar">Cadastrar animal</a></li>
			<li><a href="router?controller=Adotantes&acao=cadastrar">Cadastrar adotante</a></li>
			<li><a href="router?controller=Adocoes&acao=cadastrar">Cadastrar adoção</a></li>
			<li><a href="router?controller=Animais&acao=listar">Listar animal</a></li>
			<li><a href="router?controller=Adotantes&acao=listar">Listar adotante</a></li>
			<li><a href="router?controller=Adocoes&acao=listar">Listar adoções</a></li>
			<li><a href="router?controller=Adocoes&acao=desfazer_adocao">Desfazer adoções</a></li>
			
			
		</ol>
	</div>
	
</body>
</html>