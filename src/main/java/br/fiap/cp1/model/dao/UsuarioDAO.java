package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import connectionFactory.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO {

	private Connection conexao;

	public UsuarioDAO() {
		this.conexao = new ConnectionFactory().getConnection();
	}

	// inserir registros no DB
	public void adicionaUsuarioNoBanco(Usuario usuario) {
		String sql = "insert into usuarios(nome, email, telefone, senha, dataCadastro) values (?,?,?,?,?)";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getTelefone());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, usuario.getData());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// buscar todos os registros do DB
	public List<Usuario> buscarTodosUsuarios() {

		try {
			List<Usuario> usuarios = new ArrayList<Usuario>(); // criar a lista para guardar objetos Usuario

			PreparedStatement stmt = conexao.prepareStatement("select * from usuarios");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) { // enquanto tiver registros no DB execute

				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String tel = rs.getString("telefone");
				String senha = rs.getString("senha");

				Usuario usuario = new Usuario(nome, email, tel, senha);
				usuario.setId(id);
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException();
		}
	}

	// excluir um registro
	public void removeUsuarioPeloId(int id) {
		String sql = "delete from usuarios where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// alterar um registro
	public void alterarUsuarioPeloId(Usuario usuario) {
		String sql = "update usuarios set nome=?, email=?, telefone=?, senha=? where id=?";

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getTelefone());
			stmt.setString(4, usuario.getSenha());
			stmt.setInt(5, usuario.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscaUsuarioPeloId(int id) {
		String sql = "select * from usuarios where id=?";
		Usuario usuario = null;
		try {

			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String tel = rs.getString("telefone");
				String senha = rs.getString("senha");

				usuario = new Usuario(nome, email, tel, senha);
				usuario.setId(id);
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
