<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Processando Aviso...</title>
    <!-- Importa o arquivo JS externo -->
    <script src="${pageContext.request.contextPath}/js/alerta.js"></script>
</head>
<body>
    <script>
        const flagRecebida = "${flagErro}";
        
        tratarErro(flagRecebida);
    </script>
</body>
</html>