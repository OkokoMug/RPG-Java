import java.util.Scanner;
import java.io.Serializable;

public class Player extends Personagem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Player instancia;
	private String nome;
    private String cenarioAtual; 
    private int especializacao;
	
    private Player(String n) {
        this.nome = n;
    }
	
    public static Player get() {
        if (instancia == null) {
            throw new IllegalStateException("Jogador nao inicializado.");
        }
        return instancia;
    }
	
    public static void criarInstancia(String nome) {
        if (instancia == null) {
            instancia = new Player(nome);
        } else {
            instancia.nome = nome;
        }
    }
    
    public Player copy() {
        Player copy = new Player(this.nome);
        copy.setEspec(this.getEspecIndex());
        copy.setHp(this.hp);
        copy.setAtk(this.atk);
        copy.setCenarioAtual(this.cenarioAtual);
        return copy;
    }
    
    public void incAtk() { 
        atk = Math.min(atk + 1, 50); 
    }
    
    public void incHp() {
    	hp = Math.min(hp + 1, 100);
    }
    
    public void incPersu() {
    	persuasao = Math.min(persuasao + 1, 20);
    }
    
    public void incLogica() {
    	logica = Math.min(logica + 1, 20);
    }
    
    public void incStealth() {
    	stealth = Math.min(stealth + 1, 20);
    }
    
    
    public int getEspecIndex() {
        switch(this.getEspec().toLowerCase()) {
            case "carisma": return 1;
            case "inteligencia": return 2;
            case "atletismo": return 3;
            case "furtividade": return 4;
            default: return 0;
        }
    }
    
	public void playerStat() {
		System.out.println("\nAqui estão suas estatísticas: "+
							"\n --- "+this.nome+" --- "+
							"\nEspecialização: "+this.getEspec()+
							"\nAtaque: "+this.getAtk()+
							"\nAtletismo: "+this.getHp()+
							"\nPersuasão: "+this.getPersuasao()+
							"\nLogica: "+this.getLogica()+
							"\nDiscrição: "+this.getStealth());
		
	}
	
	
	
	 public String getCenarioAtual() {
	        return cenarioAtual;
	    }

	 public void setCenarioAtual(String cenarioAtual) {
	        this.cenarioAtual = cenarioAtual;
	 }
	    	
		public int getMaxHp() {
			return this.getHp();
		}
		
		public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }


	    public int getEspecializacao() {
	        return especializacao;
	    }

	    public void setEspecializacao(int especializacao) {
	        this.especializacao = especializacao;
	    }
	    
	
}
