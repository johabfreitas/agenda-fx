package br.com.johabfreitas.agenda.servicos.interfaces;

import java.io.IOException;
import java.sql.SQLException;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.respositorios.interfaces.AgendaRepositorio;

public interface ServicoImportadorContato {
	
	public void importar(String nomeArquivo, AgendaRepositorio<Contato> agendaRepositorio) throws IOException, SQLException;
}
