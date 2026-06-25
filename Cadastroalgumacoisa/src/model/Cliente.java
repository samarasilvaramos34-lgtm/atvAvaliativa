package model;

import java.time.LocalDate;

public class Cliente {
	private String nome;
	private String email;
	private String telefone;
	private String sexo;
	private int id;
	private LocalDate dataCadastro;
	
	
	public class LocalDate{
		private LocalDate dataCadastro;
		
	}
	
	public Cliente(String nome, String telefone, String email, String sexo) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
	}
	
	public Cliente(int id, String nome, String telefone, String email, String sexo) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	

}
