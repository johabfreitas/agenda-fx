package br.com.johabfreitas.agenda.servicos.impl.importadores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.respositorios.interfaces.AgendaRepositorio;
import br.com.johabfreitas.agenda.servicos.interfaces.ServicoImportadorContato;

public class Java7ServicoContatoImportador implements ServicoImportadorContato {

	@Override
	public void importar(String nomeArquivo, AgendaRepositorio<Contato> agendaRepositorio)
			throws IOException, SQLException {
		Path pathArquivo = Paths.get(nomeArquivo);
		List<String> conteudoArquivo = Files.readAllLines(pathArquivo);
		for (String linha : conteudoArquivo) {
			String[] informacoes = linha.split(";");
			Contato contato = new Contato();
			contato.setNome(informacoes[1]);
			contato.setIdade(Integer.parseInt(informacoes[2]));
			contato.setTelefone(informacoes[3]);
			agendaRepositorio.inserir(contato);
		}

	}

}
