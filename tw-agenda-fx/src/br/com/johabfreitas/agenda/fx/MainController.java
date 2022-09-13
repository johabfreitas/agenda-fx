package br.com.johabfreitas.agenda.fx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.repositorios.impl.ContatoRepositorio;
import br.com.johabfreitas.agenda.respositorios.interfaces.AgendaRepositorio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	/*
	 * Essa anotação vai informar que o objeto abaixo faz referência algum elemento
	 * existente do Main.fxml
	 */
	@FXML
	private TableView<Contato> tabelaContatos;
	@FXML
	private Button botaoIncluir;
	@FXML
	private Button botaoAlterar;
	@FXML
	private Button botaoExcluir;
	@FXML
	private TextField txfNome;
	@FXML
	private TextField txfIdade;
	@FXML
	private TextField txfTelefone;
	@FXML
	private Button botaoSalvar;
	@FXML
	private Button botaoCancelar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.tabelaContatos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		carregarTabelaContatos();

	}

	private void carregarTabelaContatos() {
		AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorio();
		List<Contato> contatos = repositorioContato.selecionar();
		if (contatos.isEmpty()) {
			Contato contato = new Contato();
			contato.setNome("Johab");
			contato.setIdade(35);
			contato.setTelefone("8499999-9999");
			contatos.add(contato);
		}
		ObservableList<Contato> contatosObervableList = FXCollections.observableArrayList(contatos);
		this.tabelaContatos.getItems().setAll(contatosObervableList);
	}

}
