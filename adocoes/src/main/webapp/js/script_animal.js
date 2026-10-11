// Aguarda o DOM ser completamente carregado antes de executar o script
document.addEventListener('DOMContentLoaded', function() {

    // Adiciona evento de clique a todos os botões de atualização
    const botoesAtualizar = document.querySelectorAll('.btn-atualizar');
    botoesAtualizar.forEach(btn => {
        btn.addEventListener('click', function() {
            const animalId = this.getAttribute('data-id');
            // AQUI: A URL deve chamar o DispatcherServlet (router)
            window.location.href = `router?controller=Animais&acao=view_atualizar&id=${animalId}`;
        });
    });

    // Adiciona evento de clique a todos os botões de exclusão
    const botoesExcluir = document.querySelectorAll('.btn-excluir');
    botoesExcluir.forEach(btn => {
        btn.addEventListener('click', function() {
            const animalId = this.getAttribute('data-id');
            if (confirm("Tem certeza que deseja excluir este animal?")) {
                // AQUI: A URL deve chamar o DispatcherServlet (router)
                window.location.href = `router?controller=Animais&acao=excluir&id=${animalId}`;
            }
        });
    });
});