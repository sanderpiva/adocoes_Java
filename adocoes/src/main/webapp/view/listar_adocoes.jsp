<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Adocao" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adoções realizadas</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style2.css">
</head>
<body class="home-lista"> <h1>Lista de Adoções registradas</h1>
    
    <%
        List<Adocao> adocoes = (List<Adocao>) request.getAttribute("adocoes");
        if (adocoes != null && !adocoes.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Adotante</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Animal</th>
                <th>Data adoção</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Adocao adc : adocoes) {
            %>
            <tr>
                <td><%= adc.getAdotantes_id() %></td>
                <td><%= adc.getNomeAdotante() %></td>
                <td><%= adc.getTelefoneAdotante() %></td>
                <td><%= adc.getEmailAdotante() %></td>
                <td><%= adc.getNomeAnimal() %></td>
                <td><%= adc.getDate_adocao() %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        } else {
    %>
    <p>Nenhuma adoção registrada.</p>
    <%
        }
    %>

    <div class="container-voltar">
        <button type="button" class="btn-voltar" onclick="window.location.href='index.jsp'">
            Voltar início
        </button>
    </div>

</body>
</html>