package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Adotante;
import model.Adotantes_model;
import model.Animais_model;
import model.Animal;

public class Adotantes_controller {

	public void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/cadastrar_adotantes.jsp").forward(request, response);
	}

	public void listar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Adotante> lista = Adotantes_model.getLista();
		request.setAttribute("adotantes", lista);
		request.getRequestDispatcher("/view/listar_adotantes.jsp").forward(request, response);
	}

	public void salvar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("id");

		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");

				
		Adotante novoAdotante = new Adotante(nome, telefone, email);
		Adotantes_model.adicionar(novoAdotante);
		response.sendRedirect("router?controller=Adotantes&acao=listar");
	}

	public void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("id");

		if (idParam != null && !idParam.isEmpty()) {
			try {
				int idAdotante = Integer.parseInt(idParam);

				Adotantes_model adotante = new Adotantes_model();
				boolean excluidoComSucesso = adotante.excluir(idAdotante);

				if (excluidoComSucesso) {
		
					response.sendRedirect("router?controller=Adotantes&acao=listar");
				} else {
					
					request.setAttribute("mensagem", "Erro ao excluir o adotante.");
					request.getRequestDispatcher("/erro.jsp").forward(request, response);
				}

			} catch (NumberFormatException e) {
				
				request.setAttribute("mensagem", "ID de adotante inválido.");
				request.getRequestDispatcher("/erro.jsp").forward(request, response);
			}
		} else {
			
			request.setAttribute("mensagem", "ID de adotante não fornecido.");
			request.getRequestDispatcher("/erro.jsp").forward(request, response);
		}
	}

	public void view_atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idParam = request.getParameter("id");
		
		if (idParam != null && !idParam.isEmpty()) {
			
			try {
				int idAdotante = Integer.parseInt(idParam);
				Adotantes_model adotanteModel = new Adotantes_model();
				Adotante adotanteParaAtualizar = adotanteModel.getAdotanteById(idAdotante);

				if (adotanteParaAtualizar != null) {
					request.setAttribute("adotanteParaAtualizar", adotanteParaAtualizar);
					request.getRequestDispatcher("/view/atualizar_adotantes.jsp").forward(request, response);
				} else {
					
					request.setAttribute("mensagem", "Adotante não encontrado.");
					request.getRequestDispatcher("/erro.jsp").forward(request, response);
					
				}
			} catch (NumberFormatException e) {
				
				request.setAttribute("mensagem", "ID do adotante inválido.");
				request.getRequestDispatcher("/erro.jsp").forward(request, response);
				
			}
			
						
			
		} else {
			
			request.setAttribute("mensagem", "ID do adotante não fornecido.");
			
		}
	}
	
	public void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idParam = request.getParameter("id");
		

		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		if (idParam != null && !idParam.isEmpty()) {

			try {
				int idAdotante = Integer.parseInt(idParam);
				Adotante adotanteAtualizado = new Adotante(idAdotante, nome, telefone, email);
				Adotantes_model adotanteModel = new Adotantes_model();
				if (adotanteModel.atualizarAdotante(adotanteAtualizado)) {
					response.sendRedirect("router?controller=Adotantes&acao=listar");
				} else {
					// Tratar erro de atualização
					request.setAttribute("mensagem", "Adotante não encontrado.");

				}
			} catch (NumberFormatException e) {
				// Tratar erro de ID
				request.setAttribute("mensagem", "ID do adotante inválido.");			
			}
		} 
		
		else {
			
			request.setAttribute("mensagem", "ID do adotante não fornecido.");
			
		}
	}
}
