package br.com.johabfreitas.agenda.respositorios.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface AgendaRepositorio<T> {

	List<T> selecionar() throws SQLException;
	void inserir(T entidade);
	void atualizar(T entidade);
	void excluir(T entidade);
	
}
