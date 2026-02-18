package model;

import java.sql.Date;
import java.time.LocalDate;

public class Adocao {
	
	private int adotantes_id;
	private int animais_id;
	private LocalDate date_adocao;
	private int adocao_id;
	private String nomeAdotante;
	private String nomeAnimal;
	private String telefoneAdotante;
	private String emailAdotante;
	
	//cadastro
	public Adocao(int adotantes_id, int animais_id, LocalDate date_adocao) {
		// TODO Auto-generated constructor stub
		this.adotantes_id = adotantes_id;
		this.animais_id = animais_id;
		this.date_adocao = date_adocao;
	}
	
	//listagem
	public Adocao(int id, int adotantes_id, String nomeAdotante, String telefoneAdotante, String emailAdotante, int animais_id, String nomeAnimal, LocalDate date_adocao) {
		// TODO Auto-generated constructor stub
		
		adocao_id = id;
		this.adotantes_id = adotantes_id;
		this.animais_id = animais_id;
		this.date_adocao = date_adocao;
		this.nomeAdotante = nomeAdotante;
		this.telefoneAdotante = telefoneAdotante;
		this.emailAdotante = emailAdotante;
		this.nomeAnimal = nomeAnimal;
		
	}
	
	public int getAdotantes_id() {
		return adotantes_id;
	}
	public void setAdotantes_id(int adotantes_id) {
		this.adotantes_id = adotantes_id;
	}
	public int getAnimais_id() {
		return animais_id;
	}
	public void setAnimais_id(int animais_id) {
		this.animais_id = animais_id;
	}
	public LocalDate getDate_adocao() {
		return date_adocao;
	}
	public void setDate_adocao(LocalDate date_adocao) {
		this.date_adocao = date_adocao;
	}
	
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	
	public String getNomeAdotante() {
		return nomeAdotante;
	}

	public String getTelefoneAdotante() {
		return telefoneAdotante;
	}

	public void setTelefoneAdotante(String telefoneAdotante) {
		this.telefoneAdotante = telefoneAdotante;
	}

	public String getEmailAdotante() {
		return emailAdotante;
	}

	public void setEmailAdotante(String emailAdotante) {
		this.emailAdotante = emailAdotante;
	}

	public int getAdocao_id() {
		return adocao_id;
	}

	public void setAdocao_id(int adocao_id) {
		this.adocao_id = adocao_id;
	}
	
}
