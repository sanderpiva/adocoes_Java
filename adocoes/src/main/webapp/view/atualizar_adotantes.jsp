<%@ page import="model.Adotante" %>
<% Adotante adotante = (Adotante) request.getAttribute("adotanteParaAtualizar"); %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body class="home"> <form action="router" method="post">
        <input type="hidden" name="controller" value="Adotantes">
        <input type="hidden" name="acao" value="atualizar">
        <input type="hidden" name="id" value="<%= adotante.getId() %>">
        
        <h1>Atualizar adotantes</h1>
        
        <label>Nome</label>
        <input type="text" name="nome" value="<%= adotante.getNome() %>">
        
        <label>Telefone</label>
        <input type="text" name="telefone" value="<%= adotante.getTelefone() %>">
        
        <label>Email</label>
        <input type="text" name="email" value="<%= adotante.getEmail() %>">
        
        <button type="submit" class="botao-acao">Salvar Alterações</button>
        <button type="button" onclick="window.location.href='index.jsp'" class="voltar-link">Voltar início</button>
    </form>
</body>
</html>
