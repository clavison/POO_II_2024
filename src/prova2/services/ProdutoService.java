package prova2.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import prova2.conexao.Conexao;
import prova2.model.Produto;

public class ProdutoService {

	public int insereProduto(Produto p) {
		Connection conn = Conexao.conectaMySql();
		try {
			String sql = "insert into produto (id, nome, valor, estoque) " + "values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNome());
			ps.setDouble(3, p.getValor());
			ps.setInt(4, p.getEstoque());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			Conexao.fechaConexao(conn);
		}
	}

	public int atualizaEstoque(Produto p, int estoque) {
		Connection conn = Conexao.conectaMySql();
		try {
			String sql = "update produto set estoque = ? where id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, estoque);
			ps.setInt(2, p.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			Conexao.fechaConexao(conn);
		}
	}

	public int limpaTblProduto() {
		Connection conn = Conexao.conectaMySql();
		try {
			String sql = "delete from produto where id > 0";
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			Conexao.fechaConexao(conn);
		}

	}

	public Produto findById(int id) {
		Connection conn = Conexao.conectaMySql();
		String sql = "select * from produto where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getDouble("valor"),
						rs.getInt("estoque"));
				return p;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			Conexao.fechaConexao(conn);
		}
	}

	public ArrayList<Produto> listAll() {
		ArrayList<Produto> lista = new ArrayList<Produto>();
		Connection conn = Conexao.conectaMySql();
		String sql = "select * from produto";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produto p = new Produto(
						rs.getInt("id"), 
						rs.getString("nome"), rs.getDouble("valor"),
						rs.getInt("estoque")
				);
				lista.add(p);
			}
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			Conexao.fechaConexao(conn);
		}
	}

}
