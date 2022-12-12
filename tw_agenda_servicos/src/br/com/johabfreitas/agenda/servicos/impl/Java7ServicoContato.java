package br.com.johabfreitas.agenda.servicos.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.servicos.interfaces.ServicoContato;

public class Java7ServicoContato implements ServicoContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		String dados = contatos.stream().map(contato -> String.format("%d;%s;%d;%s\n", contato.getId(),
				contato.getNome(), contato.getIdade(), contato.getTelefone())).collect(Collectors.joining());
		Path path = Paths.get(nomeArquivo);
		byte[] dadosEmBytes = dados.getBytes();
		Files.write(path, dadosEmBytes);

	}

}
