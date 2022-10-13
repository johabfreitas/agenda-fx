package br.com.johabfreitas.agenda.repositorios.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.fabricas.FabricaConexaoJdbc;
import br.com.johabfreitas.agenda.respositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorioJdbc implements AgendaRepositorio<Contato> {

	@Override
	public List<Contato> selecionar() throws SQLException, IOException {
//		Connection conexao = null;
		List<Contato> contatos = new ArrayList<Contato>();
		try (Connection conexao = FabricaConexaoJdbc.criarConexao()){
			/**
			Properties props = new Properties();
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties");
			if (is == null) {
				throw new FileNotFoundException("O arquivo de configuração do banco de dados não foi encontrado!");
			}
			props.load(is);
			conexao = DriverManager.getConnection(props.getProperty("urlConexao"), props.getProperty("usuarioConexao"),
					props.getProperty("senhaConexao")); 
			**/
			
			Statement comando = conexao.createStatement();
			ResultSet rs = comando.executeQuery("SELECT * FROM contatos");
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setIdade(rs.getInt("idade"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contatos.add(contato);
			}
		} 

		return contatos;
	}

	@Override
	public void inserir(Contato entidade) throws IOException, SQLException {
		Connection conexao = null;
		try {
			conexao = FabricaConexaoJdbc.criarConexao();
			PreparedStatement comando = conexao.prepareStatement("INSERT INTO contatos (nome, idade, telefone)" + 
																 "VALUES (?, ?, ?)");
			comando.setString(1, entidade.getNome());
			comando.setInt(2, entidade.getIdade());
			comando.setString(3, entidade.getTelefone());
			comando.execute();
		} finally {
			if(conexao != null) {
				conexao.close();
			}
		}

	}

	@Override
	public void atualizar(Contato entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Contato entidade) {
		// TODO Auto-generated method stub

	}

}
