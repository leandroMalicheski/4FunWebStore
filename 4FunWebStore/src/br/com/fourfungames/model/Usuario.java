package br.com.fourfungames.model;
	
public class Usuario	{
	String login;
	String senha;
	String perfil;
	String nome;
	String email;
	String sexo;
	
	public Usuario(String login, String senha, String nome, String email, String sexo){
		this.login = login;
		this.senha = senha;
		this.perfil = "default"; 
		this.nome = nome;
		this.email= email;
		this.sexo = sexo;
	}
	
	public Usuario(){}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) { 
		this.login = login; 
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) { 
		this.senha = senha; 
	}
	
	public String getPerfil() {
		return this.perfil;
	}
	
	public void setPerfil(String perfil) { 
		this.perfil = perfil;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) { 
		this.nome = nome; 
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email; 
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	public void setSexo(String sexo) { 
		this.sexo = sexo; 
	}
}