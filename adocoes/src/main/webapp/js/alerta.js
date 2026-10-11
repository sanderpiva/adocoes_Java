// /js/alerta.js
function tratarErro(flag) {
    let mensagem = "Ocorreu um erro inesperado no sistema.";

    if (flag === "vinculo") {
        mensagem = "Registro com vínculo estabelecido.";
    } else if (flag === "generico") {
        mensagem = "Erro no banco de dados ao tentar excluir.";
    } else if (flag === "ID inválido") {
        mensagem = "ID inválido.";
    } else if (flag === "ID não fornecido") {
        mensagem = "ID não fornecido.";
    }
    

    alert(mensagem);
    
    window.location.href = "index.jsp"; 
}
