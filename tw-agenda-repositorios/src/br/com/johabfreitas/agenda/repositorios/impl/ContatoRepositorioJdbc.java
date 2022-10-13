package br.com.johabfreitas.agenda.repositorios.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.respositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorioJdbc implements AgendaRepositorio<Contato>{

	@Override
	public List<Contato> selecionar() throws SQLException {
		Connection conexao = null;
		List<Contato> contatos = new ArrayList<Contato>() ;
		conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/tw-jdbc", "tw_clientes_user", "tw_clientes_pwd");
		Statement comando = conexao.createStatement();
		ResultSet rs = comando.executeQuery("SELECT * FROM contatos");
		while(rs.next()) {
			Contato contato = new Contato();
			contato.setId(rs.getInt("id"));
			contato.setIdade(rs.getInt("idade"));
			contato.setNome(rs.getString("nome"));
			contato.setTelefone(rs.getString("telefone"));
			contatos.add(contato);
		}
		return contatos;
	}

	@Override
	public void inserir(Contato entidade) {
		// TODO Auto-generated method stub
		
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
