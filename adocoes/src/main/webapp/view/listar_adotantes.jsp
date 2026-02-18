<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Adotante" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Adotantes</title>
    <script src="js/script_adotante.js"></script>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style2.css">
</head>
<body>
    <h1>Lista de Adotantes</h1>
    
    <%
        List<Adotante> adotantes = (List<Adotante>) request.getAttribute("adotantes");
        if (adotantes != null && !adotantes.isEmpty()) {
    %>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Adotante ad : adotantes) {
            %>
            <tr>
                <td><%= ad.getId() %></td>
                <td><%= ad.getNome() %></td>
                <td><%= ad.getTelefone() %></td>
                <td><%= ad.getEmail() %></td>
                <td>
                    <button class="btn-atualizar" data-id="<%= ad.getId() %>">Atualizar</button>
                    <button class="btn-excluir" data-id="<%= ad.getId() %>">Excluir</button>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        } else {
    %>
    <p>Nenhum adotante cadastrado.</p>
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