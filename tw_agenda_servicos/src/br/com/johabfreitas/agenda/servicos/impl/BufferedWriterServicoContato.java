package br.com.johabfreitas.agenda.servicos.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.servicos.interfaces.ServicoContato;

public class BufferedWriterServicoContato implements ServicoContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		// BufferedWrite (escrever) ---> FileWriter (apontador) ---> arquivo no HD
		FileWriter fileWriter = new FileWriter(nomeArquivo);
		try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
			List<String> dadosParaExportar = contatos.stream().map(contato -> String.format("%d;%s;%d;%s\n",
					contato.getId(), contato.getNome(), contato.getIdade(), contato.getTelefone()))
					.collect(Collectors.toList());
			
			/*// dadosParaExportar.forEach(linha -> writer.write(linha));
			 * No Java expressões lambdas não podem lançar exceções
			 */
			
			for (String linha : dadosParaExportar) {
				writer.write(linha);
			}
		}

	}

}
