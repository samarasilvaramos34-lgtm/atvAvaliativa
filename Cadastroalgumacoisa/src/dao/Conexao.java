package dao;

import java.sql.SQLException;
import java.sql.DriverManager;

import com.sun.jdi.connect.spi.Connection;

public class Conexao {

private static String url = "jdbc:sqlite:clientes.db";
	
	public static Connection conectar() {
		Connection conexao = null;
		try {
			conexao = (Connection) DriverManager.getConnection(url);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conexao;				
	}

}
