package prova2.conexao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexao {
	
	public static Connection conectaMySql() {
		Connection conn = null;
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("db.properties"));
			conn = DriverManager.getConnection(
					props.getProperty("url"), 
					props);
		}catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void fechaConexao(Connection conn) {
		try {
			if(!conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
