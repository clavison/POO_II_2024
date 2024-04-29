package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import banco_de_dados.model.Cidade;

public class CidadeService {
	
	public static int insereCidade(Cidade c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "insert into cidade (nome,uf) values(?,?)";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, c.getNome());
			pr.setString(2, c.getUf());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int alteraCidade(Cidade c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "update cidade set nome=?, uf=? where id=?";
			PreparedStatement pr = conn.prepareStatement(sql);
			pr.setString(1, c.getNome());
			pr.setString(2, c.getUf());
			pr.setInt(3, c.getId());
			int total = pr.executeUpdate();
			conn.close();
			return total;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int excluiCidade(Cidade c) {
		try {
			Connection conn = Conexao.conectaMySql();
			String sql = "delete from cidade where id=?";
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
	
	public static ArrayList<Cidade> listAll(){
		ArrayList<Cidade> lista = new ArrayList<Cidade>();
		try {
			String sql = "select * from cidade";
			Connection conn = Conexao.conectaMySql();
			PreparedStatement pr = conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				Cidade c = new Cidade();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setUf(rs.getString("uf"));
				lista.add(c);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
