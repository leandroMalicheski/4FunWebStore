package br.com.fourfungames.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	private static ConnectionDAO instance;
	private static final String URL = "jdbc:hsqldb:file:C:\\Users\\LocalAdm\\git\\4FunWebStore\\4FunWebStore\\WebContent\\database\\webStore";
	private Connection conn;
	private ConnectionDAO(){}
	
	public static ConnectionDAO getInstance(){
		if(instance == null){
			instance = new ConnectionDAO();
		}
		return instance;
	}
	
	public Connection getConnection(){
		if(this.conn == null){
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				this.conn = DriverManager.getConnection(URL, "SA", "");
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return this.conn;
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionDAO.getInstance().getConnection();
		if(conn!= null){
			System.out.println("YO BITCHES IM CONNECTED");
		}
	}
}
