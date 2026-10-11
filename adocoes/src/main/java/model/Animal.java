package model;

public class Animal {
    private String nome;
    private String especie;
    private String raca;
    private String descricao;
    private Boolean disponivel;
    private int id;
    
    //listagem
    public Animal(int id, String nome, String especie, String raca, String descricao, Boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.descricao = descricao;
        this.disponivel = disponivel;
    }

    //cadastro
    public Animal(String nome, String especie, String raca, String descricao, Boolean disponivel) {
    	
    	if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do animal não pode ser vazio.");
        }
        
        if (especie == null || especie.trim().isEmpty()) {
            throw new IllegalArgumentException("A espécie do animal não pode ser vazia.");
        }
        
        if (raca == null || raca.trim().isEmpty()) {
            throw new IllegalArgumentException("A raça do animal não pode ser vazia.");
        }
        
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do animal não pode ser vazia.");
        }

        this.nome = nome.trim();
        this.especie = especie.trim();
        this.raca = raca.trim();
        this.descricao = descricao.trim(); 
        this.disponivel = (disponivel != null) ? disponivel : false;
    }

    public String getNome() {
        return nome;
    }

    
	public String getEspecie() {
		// TODO Auto-generated method stub
		return especie;
	}

	public String getRaca() {
		// TODO Auto-generated method stub
		return raca;
	}

	public String getDescricao() {
		// TODO Auto-generated method stub
		return descricao;
	}

	public Boolean getDisponivel() {
		// TODO Auto-generated method stub
		return disponivel;
	}
	
	// Método para obter o ID
    public int getId() {
        return id;
    }
    
}
