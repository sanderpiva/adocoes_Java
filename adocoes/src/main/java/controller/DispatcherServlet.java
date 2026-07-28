package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/router")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String controller = request.getParameter("controller");
		String acao = request.getParameter("acao");

		if (controller == null || acao == null) {
			response.sendRedirect("index.jsp");
			return;
		}

		switch (controller) {
		case "Animais":
			Animais_controller animaisCtrl = new Animais_controller();
			
			//carrega interfaces/views
			if (acao.equals("cadastrar")) {
				animaisCtrl.cadastrar(request, response);
			}

			else if (acao.equals("listar")) {
				animaisCtrl.listar(request, response);
			}

			else if (acao.equals("atualizar")) {
				animaisCtrl.view_atualizar(request, response);
			}
			
			else if (acao.equals("excluir")) {
				animaisCtrl.excluir(request, response); 
			} 	

			else {
				response.sendRedirect("index.jsp"); 
			}
			break;

		case "Adotantes":
			Adotantes_controller adotantesCtrl = new Adotantes_controller();
			
			if (acao.equals("cadastrar")) {
				adotantesCtrl.cadastrar(request, response);

			} else if (acao.equals("listar")) {
				adotantesCtrl.listar(request, response);

			} else if (acao.equals("view_atualizar")) {
				adotantesCtrl.view_atualizar(request, response);

			} else if (acao.equals("excluir")) {
				adotantesCtrl.excluir(request, response); 

			} else {
				response.sendRedirect("index.jsp"); 
			}
			break;

		case "Adocoes":
			Adocoes_controller adocoesCtrl = new Adocoes_controller();
			if (acao.equals("cadastrar")) {
				adocoesCtrl.cadastrar(request, response);

			} else if (acao.equals("listar")) {
				adocoesCtrl.listar(request, response);

			} else if (acao.equals("desfazer_adocao")) {
				adocoesCtrl.desfazer_adocao(request, response);

			} else {
				response.sendRedirect("index.jsp"); 
			}
			break;


		default:
			response.sendRedirect("index.jsp");
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String controller = request.getParameter("controller");
		String acao = request.getParameter("acao");

		if (controller == null || acao == null) {
			response.sendRedirect("index.jsp");
			return;
		}

		switch (controller) {
		case "Animais":
			Animais_controller animaisCtrl = new Animais_controller();

			if (acao.equals("salvar")) {
				animaisCtrl.salvar(request, response);
			}

			else if (acao.equals("atualizar")) {
				animaisCtrl.atualizar(request, response);
			}
			
			else {
				response.sendRedirect("index.jsp"); 
			}

			break;

		case "Adotantes":
			Adotantes_controller adotantesCtrl = new Adotantes_controller();
			if (acao.equals("salvar")) {
				adotantesCtrl.salvar(request, response);
			} 

			else if (acao.equals("atualizar")) {
				adotantesCtrl.atualizar(request, response);
			}

			else {
				response.sendRedirect("index.jsp"); 
			}
			break;

		case "Adocoes":
			Adocoes_controller adocoesCtrl = new Adocoes_controller();
			if (acao.equals("salvar")) {
				adocoesCtrl.salvar(request, response);
			}
			else if (acao.equals("cancelar_adocao")) { 
				adocoesCtrl.cancelar_adocao(request, response);
			} else {
				response.sendRedirect("index.jsp"); 
			}
			break;

		default:
			response.sendRedirect("index.jsp");
		}
	}
}
