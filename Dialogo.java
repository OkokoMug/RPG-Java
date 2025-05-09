import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;

public class Dialogo {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	//Dialogos historia
	//Capitulo 1
	//Introdução
	
	public static void introCap1() {
		
		if (!Estados.introCap1Mostrada) {
	
		Estados.introCap1Mostrada = true;
		System.out.println("O céu perdeu sua cor há muito tempo."+
				"\nUm manto cinza cobre a Cidade, onde o som das máquinas nunca dorme."
				+ "\nAs caldeiras fervem noite e dia, alimentadas por petróleo e vidas humanas."
				+ "\nA cada suspiro, os pulmões da população enchem de fumaça e algo mais..."
				+ "\nUma febre sombria se espalha pelos bairros baixos"
				+ "\n - começa com tosse seca e termina com delírios e morte."
				+ "\nAs autoridades silenciam. Medicos desaparecem. E a Corporação, "
				+ "\nmegacorporação que controla as refinarias, os trens, os jornais e até governo, "
				+ "\nnega qualquer responsabilidade."
				+ "\nÉ nesse cenário de sombras que você entra." 
				+ "\nUm investigador ambiental renomado, conhecido por resolver casos que ninguém mais ousa tocar."
				+ "\nContratado por alguém que se identifica apenas como O Cliente, sua missão é clara: " 
				+ "\ndescobrir a origem da praga e expor os culpados — antes que a própria Cidade o engula também.");}
		
	}
	
	//Dialogo cliente
	
	public static void dialogoIntro_cliente() {
		System.out.println("\nVocê está descansando no trem, aproveitando os poucos momentos de descanso que você terá antes de chegar na Cidade. "
				+ "\nAlguém liga para você, O Cliente. Você atende.");
		System.out.println("'Consegue ver A Cidade? Um símbolo de revolução industrial e científica, é o que eles dizem, "
				+ "\nmas não conseguem fazer um maldito trem que pare de balançar. Ainda falta algumas horas antes de você estar na capital.'");
		System.out.println("'A cada novo amanhecer, um trem consome em silêncio cerca de uma tonelada de carvão, e em troca, "
				+ "\nlibera na atmosfera mais de duas toneladas de dióxido de carbono — sem falar na fuligem e nos gases que sequer vemos, mas respiramos.'");
		System.out.println("\nA fumaça densa e negra nos céus é visível à distância cobrindo a cidade, saindo das enormes fábricas que funcionam dia e noite, "
				+ "\nalimentadas por carvão, petróleo e a esperança daquelas pobres almas que lá trabalham.");
		System.out.println("\n'Eficiência máxima a custo de todo o resto.'"
				+ "\n'A expectativa de vida não é muito alta, e para piorar uma doença desconhecida extremamente contagiosa e fatal está se espalhando. "
				+ "\nSeu trabalho é descobrir a origem dela e se há um responsável.'");
		System.out.println("'Me desculpe, mas como posso chamá-lo?'");
	}
	
	public static void dialogoIntro_clienteCt() {
		System.out.println("\nO Cliente: 'Ótimo então, " + Player.get().getNome() + ", falarei com você mais tarde.'");
		System.out.println("\nVocê descansa o resto da viagem de trem. Ao acordar com o trem freiando você finalmente se levanta e sai sem nenhum problema do seu vagão.");
		System.out.println("O ar tóxico preenche seus pulmões e o faz tossir, você consegue sentir a fuligem no ar passando pela sua garganta e a fumaça queimando seus olhos.");
		System.out.println("Você veste sua máscara de gás, um item essencial. A máscara cobre completamente a sua face e a protege dos resíduos no ar nos seus olhos, "
				+ "\ne o único filtrador te protege do mesmos mas para seus inocentes pulmões. ");
	}
	
	
	
	//Intro cidade
	
	public static void introChegadaCidade() {
		if (!Estados.introChegadaMostrada) {
			Estados.introChegadaMostrada = true;
		System.out.println("\nA viagem até a Cidade não foi longa, porém voce se sente exaurido.\n"+
						"Seja por conta das vibrações do trem, ou pela completa ausencia de qualquer verde pela janela...");}
	}
	
	//Seleção de especialização
	public static void selectEspec() {
		
		if (!Estados.selectEspecMostrada) {
			
		Estados.selectEspecMostrada = true;
		System.out.println("\n"+
				"Assim como os melhores ivestigadores não são perfeitos, voce também não é excelente em tudo."+
				"\nIndique qual a sua especialidade...");
		System.out.println("1 - Carisma");
	    System.out.println("2 - Inteligência");
	    System.out.println("3 - Briga");
	    System.out.println("4 - Furtividade");
	    System.out.println("Digite o número correspondente à especialização: ");}
		
	}
	
	
	//Dialogo de combate
	private static final String[] iniCombate= {
			"\nVoce ouve passos se aproximando de voce...","\nO som de aço colidindo ecoa pelo espaço...",
			"\nVoce sente uma presença no escuro. Algo não está certo...","\nUma voz robótica grita pelas esquinas, se aproximando de voce...",
			"\nUma figura pula em sua frente...","\nA fumaça esconde uma silhueta sombria..."
	};
	
