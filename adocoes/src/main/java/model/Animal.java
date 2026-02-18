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
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.descricao = descricao;
        this.disponivel = disponivel;
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
