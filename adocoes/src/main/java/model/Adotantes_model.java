package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Conecta;

public class Adotantes_model {

	public static void adicionar(Adotante adotante) {

		String sql = "INSERT INTO adotantes (nome, telefone, email) VALUES (?, ?, ?)";

		try (Connection conn = Conecta.getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, adotante.getNome());
			stmt.setString(2, adotante.getTelefone());
			stmt.setString(3, adotante.getEmail());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Adotante> getLista() {
		List<Adotante> lista = new ArrayList<>();
		String sql = "SELECT * FROM adotantes";

		try (Connection conn = Conecta.getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id"); 
				String nome = rs.getString("nome");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");

				//lista.add(new Adotante(nome, telefone, email));
				lista.add(new Adotante(id, nome, telefone, email));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public boolean excluir(int idAdotante) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM adotantes WHERE id = ?";
		try (Connection conn = Conecta.getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setInt(1, idAdotante);
			int linhasAfetadas = stmt.executeUpdate();

			// Retorna true se pelo menos uma linha foi excluída
			return linhasAfetadas > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Adotante getAdotanteById(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM adotantes WHERE id = ?";
        Adotante adotante = null;

        // CORREÇÃO: O bloco try-catch-finally tradicional foi substituído por try-with-resources
        // para um fechamento automático e mais limpo da Connection e do PreparedStatement.
        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            // O ResultSet também é gerenciado por try-with-resources
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int adotanteId = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String telefone = rs.getString("telefone");
                    String email = rs.getString("email");
                    
                    adotante = new Adotante(adotanteId, nome, telefone, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adotante;

	}

	public boolean atualizarAdotante(Adotante adotante) {
		// TODO Auto-generated method stub

		String sql = "UPDATE adotantes SET nome = ?, telefone = ?, email = ? WHERE id = ?";

		// CORREÇÃO: O bloco try-catch-finally tradicional foi substituído por try-with-resources
		// para um fechamento automático e mais limpo da Connection e do PreparedStatement.
		try (Connection conn = Conecta.getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, adotante.getNome());
			stmt.setString(2, adotante.getTelefone());
			stmt.setString(3, adotante.getEmail());
			stmt.setInt(4, adotante.getId());

			int linhasAfetadas = stmt.executeUpdate();

			return linhasAfetadas > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
