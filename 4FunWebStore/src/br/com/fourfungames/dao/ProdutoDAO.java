package br.com.fourfungames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fourfungames.dao.connection.ConnectionDAO;
import br.com.fourfungames.model.Produto;

public class ProdutoDAO {
	
	public static ProdutoDAO instance;
	public static final String SELECT_ALL_PRODUTOS = "SELECT * FROM PRODUTO";
	public static final String SELECT_PRODUTO_BY_ID = "SELECT * FROM PRODUTO WHERE ID=?";
	public static final String INSERT_PRODUTO = "INSERT INTO PRODUTO(nome,caminhoImagem,valor) VALUES (?,?,?)";
	public static final String DELETE_PRODUTO_BY_ID = "DELETE FROM PRODUTO WHERE ID=?";
	public static final String UPDATE_PRODUTO_BY_ID = "UPDATE PRODUTO SET nome=?,valor=? WHERE id=?";
	
	private Connection conn;
	private ProdutoDAO(){}
	
	public static ProdutoDAO getInstance(){
		if(instance == null){
			instance = new ProdutoDAO();
		}
		return instance;
	}
	
	public ArrayList<Produto> list() {
		if(this.conn == null){
			this.conn = ConnectionDAO.getInstance().getConnection();
		}
		
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(SELECT_ALL_PRODUTOS);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()){
				String nome = result.getString("nome");
				int id = result.getInt("id");
				String caminhoImagem = result.getString("caminhoImagem");
				double valor = result.getDouble("valor");
				listaProdutos.add(new Produto(id,nome,caminhoImagem,valor));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaProdutos;
	}

	public Produto listById(int id){
		if(this.conn == null){
			this.conn = ConnectionDAO.getInstance().getConnection();
		}
		
		Produto produto = null;
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(SELECT_PRODUTO_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()){
				String nome = result.getString("nome");
				String caminhoImagem = result.getString("caminhoImagem");
				double valor = result.getDouble("valor");
				produto = new Produto(id,nome,caminhoImagem,valor);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}


	public void add(Produto produto) {
		if(this.conn == null){
			this.conn = ConnectionDAO.getInstance().getConnection();
		}
		
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(INSERT_PRODUTO);
			preparedStatement.setString(1, produto.getName());
			preparedStatement.setString(2, produto.getCaminhoImagem());
			preparedStatement.setDouble(3, produto.getValor());
			
			preparedStatement.execute();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void remove(int id) {
		if(this.conn == null){
			this.conn = ConnectionDAO.getInstance().getConnection();
		}
		
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(DELETE_PRODUTO_BY_ID);
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void update(Produto produto) {
		if(this.conn == null){
			this.conn = ConnectionDAO.getInstance().getConnection();
		}
		
		try {
			PreparedStatement preparedStatement = this.conn.prepareStatement(UPDATE_PRODUTO_BY_ID);
			preparedStatement.setString(1,produto.getName());
			preparedStatement.setDouble(2,produto.getValor());
			preparedStatement.setInt(3,produto.getId());
			
			preparedStatement.execute();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
}
