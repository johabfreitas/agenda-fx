package br.com.johabfreitas.agenda.servicos.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.servicos.interfaces.ServicoContato;

public class BufferedWriterServicoContato implements ServicoContato{

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException{
		// BufferedWrite (escrever) ---> FileWriter (apontador) ---> arquivo no HD
		FileWriter fileWriter = new FileWriter(nomeArquivo);
		BufferedWriter writer = new BufferedWriter(fileWriter); 
		
	}

}
