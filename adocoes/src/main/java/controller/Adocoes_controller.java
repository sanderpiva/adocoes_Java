package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Adocao;
import model.Adocoes_model;
import model.Adotante;
import model.Adotantes_model;
import model.Animais_model;
import model.Animal;

public class Adocoes_controller {
	
	public void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		List<Adotante> listaAdotantes = Adotantes_model.getLista();
        List<Animal> listaAnimais = Animais_model.getAnimaisDisponiveis();

        request.setAttribute("adotantes", listaAdotantes);
        request.setAttribute("animais", listaAnimais);
        request.getRequestDispatcher("/view/cadastrar_adocoes.jsp").forward(request, response);
    }

    public void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Adocao> lista = Adocoes_model.getLista();
        request.setAttribute("adocoes", lista);
        request.getRequestDispatcher("/view/listar_adocoes.jsp").forward(request, response);
    }

    public void salvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String adotantes_id_string = request.getParameter("adotantes_id");
    	int adotantes_id = Integer.parseInt(adotantes_id_string);

    	String animais_id_string = request.getParameter("animais_id");
    	int animais_id = Integer.parseInt(animais_id_string);        
        
        String date_adocao_string = request.getParameter("data");

        // Define o formato esperado da data
        // O formato padrão do <input type="date"> no HTML é "yyyy-MM-dd"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date_adocao = null;
        try {
            // Converte a String para um objeto LocalDate
            date_adocao = LocalDate.parse(date_adocao_string, formatter);
        } catch (DateTimeParseException e) {
            
        	e.printStackTrace();
            
        	return; 
        }

        // Se a conversão foi bem-sucedida, você pode criar o objeto Adocao
        Adocao adocao = new Adocao(adotantes_id, animais_id, date_adocao);
        Adocoes_model.adicionar(adocao);
        
        Animais_model.marcarComoIndisponivel(animais_id);
        
        response.sendRedirect("index.jsp?controller=Adocoes&acao=listar");
    }

	public void desfazer_adocao(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		List<Adocao> lista = Adocoes_model.getLista();
        request.setAttribute("adocoes", lista);
		request.getRequestDispatcher("/view/desfazer_adocoes.jsp").forward(request, response);
	}
	
	public void cancelar_adocao(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {

	    String idString = request.getParameter("adocoes_id");
	    System.out.println("DEBUG: Recebi do formulário o ID: " + idString);

	    if (idString != null && !idString.isEmpty()) {
	        try {
	            int id = Integer.parseInt(idString);
	            Adocoes_model adModel = new Adocoes_model();

	            // Verificando se o model encontra o animal
	            int idAnimal = adModel.buscarIdAnimalPorAdocao(id);
	            System.out.println("DEBUG: ID do animal vinculado à adoção: " + idAnimal);

	            if (idAnimal != -1) {
	                boolean excluiu = adModel.excluir(id);
	                System.out.println("DEBUG: A exclusão no banco retornou: " + excluiu);

	                if (excluiu) {
	                    Animais_model.marcarComoDisponivel(idAnimal);
	                    response.sendRedirect("router?controller=Adocoes&acao=listar");
	                }
	            } else {
	                System.out.println("DEBUG: Falha ao encontrar o animal. Verifique se o ID " + id + " existe na coluna adocoes_id");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}  
}
