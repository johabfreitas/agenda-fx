package br.com.johabfreitas.agenda.servicos.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.servicos.interfaces.ServicoContato;

public class PrintWriterServicoContato implements ServicoContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		// PrintWriter (escreve o conteúdo) --> FileWriter (caminho para o arquivo) -->
		// arquivo em si
		try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
			try (PrintWriter printWriter = new PrintWriter(fileWriter, true)) {
				for (Contato contato : contatos) {
					printWriter.println(String.format("%d;%s;%d;%s", contato.getId(), contato.getNome(),
							contato.getIdade(), contato.getTelefone()));
					
				}
			}
		}
	}

}