	//Dialogo de vitoria
	private static final String[] dialogoVitoria= {
			
			"\nVoce segue seu caminho...","\nApesar do obstaculo, voce conseguiu perseverar. Por enquanto...","\nSegundas chances não nascem em árvores. Voce segue seu caminho...",
			"\nVoce não pode se dar o luxo de descansar, então continua sua jornada...","\nCom o suor escorregando por sua testa, voce segue em frente...","\nVoce se certifica de que não há mais ninguém por perto..."
	};
	
	//Dialogo de itens
	public static final String[] dialogoItem= {
			
			"\nVoce esbarra em algo...","\nUm cidadão deixou cair algo...","\n",
			"\nVoce percebe que há um obejto no chão."
	};
	
	
	//Dialogos de inicio de combate serão escolhidos aleatoriamente
	public static void combate(String inimigo) {
		Random rand = new Random();
		int i = rand.nextInt(iniCombate.length);
		System.out.println(iniCombate[i] + " Voce é surpreendido por  " + inimigo + "!");
	}
	
	//Escolhe os dialogos de vitoria aleatoriamente
	public static void vitoria() {
		int i = new Random().nextInt(dialogoVitoria.length);
		System.out.println(dialogoVitoria[i]);
	}
	
	//Escolhe dialogo dos itens aleatoriamente
	public static void achaItem(String nomeItem) {
		int i = new Random().nextInt(dialogoItem.length);
		System.out.println(dialogoItem[i] + " Voce achou " + nomeItem);
	}
	
	//---------------------//
	
	public static void TremC_dialogoBilheteria() {
		System.out.println("Dentro da bilheteria, há papéis espalhados e uma caixa de metal parcialmente aberta.");
	}
	

	public static void TremC_dialogoLobby() {
		System.out.println("Observando as pessoas passarem com passos apressados pela estação, voce nota como todas estão visilmente pobres em saude..."+
		"\nDeve ser a situação ecológica da cidade...");
	}
	
	public static void TremC_dialogoBanheiro() {
		System.out.println("\nEntrando no banheiro da estação, voce é imediatamente atingido pelo odor fétido de lixo e dejetos."+
				"\nParece que não limpar esse lugar a pelo menos um mes...");
	}
	
	public static void Intro_Apt() {
		if(!Estados.chegadaQuarto) {
			Estados.chegadaQuarto = true;
			System.out.println("\nVocê finalmente chega no local aonde você vai ficar, um pequeno quarto de apartamento barato.");
			System.out.println("Ao abrir a porta você ouve seu ranger, "
					+ "\ne a primeira coisa visível é uma goteira no teto e um rato que foge ao perceber sua presença."
					+ "\nPelo menos eles tem sinal e um filtrador de oxigênio para o quarto que está sujo, é claro.");
			dialogoCliente_IntroHotel();
		}else{
			System.out.println("\nÉ um apartamento pequeno e simples, o suficiente para passar a semana.");
		}
	}
	
