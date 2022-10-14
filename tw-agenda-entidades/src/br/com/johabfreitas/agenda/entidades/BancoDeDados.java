package br.com.johabfreitas.agenda.entidades;

public class BancoDeDados {

	private String driver;
	private String tipoDoBanco;
	private String enderecoDoBanco;
	private int porta;
	private String nomeDoBanco;
	private boolean usaSSL;
	private String usuario;
	private String senha;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getTipoDoBanco() {
		return tipoDoBanco;
	}

	public void setTipoDoBanco(String tipoDoBanco) {
		this.tipoDoBanco = tipoDoBanco;
	}

	public String getEnderecoDoBanco() {
		return enderecoDoBanco;
	}

	public void setEnderecoDoBanco(String enderecoDoBanco) {
		this.enderecoDoBanco = enderecoDoBanco;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getNomeDoBanco() {
		return nomeDoBanco;
	}

	public void setNomeDoBanco(String nomeDoBanco) {
		this.nomeDoBanco = nomeDoBanco;
	}

	public boolean isUsaSSL() {
		return usaSSL;
	}

	public void setUsaSSL(boolean usaSSL) {
		this.usaSSL = usaSSL;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
