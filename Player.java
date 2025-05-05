import java.util.Scanner;

public class Player extends Personagem {
	
	public Player() {
		this.nome="John Smith";
		
	}
	
	public Player(String n) {
		this.nome=n;
		
	}
	
	public void playerStat() {
		System.out.println("\nAqui estão suas estatísticas: "+
							"\n --- "+this.nome+" --- "+
							"\nEspecialização: "+this.getEspec()+
							"\nNivel: "+this.getNivel()+
							"\nAtaque: "+this.getAtk()+
							"\nVitalidade: "+this.getHp()+
							"\nPersuasão: "+this.getPersuasao()+
							"\nLogica: "+this.getLogica()+
							"\nDiscrição: "+this.getStealth());
		
	}
	
	public int getMaxHp() {
		return this.getHp();
	}
	
	public void combateCheck(Inimigo inimigo) {
		Dialogo.combate(inimigo.getNome());
		inimigo.mostraInimigo();
		this.playerStat();
		
		if (this.getAtk() >= inimigo.getHp()) {
			System.out.println("Seu poder de ataque supera a resistencia do inimigo. Voce vence...");
			return;
		}
		
		Scanner sc = new Scanner(System.in);
		boolean flagCombate = true;
		
		while (flagCombate) {
			System.out.println("\n--- Sua vez ---");
			System.out.println("1 - Atacar");
			System.out.println("2 - Usar especialidade");
			System.out.println("3 - fugir");
			
			System.out.println("");
			String escolha = sc.nextLine().trim();
			
			switch (escolha) {
			case "1":
				System.out.println("Voce ataca o inimigo");
				inimigo.setHp(inimigo.getHp() - this.getAtk());
				if (inimigo.getHp() <= 0) {
					Dialogo.vitoria();
					flagCombate = false;
				}else {
					System.out.println("Inimigo ainda tem: " + inimigo.getHp());
				}
				break;
			
			case "2":
			    String espec = this.getEspec().toLowerCase();
			    switch (espec) {
			        case "carisma":
			            System.out.println("Você tenta persuadir o inimigo...");
			            if (Math.random() < 0.6) {
			                System.out.println("Voce convence o inimigo a recuar. Ele se afasta cautelosamente...");
			                flagCombate = false;
			            } else {
			                System.out.println("Voce falha em convence-lo. O inimigo avança...");
			            }
			            break;

			        case "atletismo":
			            System.out.println("Você canaliza sua força para um golpe poderoso...");
			            if (Math.random() < 0.6) {
			                int danoDuplo = this.getAtk() * 2;
			                inimigo.setHp(inimigo.getHp() - danoDuplo);
			                System.out.println("Voce o atinge de forma brutal. Você causou " + danoDuplo + " de dano!");
			                if (inimigo.getHp() <= 0) {
			                    Dialogo.vitoria();
			                    flagCombate = false;
			                } else {
			                    System.out.println("Vida do inimigo: " + inimigo.getHp());
			                }
			            } else {
			                System.out.println("Você erra o seu ataque...");
			            }
			            break;

			        case "furtividade":
			            System.out.println("Você tenta desaparecer nas sombras...");
			            if (Math.random() < 0.7) {
			                System.out.println("Você escapa sem ser visto!");
			                flagCombate = false;
			            } else {
			                System.out.println("O inimigo percebe sua tentativa. Prepare-se...");
			            }
			            break;

			        case "inteligência":
			            System.out.println("Você analisa o inimigo e encontra uma fraqueza...");
			            System.out.println("Ataque do inimigo foi reduzido...");
			            inimigo.setAtk(Math.max(1, inimigo.getAtk() - 2));
			            break;

			        default:
			            System.out.println("Sua especialidade não possui efeito neste combate.");
			            break;
			    }
			    break;

				
				
			case "3":
				System.out.println("Você tenta fugir...");
				if (Math.random() < 0.3) {
					System.out.println("Você conseguiu escapar!");
					flagCombate = false;
				} else {
					System.out.println("Você não conseguiu fugir!");
				}
				break;

			default:
				System.out.println("Opção inválida.");
				break;
			}	
			
			if (flagCombate) {
				System.out.println("\n--- Vez do Inimigo ---");
				this.setHp(this.getHp() - inimigo.getAtk());
				System.out.println("Voce recebeu " + inimigo.getAtk() + " de dano.");
				System.out.println("Sua vida atual: " + this.getHp());
				if (this.getHp() <= 0) {
					System.out.println("Voce foi derrotado...");
					flagCombate = false;
				}
			
			}
		}
	}
	
}
