	import java.io.Serializable;

public class GameData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nomeJogador;
	private String cenarioAtual;
	private int especializacao;	

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getCenarioAtual() {
		return cenarioAtual;
	}
	
	public void setCenarioAtual(String cenarioAtual) {
		this.cenarioAtual = cenarioAtual;
	}
	
	public int getEspecializacao() {
		return especializacao;
	}
	
	public void setEspecializacao(int especializacao) {
		this.especializacao = especializacao;
	}

	
}
