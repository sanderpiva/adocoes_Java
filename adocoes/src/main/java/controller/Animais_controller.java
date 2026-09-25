package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Animal;
import model.Animais_model;

import java.io.IOException;
import java.sql.SQLException;
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
    
 
    public void salvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParam = request.getParameter("id");
        
        String nome = request.getParameter("nome");
        String especie = request.getParameter("especie");
        String raca = request.getParameter("raca");
        String descricao = request.getParameter("descricao");
        Boolean disponivel = (request.getParameter("disponivel") != null);
        
            
        Animal novoAnimal = new Animal(nome, especie, raca, descricao, disponivel);
        Animais_model.adicionar(novoAnimal);
        response.sendRedirect("router?controller=Animais&acao=listar");
    }
    
    public void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idParam = request.getParameter("id");
        
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int idAnimal = Integer.parseInt(idParam);
                
                Animais_model animal = new Animais_model();
                animal.excluir(idAnimal); 
                
                response.sendRedirect("router?controller=Animais&acao=view_listar");
                
            } catch (NumberFormatException e) {
                
            	String flag1 = "ID inválido";
            	
            	request.setAttribute("flagErro", flag1);
	            
	        	request.getRequestDispatcher("/view/erro.jsp").forward(request, response);
                
            } catch (SQLException e) {
                
            	String mensagemErro = e.getMessage().toLowerCase();
                
                String flag2 = "generico";
                if (mensagemErro.contains("foreign key") || mensagemErro.contains("constraint") || mensagemErro.contains("violates")) {
                    flag2 = "vinculo";
                }
                
                request.setAttribute("flagErro", flag2);
                
                request.getRequestDispatcher("/view/erro.jsp").forward(request, response);
            }
        } else {
        	
        	String flag3 = "ID não fornecido";
        	
            request.setAttribute("flagErro", flag3);
            
        	request.getRequestDispatcher("/view/erro.jsp").forward(request, response);
        }
    }

    
    public void view_atualizar(HttpServletRequest request, HttpServletResponse response)
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
    
    
    public void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
                
        String nome = request.getParameter("nome");
        String especie = request.getParameter("especie");
        String raca = request.getParameter("raca");
        String descricao = request.getParameter("descricao");
        Boolean disponivel = (request.getParameter("disponivel") != null);
        
        if (idParam != null && !idParam.isEmpty()) {
        	try {
                int idAnimal = Integer.parseInt(idParam);
                Animal animalAtualizado = new Animal(idAnimal, nome, especie, raca, descricao, disponivel);
                Animais_model animalModel = new Animais_model();
                if (animalModel.atualizarAnimal(animalAtualizado)) {
                    response.sendRedirect("router?controller=Animais&acao=view_listar");
                } else {
                    // Tratar erro de atualização
                }
            } catch (NumberFormatException e) {
                // Tratar erro de ID
            }
        
        } else {
            // Tratar erro: ID não fornecido
        	 request.setAttribute("mensagem", "ID do animal não fornecido.");
             request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
 }
