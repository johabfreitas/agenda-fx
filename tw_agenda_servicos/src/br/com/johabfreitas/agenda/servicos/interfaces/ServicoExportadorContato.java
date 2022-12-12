package br.com.johabfreitas.agenda.servicos.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;



public interface ServicoExportadorContato {

	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException, SQLException;
}
