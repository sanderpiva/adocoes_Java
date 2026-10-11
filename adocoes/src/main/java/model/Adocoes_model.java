package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import config.Conecta;

public class Adocoes_model {


	public static void adicionar(Adocao adocao) {

		String sql = "INSERT INTO adocoes (adotantes_id, animais_id, data) VALUES (?, ?, ?)";

		try (Connection conn = Conecta.getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, adocao.getAdotantes_id());
			stmt.setInt(2, adocao.getAnimais_id());
			stmt.setObject(3, adocao.getDate_adocao());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Adocao> getLista() {
		List<Adocao> lista = new ArrayList<>();
		// Consulta SQL com JOIN para buscar os nomes
		String sql = "SELECT a.adocoes_id, a.adotantes_id, ad.nome AS nome_adotante, ad.telefone AS telefone_adotante, ad.email AS email_adotante, a.animais_id, an.nome AS nome_animal, a.data "
				+ "FROM adocoes a "
				+ "JOIN adotantes ad ON a.adotantes_id = ad.id "
				+ "JOIN animais an ON a.animais_id = an.id";

		try (Connection conn = Conecta.getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("adocoes_id");
				int adotantes_id = rs.getInt("adotantes_id");
				String nomeAdotante = rs.getString("nome_adotante"); // Lendo o nome do adotante
				//
				String telefoneAdotante = rs.getString("telefone_adotante");
				String emailAdotante = rs.getString("email_adotante");
				//
				int animais_id = rs.getInt("animais_id");
				String nomeAnimal = rs.getString("nome_animal"); // Lendo o nome do animal
				LocalDate date_adocao = rs.getDate("data").toLocalDate();

				// Usando o novo construtor completo
				lista.add(new Adocao(id, adotantes_id, nomeAdotante, telefoneAdotante, emailAdotante, animais_id, nomeAnimal, date_adocao));
			}
 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public boolean excluir(int idAdocao) {
	    // Ajustado para 'adocoes_id' conforme a imagem do seu banco
	    String sql = "DELETE FROM adocoes WHERE adocoes_id = ?"; 
	    
	    try (Connection conn = Conecta.getConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, idAdocao);
	        int linhasAfetadas = stmt.executeUpdate();
	        
	        return linhasAfetadas > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public int buscarIdAnimalPorAdocao(int idAdocao) {
	    // Ajustado para 'adocoes_id' conforme a imagem do seu banco
	    String sql = "SELECT animais_id FROM adocoes WHERE adocoes_id = ?"; 
	    try (Connection conn = Conecta.getConexao();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, idAdocao);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("animais_id");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return -1; 
	}

}
