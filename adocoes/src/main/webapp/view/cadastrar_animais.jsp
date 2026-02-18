<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<title>Cadastrar animais</title>
</head>
<body>
<form action="router" method="post">
    <input type="hidden" name="controller" value="Animais" />
    <input type="hidden" name="acao" value="salvar" /><br/>
    
     <h1>Animais para adoção</h1><br/>
    
    Nome <input type="text" name="nome" required /><br/><br/>
    Especie <input type="text" name="especie" required /><br/><br/>
    Raca <input type="text" name="raca" required /><br/><br/>
    Descricao <input type="text" name="descricao" required />
    
    <div>
    	Disponível <input type="checkbox" name="disponivel" value="true" />
    
    </div>
    
    <input type="submit" value="Salvar" /><br><br><br>
	<button onclick="window.location.href='index.jsp'">Voltar início</button>
</form>

</body>


</html>
