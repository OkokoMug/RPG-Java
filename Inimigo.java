//Crie os inimigos por aqui!!

public class Inimigo extends Personagem{
	
	private Inimigo(String n, int h, int at) {
		this.nome=n;
		this.setHp(h);
		this.setAtk(at);
	}
	
	public void mostraInimigo() {
		System.out.println(" --- "+nome+" --- "+
							"\nVida: "+hp+
							"\nAtaque: "+atk);
	}
	
	//Criar os inimigos abaixo
	//!!So é possivel criar os inimigos por dentro desta classe!!
	//Objeto que referencia os inimigos aqui são criados no main/Principal
	
	public static Inimigo capanga() {
		return new Inimigo("Capanga",15,5);
	}
	
	public static Inimigo drone() {
		return new Inimigo("Drone",8,4);
	}
	
	public static Inimigo droneEspecial() {
		return new Inimigo("Drone Especializado",12,8);
	}
	
	public static Inimigo seguranca() {
		return new Inimigo("Segurança",20,8);
	}
	
	
}
