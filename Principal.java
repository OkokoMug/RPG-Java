
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		/*
		Player p1 = new Player("Jose");
		p1.setEspec(3);
		Player p2 = new Player();
		
		//Teste de mostra de estatisticas do jogador
		//System.out.println(p1.getEspec());
		p1.playerStat();
		p2.playerStat();
		
		Inimigo inimigo1= Inimigo.capanga();
		inimigo1.mostraInimigo();
		
		Inimigo inimigo2= Inimigo.drone();
		inimigo2.mostraInimigo();*/
		
		//Inimigo inimigo3= Inimigo.seguranca();
		//inimigo3.mostraInimigo();
		
		//Teste de inimigos com dialogo simples
		/*System.out.println("Voce entra numa sala escura, o breu cobrindo seus olhos."
				+ "Voce então se vira ao ouvir a porta batendo, apenas para se deparar com um "+
				inimigo3.getNome()+"!!");*/
		
		//Teste inimigo com dialogos direto da classe
		//Dialogo.combate(inimigo3.getNome());
		
		//Teste dialogo introdução
		Dialogo.introCap1();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite seu novo nome: ");
		String nomeJogador = scanner.nextLine();
		Player jogador = new Player(nomeJogador);	
		//scanner.close();
		System.out.println("Seu cognome durante a investigação será "+jogador.getNome());
		
		Dialogo.selectEspec();
		String escolha = scanner.nextLine();
		int numeroEscolha = Integer.parseInt(escolha);
		jogador.setEspec(numeroEscolha);
		jogador.playerStat();
		
		System.out.println();
		Dialogo.introChegadaCidade();
		
		Cenario estTrem = new Cenario("na Estação de Trem...","Descrição");
		estTrem.exibirDescricao();
		
		
		
	}

}
