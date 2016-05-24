package br.com.fourfungames.dao;

import java.util.ArrayList;

import br.com.fourfungames.model.Usuario;

public class UsuarioDAO {
	public static UsuarioDAO instance;
	public ArrayList<Usuario> usuarios;
	private UsuarioDAO(){}
	
	public static UsuarioDAO getInstance(){
		if(instance == null){
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public Usuario login(String login, String senha) {
		Usuario usuario = null;
		if(this.usuarios != null){
			for(Usuario usuarioTemp : this.usuarios){
				if(usuarioTemp.getLogin().equals(login) && usuarioTemp.getSenha().equals(senha)){
					usuario = usuarioTemp;
				}
			}	
		}else{
			this.usuarios = gerarUsuarios();
			login(login,senha);
		}
		return usuario;
	}

	public void add(Usuario usuario) {
		if(this.usuarios != null){
			this.usuarios.add(usuario);
		}else{
			this.usuarios = gerarUsuarios();
			this.usuarios.add(usuario);
		}
		
	}

	private ArrayList<Usuario> gerarUsuarios() {
		Usuario usuario = new Usuario("LeandroMacedo","MinhaSenha26","Leandro","leandro.malicheski@gmail.com","Masculino");
		usuario.setPerfil("adm");
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		return usuarios;
	}
	
	
}
