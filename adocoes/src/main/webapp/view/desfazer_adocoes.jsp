<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Adocao" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
    <title>Cancelando adoção...</title>
</head>
<body>
    <form action="router" method="post">
        <input type="hidden" name="controller" value="Adocoes" />
        <input type="hidden" name="acao" value="cancelar_adocao" /><br/>
        
        <h1>Desfaça sua adoção</h1><br/>
        
        <select name="adocoes_id" required>
        	<option value="" disabled selected>Selecione ID da adoção</option>
            <% 
                List<Adocao> adocoes = (List<Adocao>) request.getAttribute("adocoes");
                
                if (adocoes != null) {
                    for (Adocao ad : adocoes) {
            %>
                        <option value="<%= ad.getAdocao_id() %>">
        					Adotante: <%= ad.getNomeAdotante() %> | Animal: <%= ad.getNomeAnimal() %>
    					</option>
            <%
                    }
                }
            %><br/><br/><br/>
        <input type="submit" value="Desfazer" /><br><br><br>
        <button onclick="window.location.href='index.jsp'">Voltar início</button>
    </form>
</body>
</html>