
public class Player extends Personagem {
	
	public Player() {
		this.nome="John Smith";
		this.espec();
	}
	
	public Player(String n) {
		this.nome=n;
	}
	
	public void playerStat() {
		System.out.println(" --- "+this.nome+" --- "+
							"\nEspecialização: "+this.getEspec()+
							"\nNivel: "+this.getNivel()+
							"\nAtaque: "+this.getAtk()+
							"\nVitalidade: "+this.getHp()+
							"\nPersuasão: "+this.getPersuasao()+
							"\nLogica: "+this.getLogica()+
							"\nDiscrição: "+this.getStealth());
		
	}
	
	
	
}
