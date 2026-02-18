package model;

public class Adotante {
	
	private String nome;
	private String telefone;
	private String email;
	private int id;
	//cadastro
	public Adotante(String nome, String telefone, String email) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	//listagem
	
	 // Construtor completo com o ID (usado na listagem)
    public Adotante(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// Método para obter o ID
    public int getId() {
        return id;
    }
	
}
