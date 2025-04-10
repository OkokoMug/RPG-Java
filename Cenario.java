
public class Cenario {
	
	private String nome;
	private String descricao;
	
	public Cenario(String nome, String desc) {
		this.nome = nome;
		this.descricao = desc;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void exibirDescricao() {
		System.out.println("Você está " + nome);
		System.out.println(descricao);
	}

}
