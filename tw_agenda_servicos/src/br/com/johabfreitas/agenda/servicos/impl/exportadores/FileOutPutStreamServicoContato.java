package br.com.johabfreitas.agenda.servicos.impl.exportadores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.servicos.interfaces.ServicoExportadorContato;

public class FileOutPutStreamServicoContato implements ServicoExportadorContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		try (FileOutputStream fileStream = new FileOutputStream(nomeArquivo)){
			List<String> dados  = contatos.stream()
					.map(contato -> String.format("%d;%s;%d;%s\n", contato.getId(),
						contato.getNome(), contato.getIdade(), contato.getTelefone())).collect(Collectors.toList());
			for(String dado: dados) {
				fileStream.write(dado.getBytes());
			}
		}
		
	}

}
