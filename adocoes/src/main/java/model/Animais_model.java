package model;

import config.Conecta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Animais_model {

    public static void adicionar(Animal animal) {
        String sql = "INSERT INTO animais (nome, especie, raca, descricao, disponivel) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setString(4, animal.getDescricao());
            stmt.setBoolean(5, animal.getDisponivel());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Animal> getLista() {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animais";

        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String especie = rs.getString("especie");
                String raca = rs.getString("raca");
                String descricao = rs.getString("descricao");
                Boolean disponivel = rs.getBoolean("disponivel");
                
                lista.add(new Animal(id, nome, especie, raca, descricao, disponivel));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public static List<Animal> getAnimaisDisponiveis() {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animais WHERE disponivel = true";

        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String especie = rs.getString("especie");
                String raca = rs.getString("raca");
                String descricao = rs.getString("descricao");
                Boolean disponivel = rs.getBoolean("disponivel");
                
                lista.add(new Animal(id, nome, especie, raca, descricao, disponivel));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean excluir(int idAnimal) {
        String sql = "DELETE FROM animais WHERE id = ?";
        
        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idAnimal);
            int linhasAfetadas = stmt.executeUpdate();
            
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // NOVO MÉTODO: Refatorado para usar try-with-resources
    public Animal getAnimalById(int id) {
        String sql = "SELECT id, nome, especie, raca, descricao, disponivel FROM animais WHERE id = ?";
        Animal animal = null;

        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            
            // O ResultSet também é gerenciado por try-with-resources
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int animalId = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String especie = rs.getString("especie");
                    String raca = rs.getString("raca");
                    String descricao = rs.getString("descricao");
                    boolean disponivel = rs.getBoolean("disponivel");
                    
                    animal = new Animal(animalId, nome, especie, raca, descricao, disponivel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animal;
    }

    // NOVO MÉTODO: Refatorado para usar try-with-resources
    public boolean atualizarAnimal(Animal animal) {
        String sql = "UPDATE animais SET nome = ?, especie = ?, raca = ?, descricao = ?, disponivel = ? WHERE id = ?";
        
        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setString(4, animal.getDescricao());
            stmt.setBoolean(5, animal.getDisponivel());
            stmt.setInt(6, animal.getId());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

	public static void marcarComoIndisponivel(int id_animal) {
		// TODO Auto-generated method stub
		// SQL para atualizar a coluna 'disponivel' para false
        String sql = "UPDATE animais SET disponivel = false WHERE id = ?";

        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_animal);

            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Animal com ID " + id_animal + " foi marcado como indisponível.");
            } else {
                System.out.println("Nenhum animal encontrado com o ID " + id_animal + " para ser atualizado.");
            }

        } catch (SQLException e) {
            // Lidar com exceções de banco de dados
            System.err.println("Erro ao marcar animal como indisponível: " + e.getMessage());
            e.printStackTrace();
        }
    
	}


	public static void marcarComoDisponivel(int id_animal) {
		// TODO Auto-generated method stub
		// SQL para atualizar a coluna 'disponivel' para false
        String sql = "UPDATE animais SET disponivel = true WHERE id = ?";

        try (Connection conn = Conecta.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_animal);

            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Animal com ID " + id_animal + " foi marcado como disponível.");
            } else {
                System.out.println("Nenhum animal encontrado com o ID " + id_animal + " para ser atualizado.");
            }

        } catch (SQLException e) {
            // Lidar com exceções de banco de dados
            System.err.println("Erro ao marcar animal como disponível: " + e.getMessage());
            e.printStackTrace();
        }
    
	}

}	



