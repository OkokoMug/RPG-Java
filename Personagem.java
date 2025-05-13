import java.io.Serializable;
import java.util.Random;

public class Personagem implements Serializable {
	private static final long serialVersionUID = 2L;
	
	protected String nome;
	private String espec;
	protected int hp;
	protected int atk;
	protected int persuasao = 0;
	protected int logica = 0;
	protected int stealth = 0;
	
	public Personagem() {
	}
	
	public Personagem(String n) {
		this.nome=n;
	}
	
	private void espec(int n) {
		if (n==1) {
			this.espec="Carisma";
			this.hp=7;
			this.atk=10;
			this.persuasao=10;
			this.logica=10;
			this.stealth=2;
			System.out.println("\nVoce sempre soube que o melhor modo de lidar com alguém, é com palavras. " +
								"\n Confiança. Manipulação. Assim foi sua vida neste mundo.");
		}
		if (n==2) {
			this.espec="Inteligencia";
			this.hp=5;
			this.atk=5;
			this.persuasao=5;
			this.logica=15;
			this.stealth=3;
			System.out.println("\nNão há espaço para fé por essas bandas. Por conta disso, voce se prendeu ao pragmatismo."+
								"\nA inteligência não está em saber tudo, mas em saber discernir o essencial em meio ao ruído do mundo.");
		}
		if (n==3) {
			this.espec="Atletismo";
			this.hp=10;
			this.atk = 15;
			this.persuasao=3;
			this.logica=10;
			this.stealth=0;
			System.out.println("\nNão há parceiros mais confiáveis do que seus próprios punhos. " + 
								"\nA violencia nua e crua. A natureza da humanidade.");
		}
		if (n==4) {
			this.espec="Malemolencia";
			this.hp=5;
			this.atk=10;
			this.persuasao=1;
			this.logica=10;
			this.stealth=10;
			System.out.println("\nÉ preciso muito esforço e habilidade para esconder o próprio talento e competência. " +
								"\nA arte de ser sutil abre muitas portas, incluindo aquelas que não estão a vista.");
		}
	}
	
	public void espec() {
		Random rand = new Random();
		int aleatorio = rand.nextInt(4)+1;
		espec(aleatorio);
	}
	
	public String getEspec() {
		return this.espec;
	}
	
	public void setEspec(int n) {
		 if (n >=1 && n <=4) {
	            espec(n);
	        } else {
	            System.out.println("Especialidade aleatoria atribuída.");
	            espec();
	        }
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public void setAtk(int n) {
		this.atk=n;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int n) {
		this.hp=n;
	}
	
	public int getPersuasao() {
		return this.persuasao;
	}
	
	public int getLogica() {
		return this.logica;
	}
	
	
	public int getStealth() {
		return this.stealth;
	}
	
	
}
