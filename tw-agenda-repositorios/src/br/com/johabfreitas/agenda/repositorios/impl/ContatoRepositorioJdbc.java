package br.com.johabfreitas.agenda.repositorios.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.respositorios.interfaces.AgendaRepositorio;

public class ContatoRepositorioJdbc implements AgendaRepositorio<Contato>{

	@Override
	public List<Contato> selecionar() throws SQLException {
		Connection conexao = null;
		conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/tw-jdbc", "tw_clientes_user", "tw_clientes_pwd");
		return null;
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
