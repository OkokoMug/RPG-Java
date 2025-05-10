import java.util.Stack;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
	    
	    if (GameSave.existeSave()) {
	        System.out.println("1 - Carregar progresso");
	        System.out.println("2 - Iniciar novo progresso. ([!]O progresso salvo será excluído[!])");
	        System.out.print("\nEscolha: ");
	        
	        int escolha = Utils.lerInteiro(scanner, 1, 2, "");
	        
	        if (escolha == 1) {
	            GameSave.carregarJogo();
	            Cenario.initCenarios();
	            
	            // Start directly in apartment
	            Cenario cenarioAtual = Cenario.cenarios.get("Apartamento");
	            gameLoop(cenarioAtual, scanner);
	            return;
	        } else {
	            GameSave.apagarSave();
	        }
	    }
	    
	    // Run normal intro for new game
	    runNewGameIntro(scanner);
	}

	private static void gameLoop(Cenario startingCenario, Scanner scanner) {
		Cenario cenarioAtual = startingCenario;
		while (true) {
			cenarioAtual.mostrarCenario();
			String direcao = scanner.nextLine().trim();
			direcao = Utils.removerAcentos(direcao.toLowerCase());
			Player.get().setCenarioAtual(cenarioAtual.getClass().getSimpleName());

			
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

	private static void runNewGameIntro(Scanner scanner) {

	    for (String flag : Estados.flags.keySet()) {
	        Estados.setFlag(flag, false);
	    }

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

	    if (!Estados.getFlag("selectEspecMostrada")) {
	        Dialogo.selectEspec();
	        int escolha = Utils.lerInteiro(scanner, 1, 4, "...");
	        Player.get().setEspec(escolha);
	        Estados.setFlag("selectEspecMostrada", true);
	    }

	    Player.get().playerStat();
	    Dialogo.dialogoIntro_clienteCt();
	    Dialogo.introChegadaCidade();
	    
	    Cenario.initCenarios();
	    Cenario cenarioAtual = Cenario.cenarios.get("Lobby");
	    gameLoop(cenarioAtual, scanner);
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
