package br.com.fourfungames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fourfungames.dao.connection.ConnectionDAO;
import br.com.fourfungames.model.Produto;
import br.com.fourfungames.model.Usuario;

public class UsuarioDAO {
	public static UsuarioDAO instance;
	public static final String SELECT_ALL_USUARIO = "SELECT * FROM USUARIO";
	public static final String SELECT_USUARIO_BY_ID = "SELECT * FROM USUARIO WHERE ID=?";
	public static final String INSERT_PRODUTO = "INSERT INTO PRODUTO(nome,caminhoImagem,valor) VALUES (?,?,?)";
	public static final String DELETE_PRODUTO_BY_ID = "DELETE FROM PRODUTO WHERE ID=?";
	public static final String UPDATE_PRODUTO_BY_ID = "UPDATE PRODUTO SET nome=?,valor=? WHERE id=?";
	
	private Connection conn;
	private UsuarioDAO(){}
	
	public static UsuarioDAO getInstance(){
		if(instance == null){
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public Usuario login(String loginP, String senhaP) {
		if(this.conn == null){
			this.conn = ConnectionDAO.getInstance().getConnection();
		}
		
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario usuario = null;
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(SELECT_ALL_USUARIO);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()){
				int id = result.getInt("id");
				String nome = result.getString("nome");
				String login = result.getString("login");
				String perfil = result.getString("perfil");
				String email = result.getString("email");
				String senha = result.getString("senha");
				String sexo = result.getString("sexo");
				
				listaUsuarios.add(new Usuario(id,nome,login,perfil,email,senha,sexo));				
			}
			
			for(Usuario usuarioTemp : listaUsuarios){
				if(usuarioTemp.getLogin().equals(loginP) && usuarioTemp.getSenha().equals(senhaP)){
					usuario = usuarioTemp;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
