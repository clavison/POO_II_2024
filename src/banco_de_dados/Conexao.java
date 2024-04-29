package banco_de_dados;

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

}
