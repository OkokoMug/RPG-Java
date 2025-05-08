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
		
        if (GameSave.existeSave()) {
            System.out.println("Há um progresso salvo. Deseja carregá-lo ou iniciar um novo?");
            System.out.println("1 - Carregar progresso");
            System.out.println("2 - Iniciar novo progresso. ([!]O progresso salvo será excluído[!])\n");

            int escolha = Integer.parseInt(scanner.nextLine());
            
            if (escolha == 1) {
                GameSave.carregarJogo();
            } else if (escolha == 2) {
            	// Apaga o save anterior e inicia um novo jogo
            	GameSave.apagarSave();
                System.out.println("Iniciando novo jogo...\n");
                for (int i = 0; i <= 2; i++) {
                	System.out.println("");
                		}
                
                } else {
                	System.out.println("Opção inválida. Iniciando novo jogo...");
                	GameSave.apagarSave();
                	for (int i = 0; i <= 2; i++) {
                		System.out.println("");
                			}
                	}
            
        	}else {
                	System.out.println("Nenhum jogo salvo encontrado. Iniciando novo jogo...\n");
                	for (int i = 0; i <= 2; i++) {
                		System.out.println("");
                	}
                }
		
		// Introdução
		Dialogo.introCap1();
		Dialogo.dialogoIntro_cliente();

		System.out.println("\nAnonimato faz parte do trabalho, você deveria inventar um nome.");
		
	    String nomeJogador = "";
        while (nomeJogador.isEmpty()) {
            nomeJogador = scanner.nextLine().trim(); 
            if (nomeJogador.isEmpty()) {
                System.out.println("Por favor, insira um nome válido.");
            }
        }

		Player.criarInstancia(nomeJogador);

		System.out.println("'Me chame de " + Player.get().getNome() + ".'");

		Dialogo.selectEspec();
		int escolha = Integer.parseInt(scanner.nextLine());
		Player.get().setEspec(escolha);
		Player.get().playerStat();

		
		Dialogo.dialogoIntro_clienteCt();
		Dialogo.introChegadaCidade();
		
		Cenario.initCenarios();
		Cenario cenarioAtual = Cenario.cenarios.get("Lobby");
		
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
