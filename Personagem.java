import java.util.Random;

public class Personagem {
	
	protected String nome;
	private String espec;
	protected int hp;
	protected int atk;
	private int nivel;
	private int persuasao;
	private int logica;
	private int stealth;
	
	public Personagem() {
		this.nome="Vazio";
	}
	
	public Personagem(String n) {
		this.nome=n;
	}
	
	private void espec(int n) {
		if (n==1) {
			this.espec="Carisma";
			this.hp=7;
			this.atk=3;
			this.nivel=1;
			this.persuasao=10;
			this.logica=5;
			this.stealth=2;
		}
		if (n==2) {
			this.espec="Inteligencia";
			this.hp=5;
			this.atk=2;
			this.nivel=1;
			this.persuasao=5;
			this.logica=10;
			this.stealth=3;
		}
		if (n==3) {
			this.espec="Briga";
			this.hp=10;
			this.atk=5;
			this.nivel=1;
			this.persuasao=3;
			this.logica=2;
			this.stealth=0;
		}
		if (n==4) {
			this.espec="Investigação";
			this.hp=5;
			this.atk=1;
			this.nivel=1;
			this.persuasao=1;
			this.logica=5;
			this.stealth=10;
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
	            System.out.println("Especialidade inválida.");
	        }
	}
	
	public String getNome() {
		return this.nome;
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
	
	public int getNivel() {
		return this.nivel;
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
