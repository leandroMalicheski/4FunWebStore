package br.com.fourfungames.dao;

import br.com.fourfungames.model.Usuario;

public class UsuarioDAO {

	public Usuario login(String login, String senha) {
		Usuario usuario = null;
		
		if(login.equals("LeandroMacedo") && senha.equals("MinhaSenha26")){
			usuario = new Usuario();
			usuario.setPerfil("adm");
			usuario.setNome("Leandro");
			usuario.setLogin("LeandroMacedo");
			usuario.setSenha("MinhaSenha26");
			usuario.setEmail("leandro.malicheski@gmail.com");
		}
		
		return usuario;
	}

}
