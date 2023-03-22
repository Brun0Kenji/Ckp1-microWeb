package br.fiap.cp1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import br.fiap.cp1.model.connectionFactory.ConnectionFactory;
import br.fiap.cp1.model.entidade.Produto;


public class ProdutoDAO extends DAO{

	public void inserir(Produto produto) {
		ConnectionFactory conexao = new ConnectionFactory();
		connection = conexao.conectar();
		sql = "insert into PRODUTOS values(?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(2, produto.getNome());
			ps.setDouble(3, produto.getPreco());
			ps.execute();
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Produto> listar() {
		List<Produto> lista = new ArrayList<Produto>();
		ConnectionFactory conexao = new ConnectionFactory();
		connection = conexao.conectar();
		Produto produto;
		
		sql = "select id, nome, preco from PRODUTOS";

		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				double preco =rs.getDouble("preco");
				produto = new Produto(id, nome, preco);
				lista.add(produto);
			}
			ps.close();
			conexao.desconectar();
		} catch (SQLException e) {
			System.out.println("erro ao listar produtos\n " + e);
		}

		return lista;
	}

	public void removeProduto(int id) {
		String sql = "delete from PRODUTOS where id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarProduto(Produto produto) {
		String sql = "update PRODUTOS set nome=?, preco=? where id=?";

		try {
			ps = connection.prepareStatement(sql);

			ps.setString(2, produto.getNome());
			ps.setDouble(3, produto.getPreco());
			ps.setInt(1, produto.getId());

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Produto buscaProduto(int id) {
		String sql = "select * from PRODUTOS where id=?";
		Produto produto = null;
		try {

			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				Double preco = rs.getDouble("preco");
				

				produto = new Produto(id, nome, preco);
				produto.setId(id);
			}
			ps.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produto;
	}


}