	public static void dialogoCliente_IntroHotel() {
		System.out.println("\nVocê ouve seu telefone tocar e o atende, é O Cliente.");
		System.out.println("\nO Cliente: '" + Player.get().getNome()+", você finalmente chegou no seu apartamento? Gostaria de te entregar condições melhores, "
				+ "\nmas esse foi o máximo que consegui achar para suas necessidades de sutileza. Tem gostado do local?'");
		System.out.println("\n'Sinceramente...'");
		System.out.println("\n 1 -> 'Tirando a porta rangendo, o rato, a goteira, a sujeira, e o apartamento, me sinto como um rei.'");
		System.out.println("\n 2 -> 'Já estive em condições piores.'");
		System.out.println("\n 3 -> 'Para uma cliente que propôs tanto dinheiro, é meio decepcionante que este é o seu melhor.'");
		
		String escolha = scanner.nextLine();
	
		switch(escolha) {
		case "1":
			System.out.println("\nO Cliente: 'Pelo menos está com seu senso de humor em dia, detetive.'");
			break;
		case "2":
			System.out.println("\nO Cliente: 'Pela sua longa carreira, só consigo imaginar as terríveis condições que você se encontrou.'");
			break;
		case "3":
			System.out.println("\nO Cliente: 'Sinto muito, detetive, mas esse é o máximo que consegui pelo seu próprio bem.'");
		default:
			System.out.println("Selecione um dialogo valido...");
		}
		
		System.out.println("\nVocê presta a atenção em sua voz, apesar do telefone mudar a voz de uma pessoa, isso está claramente adulterado. "
				+ "\nQuem quer que seja não quer que você saiba quem ele ou ela é. "
				+ "\nSer um detetive exige curiosidade, ou pelo menos você se convence disso. Por que ele esconde sua identidade?");
		
		System.out.println("\nÉ um indivíduo com dinheiro pela enorme quantia ofertada, talvez um aristocrata?"
				+ " Esquema entre corporações? Investigar isso pode deixar o cliente… Chateado, mas só se ele descobrir.");
		
		System.out.println("\nO Cliente: 'Você deve investigar 2 figuras proeminentes e influentes na cidade que há suspeita de serem os causadores da doença por intenção ou não.'");
		System.out.println("\n'Primeiro é Mark Alighieri, o dono do atual monopólio farmacêutico, os primeiros infectados pela doença começaram aqui então vale a pena investigar isso a fundo. "
				+ "\nTudo começou numa fábrica de produtos altamente tóxicos, talvez seja algo acidental ou proposital? Criar o problema e venda a solução.'");
		System.out.println("\n'Segundo é Hiroyuki Arasaka, o dono do atual monopólio dos androids a vapor, um carrasco se me permite dizer. "
				+ "\nEle trata seus funcionários como se trata seus androides os colocando em situações extremas. Ele é o homem mais poderoso e influente ao lado de Mark, ele deve saber de alguma coisa."
				+ "\nVocê é minha última esperança para saber sobre isso, detetive… Por favor, faça um bom trabalho.'");
		
		System.out.println("\n'Você está mexendo com peixe grande aqui, afinal, dono de produtos químicos em massa e um chefe que maltrata seus funcionários."
				+ "\nVocê começará com Mark e seus produtos químicos para ver aonde o mal se iniciou ou só foi finalmente visto após sua origem.'");
		
		System.out.println("\n'A tática escolhida será método Indireto e logo após o confrontamos, ou direto. '"
				+ "\n'Primeiro recolher informações sigilosa e as vezes comprometedoras antes de ir para a segunda etapa que é falar cara a cara com o investigado. "
				+ "\nAmanhã a noite você começará a primeira etapa da investigação, até lá, que tal descansar um pouco?'");
		PassagemTempo_Hora();
	}
	
	public static void PassagemTempo_Hora() {
		for (int i = 1; i <= 20; i++) {
			System.out.println("...");
		}
		
		System.out.print("18:00 - SEGUNDA-FEIRA\n");
	}
	
	public static void RuasDialogo() {
		System.out.println("Os estreitos suburbios da Cidade estão agitados");
	}
	
	public static void HotelDialogo() {
		System.out.println("Texto");
	}
	
	public static void dormir_Apt() {
	    System.out.println("Você dorme por algumas horas...");
	    
	    // First verify we can write to the directory
	    Path saveDir = Paths.get(System.getProperty("user.home"), ".seujogo");
	    if (!canWriteToDirectory(saveDir)) {
	        System.out.println("AVISO CRÍTICO: Não é possível escrever no diretório de save!");
	        System.out.println("Local: " + saveDir);
	        System.out.println("Por favor:");
	        System.out.println("1. Verifique as permissões da pasta");
	        System.out.println("2. Desative temporariamente o antivírus");
	        return;
	    }
	    
	    // Try saving
	    GameSave.salvarJogo();
	    
	    // Verify save
	    if (!GameSave.existeSave()) {
	        System.out.println("AVISO: O progresso não foi salvo!");
	        System.out.println("Solução possível:");
	        System.out.println("1. Execute o jogo como administrador");
	        System.out.println("2. Verifique espaço em disco");
	    }
	}

	private static boolean canWriteToDirectory(Path path) {
	    try {
	        Path testFile = path.resolve("test.tmp");
	        Files.write(testFile, "test".getBytes(), 
	            StandardOpenOption.CREATE, 
	            StandardOpenOption.WRITE,
	            StandardOpenOption.DELETE_ON_CLOSE);
	        return true;
	    } catch (IOException e) {
	        return false;
	    }
	}
	
	public static void vasculhar_caixa() {
        System.out.println("Você encontra uma chave velha dentro da caixa.");
	    }
	
	public static void olha_espelho() {
		System.out.println("Voce se olha através do espelho embaçado. Voce sente que precisa dormir mais...");
	}

	public static void usa_toilet() {
		System.out.println("Voce abre a porta para o toilet, mas por conta do odor, voce desiste de utiliza-lo...");
	}


}
