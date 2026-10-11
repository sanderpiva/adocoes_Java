<%@ page import="model.Animal" %>
<% Animal animal = (Animal) request.getAttribute("animalParaAtualizar"); %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<body class="home"> <form action="router" method="post"> <input type="hidden" name="controller" value="Animais">
    <input type="hidden" name="acao" value="atualizar">
    <input type="hidden" name="id" value="<%= animal.getId() %>">
    
    <h1>Atualizar animais</h1>
    
    <label>Nome</label>
    <input type="text" name="nome" value="<%= animal.getNome() %>">

    <label>Espécie</label>
    <input type="text" name="especie" value="<%= animal.getEspecie() %>">

    <label>Raça</label>
    <input type="text" name="raca" value="<%= animal.getRaca() %>">

    <label>Descrição</label>
    <input type="text" name="descricao" value="<%= animal.getDescricao() %>">
    
    <div class="checkbox-group"> <span>Disponível para adoção?</span>
        <input type="checkbox" name="disponivel" value="true" <%= (animal.getDisponivel() ? "checked" : "") %> />
    </div>
     
    <button type="submit">Salvar Alterações</button>
    <button type="button" onclick="window.location.href='index.jsp'">Voltar início</button>
</form>
</body>

</body>
</html>

