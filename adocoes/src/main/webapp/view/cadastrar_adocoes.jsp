<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Adotante" %>
<%@ page import="model.Animal" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
    <title>Adotando...</title>
</head>
<body>
    <form action="router" method="post">
        <input type="hidden" name="controller" value="Adocoes" />
        <input type="hidden" name="acao" value="salvar" /><br/>
        
        <h1>Realize sua adoção</h1><br/>
        Adotante
        <select name="adotantes_id" required>
        	<option value="" disabled selected>Selecione adotante</option>
            <% 
                List<Adotante> adotantes = (List<Adotante>) request.getAttribute("adotantes");
                
                if (adotantes != null) {
                    for (Adotante ad : adotantes) {
            %>
                        <option value="<%= ad.getId() %>"><%= ad.getNome() %></option>
            <%
                    }
                }
            %>
        </select><br/><br/><br/>
        
        Animal
        <select name="animais_id" required>
        	<option value="" disabled selected>Selecione animal</option>
            <% 
                List<Animal> animais = (List<Animal>) request.getAttribute("animais");
                if (animais != null) {
                    for (Animal an : animais) {
            %>
                        <option value="<%= an.getId() %>"><%= an.getNome() %></option>
            <%
                    }
                }
            %>
        </select><br/><br/><br/>
        
        Data <input type="date" name="data" required /><br/><br/><br/>
        
        <input type="submit" value="Salvar" /><br><br><br>
        <button onclick="window.location.href='index.jsp'">Voltar início</button>
    </form>
</body>
</html>