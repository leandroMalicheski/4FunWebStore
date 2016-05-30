package br.com.fourfungames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fourfungames.dao.connection.ConnectionDAO;
import br.com.fourfungames.model.Usuario;

public class UsuarioDAO {
	public static UsuarioDAO instance;
	public static final String SELECT_ALL_USUARIO = "SELECT * FROM USUARIO";
	public static final String SELECT_USUARIO_BY_ID = "SELECT * FROM USUARIO WHERE ID=?";
	public static final String INSERT_USUARIO = "INSERT INTO USUARIO(nome,login,perfil,email,senha,sexo) VALUES (?,?,?,?,?,?)";
	
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
		
		if(this.conn == null){
			this.conn = ConnectionDAO.getInstance().getConnection();
		}
		
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(INSERT_USUARIO);
			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getLogin());
			preparedStatement.setString(3, usuario.getPerfil());
			preparedStatement.setString(4, usuario.getEmail());
			preparedStatement.setString(5, usuario.getSenha());
			preparedStatement.setString(6, usuario.getSexo());
			preparedStatement.execute();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
}
