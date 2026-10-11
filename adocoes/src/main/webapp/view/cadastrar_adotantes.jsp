<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<title>Cadastrar adotante</title>
</head>
<body>
	<form action="router" method="post">
    <input type="hidden" name="controller" value="Adotantes" />
    <input type="hidden" name="acao" value="salvar" /><br/>
    
     <h1>Adotantes</h1><br/>
    
    Nome <input type="text" name="nome" required /><br/><br/>
    Telefone <input type="text" name="telefone" required /><br/><br/>
    Email <input type="email" name="email" required /><br/><br/>
    
    <input type="submit" value="Salvar" /><br><br><br>
    <button onclick="window.location.href='index.jsp'">Voltar início</button>
</form>
</body>
</html>