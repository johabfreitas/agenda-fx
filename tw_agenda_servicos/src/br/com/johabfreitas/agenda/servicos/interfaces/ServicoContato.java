package br.com.johabfreitas.agenda.servicos.interfaces;

import java.io.IOException;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;



public interface ServicoContato {

	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException;
}
