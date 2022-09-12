package br.com.johabfreitas.agenda.fx;

import br.com.johabfreitas.agenda.entidades.Contato;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {
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

}
