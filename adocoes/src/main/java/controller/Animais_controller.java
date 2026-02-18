package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Animal;
import model.Animais_model;

import java.io.IOException;
import java.util.List;

public class Animais_controller {

    public void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/cadastrar_animais.jsp").forward(request, response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Animal> lista = Animais_model.getLista();
        request.setAttribute("animais", lista);
        request.getRequestDispatcher("/view/listar_animais.jsp").forward(request, response);
    }
    
 // O método salvar pode lidar com cadastro e atualização
    public void salvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Tenta obter o ID. Se não existir, idParam será null.
        String idParam = request.getParameter("id");
        
        // ... (obtém os demais parâmetros) ...
        String nome = request.getParameter("nome");
        String especie = request.getParameter("especie");
        String raca = request.getParameter("raca");
        String descricao = request.getParameter("descricao");
        Boolean disponivel = (request.getParameter("disponivel") != null);
        
        if (idParam != null && !idParam.isEmpty()) {
            // Lógica de ATUALIZAÇÃO
            try {
                int idAnimal = Integer.parseInt(idParam);
                Animal animalAtualizado = new Animal(idAnimal, nome, especie, raca, descricao, disponivel);
                Animais_model animalModel = new Animais_model();
                if (animalModel.atualizarAnimal(animalAtualizado)) {
                    response.sendRedirect("router?controller=Animais&acao=listar");
                } else {
                    // Tratar erro de atualização
                }
            } catch (NumberFormatException e) {
                // Tratar erro de ID
            }
        } else {
            // Lógica de CADASTRO (o seu código original)
            Animal novoAnimal = new Animal(nome, especie, raca, descricao, disponivel);
            Animais_model.adicionar(novoAnimal);
            response.sendRedirect("router?controller=Animais&acao=listar");
        }
    }
    
    public void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	// 1. Obter o parâmetro 'id' da requisição
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                // 2. Converter o ID para um tipo numérico (int)
                int idAnimal = Integer.parseInt(idParam);
                
                // 3. Chamar o Model (AnimalDAO) para excluir o animal
                Animais_model animal = new Animais_model();
                boolean excluidoComSucesso = animal.excluir(idAnimal);
                
                if (excluidoComSucesso) {
                    // 4. Redirecionar para a página de listagem após a exclusão
                	response.sendRedirect("router?controller=Animais&acao=listar");
                } else {
                    // Tratar o caso em que a exclusão falhou
                    request.setAttribute("mensagem", "Erro ao excluir o animal.");
                    request.getRequestDispatcher("/erro.jsp").forward(request, response);
                }
                
            } catch (NumberFormatException e) {
                // Tratar o caso em que o ID não é um número válido
                request.setAttribute("mensagem", "ID de animal inválido.");
                request.getRequestDispatcher("/erro.jsp").forward(request, response);
            }
        } else {
            // Tratar o caso em que o ID não foi fornecido
            request.setAttribute("mensagem", "ID de animal não fornecido.");
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }

    
 // NOVO método para carregar os dados do animal
    public void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int idAnimal = Integer.parseInt(idParam);
                Animais_model animalModel = new Animais_model();
                Animal animalParaAtualizar = animalModel.getAnimalById(idAnimal);

                if (animalParaAtualizar != null) {
                    request.setAttribute("animalParaAtualizar", animalParaAtualizar);
                    request.getRequestDispatcher("/view/atualizar_animais.jsp").forward(request, response);
                } else {
                    // Tratar erro: animal não encontrado
                	 request.setAttribute("mensagem", "Animal não encontrado.");
                     request.getRequestDispatcher("/erro.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                // Tratar erro: ID inválido
            	 request.setAttribute("mensagem", "ID do animal inválido.");
                 request.getRequestDispatcher("/erro.jsp").forward(request, response);
            }
        } else {
            // Tratar erro: ID não fornecido
        	 request.setAttribute("mensagem", "ID do animal não fornecido.");
             request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
    
 }
