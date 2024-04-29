package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import banco_de_dados.model.Cliente;

public class ClienteService {
	
	public static int insereCliente(Cliente c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "insert into cliente (nome,idade,sexo,cidade) values(?,?,?,?)";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, c.getNome());
			pr.setInt(2, c.getIdade());
			pr.setString(3, c.getSexo());
			pr.setInt(4, c.getCidade().getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int alteraCliente(Cliente c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "update cliente set nome=?, idade=?, sexo=?, cidade=? where id=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, c.getNome());
			pr.setInt(2, c.getIdade());
			pr.setString(3, c.getSexo());
			pr.setInt(4, c.getCidade().getId());
			pr.setInt(5, c.getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int excluiCliente(Cliente c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "delete from cliente where id=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setInt(1, c.getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public static int limpaTblCliente() {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "delete from cliente where id > 0";
			PreparedStatement pr = conn.prepareStatement(sql);
			int total = pr.executeUpdate();
			
			sql = "ALTER TABLE cliente AUTO_INCREMENT = 0";
			pr = conn.prepareStatement(sql);
			pr.executeUpdate();
			
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<Cliente> listAll(){
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			String sql = "select * from cliente";
			Connection conn = Conexao.conectaMySql();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setSexo(rs.getString("sexo"));
				c.setIdade(rs.getInt("idade"));
				c.setCidade(CidadeService.findById(rs.getInt("cidade")));
				lista.add(c);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
