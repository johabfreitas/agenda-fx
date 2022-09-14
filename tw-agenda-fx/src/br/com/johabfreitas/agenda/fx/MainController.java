package br.com.johabfreitas.agenda.fx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.johabfreitas.agenda.entidades.Contato;
import br.com.johabfreitas.agenda.repositorios.impl.ContatoRepositorio;
import br.com.johabfreitas.agenda.respositorios.interfaces.AgendaRepositorio;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	
	private Boolean ehIncluir;
	
	private Contato contatoSelecionado;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.tabelaContatos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		habilitarEdicaoAgenda(false);
//		this.tabelaContatos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contato>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Contato> observable, Contato oldValue, Contato newValue) {
//				if(newValue != null) {
//					txfNome.setText(newValue.getNome());
//					txfIdade.setText(String.valueOf(newValue.getIdade()));
//					txfTelefone.setText(newValue.getTelefone());
//				}				
//			}
//		});
		this.tabelaContatos.getSelectionModel().selectedItemProperty().addListener((observador, contatoAntigo, contatoNovo) -> {
			if(contatoNovo != null) {
				txfNome.setText(contatoNovo.getNome());
				txfIdade.setText(String.valueOf(contatoNovo.getIdade()));
				txfTelefone.setText(contatoNovo.getTelefone());
				this.contatoSelecionado = contatoNovo;
			}
		});
		
		carregarTabelaContatos();

	}
	
	public void botaoIncluir_Action(){
		this.ehIncluir = true;
		this.txfNome.setText("");
		this.txfIdade.setText("");
		this.txfTelefone.setText("");
		habilitarEdicaoAgenda(true);
	}
	
	public void botaoAlterar_Action() {
		habilitarEdicaoAgenda(true);
		this.ehIncluir = false;
		this.txfNome.setText(this.contatoSelecionado.getNome());
		this.txfIdade.setText(Integer.toString(this.contatoSelecionado.getIdade()));
		this.txfTelefone.setText(this.contatoSelecionado.getTelefone());
	}
	
	public void boataoCancelar_Action() {
		habilitarEdicaoAgenda(false);
		this.tabelaContatos.getSelectionModel().selectFirst();
	}
	
	public void botaoSalvar_Action() {
		AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorio();
		Contato contato = new Contato();
		contato.setNome(txfNome.getText());
		contato.setIdade(Integer.parseInt(txfIdade.getText()));
		contato.setTelefone(txfTelefone.getText());
		if(this.ehIncluir) {
			repositorioContato.inserir(contato);
		} else {
			repositorioContato.atualizar(contato);
		}
		habilitarEdicaoAgenda(false);
		carregarTabelaContatos();
		this.tabelaContatos.getSelectionModel().selectFirst();
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
	
	private void habilitarEdicaoAgenda(Boolean edicaoEstaHabilitada) {
		this.txfNome.setDisable(!edicaoEstaHabilitada);
		this.txfIdade.setDisable(!edicaoEstaHabilitada);
		this.txfTelefone.setDisable(!edicaoEstaHabilitada);
		this.botaoSalvar.setDisable(!edicaoEstaHabilitada);
		this.botaoCancelar.setDisable(!edicaoEstaHabilitada);
		this.botaoIncluir.setDisable(edicaoEstaHabilitada);
		this.botaoAlterar.setDisable(edicaoEstaHabilitada);
		this.botaoExcluir.setDisable(edicaoEstaHabilitada);
		this.tabelaContatos.setDisable(edicaoEstaHabilitada);
	}

}
