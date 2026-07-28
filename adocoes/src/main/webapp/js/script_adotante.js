// Aguarda o DOM ser completamente carregado antes de executar o script
document.addEventListener('DOMContentLoaded', function() {

    // Adiciona evento de clique a todos os botões de atualização
    const botoesAtualizar = document.querySelectorAll('.btn-atualizar');
    botoesAtualizar.forEach(btn => {
        btn.addEventListener('click', function() {
            const adotanteId = this.getAttribute('data-id');
            
            window.location.href = `router?controller=Adotantes&acao=view_atualizar&id=${adotanteId}`;
        });
    });

    // Adiciona evento de clique a todos os botões de exclusão
    const botoesExcluir = document.querySelectorAll('.btn-excluir');
    botoesExcluir.forEach(btn => {
        btn.addEventListener('click', function() {
            const adotanteId = this.getAttribute('data-id');
            if (confirm("Tem certeza que deseja excluir este adotante?")) {
                
                window.location.href = `router?controller=Adotantes&acao=excluir&id=${adotanteId}`;
            }
        });
    });
});