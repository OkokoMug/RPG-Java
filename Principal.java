import java.util.Stack;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		/*
		Inimigo inimigo1= Inimigo.capanga();
		inimigo1.mostraInimigo();
		
		Inimigo inimigo2= Inimigo.drone();
		inimigo2.mostraInimigo();*/
		
	//	Inimigo inimigo3= Inimigo.seguranca();
		//inimigo3.mostraInimigo();
		
		//Teste inimigo com dialogos direto da classe
		//Dialogo.combate(inimigo3.getNome());
		
		Scanner scanner = new Scanner(System.in);
		
		//Introdução
		Dialogo.introCap1();
		System.out.println("Digite seu novo nome: ");
		String nomeJogador = scanner.nextLine();
		Player jogador = new Player(nomeJogador);	
		System.out.println("Seu cognome durante a investigação será "+jogador.getNome());
		
		//Seleção de especialização
		Dialogo.selectEspec();
		int escolha = Integer.parseInt(scanner.nextLine());
		jogador.setEspec(escolha);
		jogador.playerStat();
		
		//Intro chegada
		Dialogo.introChegadaCidade();
		
		//Inicializando o cenario
		Cenario.initCenarios();
		Cenario cenarioAtual = Cenario.cenarios.get("Lobby");
		
		//Loop de jogo/Exploração/ações
		while (true){
			cenarioAtual.mostrarCenario();
			String direcao = scanner.nextLine().trim();
			direcao = Utils.removerAcentos(direcao.toLowerCase());
			
			if (!direcao.isEmpty()) {
			    direcao = direcao.substring(0, 1).toUpperCase() + direcao.substring(1); 
			}
			
			//Verifica se a direção existe
			if (cenarioAtual.getOpcoes().containsKey(direcao)) {
				String proximoCenario = cenarioAtual.getOpcoes().get(direcao);	
				
				if (proximoCenario.startsWith("#")) {
					//lembrar de fazer com que o # suma na leitura da ação
					//Trata ações especiais
					String nomeMetodo = proximoCenario.substring(1);
					try {
						Method metodo = Dialogo.class.getMethod(nomeMetodo);
						metodo.invoke(null);
					}catch (Exception e) { 
						System.out.println("Erro ao executar ação especial: " + e.getMessage());
					}
					
				}else {
				
				//Proximo cenario
				if (Cenario.cenarios.containsKey(proximoCenario)) {
					cenarioAtual = Cenario.cenarios.get(proximoCenario);
				}else {
					System.out.println("Destino não encontrado");
				}
				
				}
			}else {
				System.out.println("Direção invalida. Tente novamente...");
			}
		}
	}
}
