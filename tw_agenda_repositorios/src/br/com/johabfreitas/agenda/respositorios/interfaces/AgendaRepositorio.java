package br.com.johabfreitas.agenda.respositorios.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AgendaRepositorio<T> {

	List<T> selecionar() throws SQLException, IOException;
	void inserir(T entidade) throws SQLException, IOException;
	void atualizar(T entidade) throws SQLException, IOException;
	void excluir(T entidade) throws SQLException, IOException;
	
}
