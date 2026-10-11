<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Animal" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Animais</title>
    <script src="js/script_animal.js"></script>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style2.css">
</head>
<body>
    <h1>Lista de Animais</h1>
    
    <%
        List<Animal> animais = (List<Animal>) request.getAttribute("animais");
        if (animais != null && !animais.isEmpty()) {
    %>
   
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Espécie</th>
                <th>Raça</th>
                <th>Descrição</th>
                <th>Status</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Animal a : animais) {
            %>
            <tr>
                <td><%= a.getId() %></td>            
                <td><%= a.getNome() %></td>
                <td><%= a.getEspecie() %></td>
                <td><%= a.getRaca() %></td>
                <td><%= a.getDescricao() %></td>
                <td><%= a.getDisponivel() ? "Disponível" : "Indisponível" %></td>
                <td>
                    <button class="btn-atualizar" data-id="<%= a.getId() %>">Atualizar</button>
                    <button class="btn-excluir" data-id="<%= a.getId() %>">Excluir</button>
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
        <p>Nenhum animal cadastrado.</p>
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