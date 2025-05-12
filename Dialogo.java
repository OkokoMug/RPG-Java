import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;

public class Dialogo {
	
	private static final Scanner scanner = new Scanner(System.in);
	private static final Random rand = new Random();
	
	//Dialogos historia
	//Capitulo 1
	//Introdução
	
	public static void introCap1() {
		
		if (!Estados.getFlag("introCap1Mostrada")) {
		Estados.setFlag("introCap1Mostrada",true);
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
		if (!Estados.getFlag("introChegadaMostrada")) {
			Estados.setFlag("introChegadaMostrada", true);
			System.out.println("\nA viagem até a Cidade não foi longa, porém voce se sente exaurido.\n"+
						"Seja por conta das vibrações do trem, ou pela completa ausencia de qualquer verde pela janela...");}
	}
	
	//Seleção de especialização
	public static void selectEspec() {

	    if (!Estados.getFlag("selectEspecMostrada")) {
	        System.out.println("\nAssim como os melhores investigadores não são perfeitos, "
	            + "você também não é excelente em tudo.\n"
	            + "Indique qual a sua especialidade...");
	        System.out.println("1 - Carisma");
	        System.out.println("2 - Inteligência");
	        System.out.println("3 - Atletismo");
	        System.out.println("4 - Malemolencia");
	        System.out.println("Digite o número correspondente à especialização: ");
	        
	        Estados.setFlag("selectEspecMostrada", true);
	    }
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
		int i = rand.nextInt(iniCombate.length);
		System.out.println(iniCombate[i] + " Voce é surpreendido por  " + inimigo + "!");
	}
	
	//Escolhe os dialogos de vitoria aleatoriamente
	public static void vitoria() {
		int i = rand.nextInt(dialogoVitoria.length);
		System.out.println(dialogoVitoria[i]);
	}
	
	//Escolhe dialogo dos itens aleatoriamente
	public static void achaItem(String nomeItem) {
		int i = rand.nextInt(dialogoItem.length);
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
	    if (!Estados.getFlag("chegadaQuarto")) {  
	        Estados.setFlag("chegadaQuarto", true);  
	        System.out.println("\nVocê finalmente chega no local aonde você vai ficar...");
	        dialogoCliente_IntroHotel();  
	    } else {
	        System.out.println("\nÉ um apartamento pequeno e simples...");
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
			break;
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
		Estados.setFlag("dialogoquartoCompleto", true);
	}
	
	public static void PassagemTempo_Hora() {
		for (int i = 1; i <= 20; i++) {
			System.out.println("...");
		}
		
		System.out.print("18:00 - SEGUNDA-FEIRA\n");
	}
	
	public static void RuasDialogo() {

	    if (Estados.getFlag("dialogoquartoCompleto") && !Estados.getFlag("dialogoGarota_ruas")) {
	        Estados.setFlag("dialogoGarota_ruas", true);
	        Cenario.updtParqueOpcoes();
	        dialogoGarota();
	    }
	    
	    System.out.println("Os estreitos suburbios da Cidade estão agitados");
	}
	
	
	public static void dialogoGarota() {
		System.out.println("\nVocê sai do hotel e ouve ao fundo o som de crianças dando risadas no beco em que está."
				+ "\nTrês crianças sujas de carvão fazendo bullying com uma garota.");
		System.out.println("\nLíder valentão: 'Você é filha de uma bruxa. Você é o motivo de todos esses corpos nas ruas. "
				+ "\nNinguém quer você aqui!'");
		System.out.println("\nA garota está em lágrimas por baixo da sua máscara de gás. Pela sua estatura não deve ter mais de 12 anos, você resolve ajudar."
				+ "\nVocê se aproxima dos valentões esperando que sua presença fosse mais do que o suficiente para intimida-los, mas os garotos, "
				+ "\nusando máscaras, apenas o encaram de volta e desafiam o seu olhar antes de começarem a fazer um circulo em sua volta.");
		System.out.println("Líder valentão: 'O que você quer, estranho? Você tem algum envolvimento com essa filha de bruxa?'");
	        
		String escolha = "";
		while (!escolha.equals("3")) {  
			System.out.println("\n1 -> 'Por que estão fazendo bullying com essa garota?'");
			System.out.println("2 -> 'Você fala tanto que ela é filha de uma bruxa, o que quer dizer?'");
			System.out.println("3 -> 'Continuar'");
	        escolha = scanner.nextLine();
	        switch (escolha) {
	            case "1":
	                System.out.println("\nLíder valentão: 'Ela não é uma simples garota, é a filha de uma bruxa!'");
	                break;
	            case "2":
	                System.out.println("\nLíder valentão: 'Exatamente o que quer dizer, seu idiota, ela é filha de uma bruxa que jogou praga nessas terras.'");
	                break;
	            case "3":
	                System.out.println("...");
	                break;
	            default:
	                System.out.println("Digite uma escolha válida...");
	        }
	    }
		
		System.out.println("\nVocê não conseguirá nada desses rapazes além de pura superstição. Eles são garotos agindo como homens, mas ainda garotos. "
				+ "\nO melhor a se fazer é expulsar eles, mas… Como? Bater neles não é uma opção para você, mas eles com certeza estão cogitando.");
		System.out.println("\n1 -> Bater não é uma opção, mas intimidação física sempre funciona. [Atletismo]");
		System.out.println("2 ->" + Player.get().getNome() + ": 'Voltem para suas mamães ou trabalhem nas fábricas, muleques, talvez assim você vocês tragam menos decepção para suas famílias."
				+ " É patético demais ver vocês.' [Persuasão]");
		System.out.println("3 ->" + Player.get().getNome() + ": 'Muleques, vocês não querem se meter comigo. Um desconhecido, possivelmente perigoso, com bom humor o suficiente para dizer para vocês o seguinte. "
				+ "\nSumam daqui.'");
		System.out.println("4 ->Deixe eles te atacar, mas deixe a gravidade ganhar deles. [Malemolencia]");
		
		escolha = scanner.nextLine();
		switch (escolha) {
		case "1":
			System.out.println("\nVocê segura o líder valentão pela gola da camisa e o ergue no ar. "
					+ "\nNenhum dos garotos esperavam que um adulto sensato fizesse isso. Que bom que você não é. "
					+ "\nApós o recado dado sem dizer nada você larga o garoto. ");
			System.out.println("\nAtaque aumentou.");
			Player.get().incAtk();
			break;
		case "2":
			System.out.println("\nPersuasao aumentou.");
			Player.get().incPersu();
			break;
		case "3":
			System.out.println("...");
			break;
		case "4":
			System.out.println("\nO seu silêncio faz os garotos investirem contra você. "
					+ "\nVocê se esquiva, coloca a perna na frente deles e, como prometido, a gravidade vence a luta.");
			break;
		default:
			System.out.println("Digite uma escolha válida...");
		}
		
		System.out.println("\nOs garotos entram em lágrimas após sua reação e "
				+ "\nos dois capangas mirins fogem enquanto o líder valentão grita para você.");
		System.out.println("\nLíder valentão: 'Você vai ver uma só! Nós vamos nos vingar!'");
		
		System.out.println("\nSpoiler: eles não vão. Ao olhar para a garota, ela simplesmente foge como um gato assustado e some em meio aos subúrbios. "
				+ "\nTalvez você encontre ela novamente? Enfim, de volta ao trabalho, você precisa investigar o laboratório "
				+ "\nque teve o primeiro avistamento da doença de Mark Alighieri.");
		
	}
	
	public static void dialogoParque() {
		if (!Estados.getFlag("dialogoGarota_ruas")) {
			System.out.println("Preciso ir ao Hotel descansar...");
		}else {
			System.out.println("\nVoce ve pessoas com caminhar pesado indo de um lado ao outro.");
		}
	}
	
	public static void dialogoLab() {
		System.out.println("\nO laboratório é um prédio branco enorme altamente guardado. "
				+ "\nCâmeras de segurança então por todo o canto, guardas em patrulha, cargas indo e vindo. "
				+ "\nO local é mais bem cuidado que muitos bancos.");
	}
	
	public static void HotelDialogo() {
		System.out.println("Um hotel com aparencia antiga e decadente.");
	}
	
	
	//Acoes especias
	
	public static void dialogo_botanica() {
	    Estados.setFlag("dialogoLouca_1", true);
	    
	    System.out.println("\nPelo dia você ouviu falar de uma pessoa exótica chamada de 'curandeira', 'médica' ou apenas 'louca das plantas'. "
	            + "\nAo chegar no local você entende o porquê: uma estufa improvisada.");
	    System.out.println("\nO local é grande apesar de parecer pequeno por fora, mas sua beleza está na quantidade de plantas sendo cultivadas ali. "
	            + "\nA quantidade de verde é absurda. Ao andar pelo local, você encontra a mulher que tanto falam - uma pessoa de ~30 anos com "
	            + "\nroupas de jardinagem e um braço mecânico substituindo seu braço esquerdo. Ela finalmente te nota.");

	    System.out.println("\nGine: 'Oh.. ah! Um cliente! Desculpe a bagunça, eu estava plantando alguns vegetais... Bem, "
	            + "\nvendo se eles sobrevivem ao clima da cidade. Prazer, me chamo Gine, e você?'");
	    System.out.println("'Prazer, sou " + Player.get().getNome() + "'");
	    System.out.println("\nGine: 'Você não é daqui, não é? Conheceria alguém com sua... aura... "
	            + "\nSeja bem-vindo ao meu pedaço do paraíso! Não é muito, mas tudo é feito com carinho.'");

	    String escolha = "";
	    while (!escolha.equals("6")) {
	        System.out.println("\n1 -> 'Como você construiu esse lugar?'");
	        System.out.println("2 -> 'O que exatamente você faz aqui?'");
	        System.out.println("3 -> 'Minha... aura?'");
	        System.out.println("4 -> 'Sabe algo sobre a doença?'");
	        System.out.println("5 -> 'Conhece o farmacêutico Mark?'");
	        System.out.println("6 -> Sair");

	        escolha = scanner.nextLine();
	        switch(escolha) {
	            case "1":
	                System.out.println("\nGine: 'Ah! Bem, gastei minha vida toda nisso. "
	                        + "\nSempre foi meu sonho trabalhar com plantas... Pela primeira vez estou fazendo algo que amo.'");
	                break;
	                
	            case "2":
	                System.out.println("\nGine: 'Sou botânica. Estudo plantas, cultivo plantas, como plantas... "
	                        + "\nAté observo como elas se comunicam! Também faço medicamentos básicos com elas.'");
	                System.out.println("\nPlantas que se comunicam? Não à toa a chamam de louca... Mas uma louca útil.");
	                break;
	                
	            case "3":
	                System.out.println("\nGine: 'Sim! Você parece misterioso, como se escondesse segredos. "
	                        + "\nAté desconfio se seu nome é real... Brincadeirinha, senhor!'");
	                break;
	                
	            case "4":
	                System.out.println("\nGine: 'Sei os sintomas: olhos vermelhos, pele manchada, suor excessivo antes da morte... "
	                        + "\nChamam de 'Febre da Engrenagem'. As pessoas vêm atrás de milagres, mas só posso oferecer paliativos... "
	                        + "\nPrecisaria saber a causa para algo melhor.'");
	                break;
	                
	            case "5":
	                if (Estados.getFlag("permissao_botanica")) {
	                    System.out.println("\nGine: 'Já falamos sobre isso, lembra? Você vai entregar minhas plantas pra ele.'");
	                    break;
	                }
	                
	                System.out.println("\nGine: 'Pessoalmente? Não, só trabalho profissionalmente. Ele compra plantas para seus laboratórios.'");
	                System.out.println("\nEla fornece plantas para Mark? Isso pode ser útil...");
	                System.out.println("\n1 -> 'Eu poderia entregar para você' [Persuasão]");
	                System.out.println("2 -> Melhor não se meter");
	                
	                escolha = scanner.nextLine();
	                switch(escolha) {
	                    case "1":
	                        if (Utils.rollPersuasao(Player.get().getPersuasao())) {
	                            System.out.println("\n[SUCESSO] Gine: 'Sério? Não se incomodaria? Detesto ir àquele lugar branco e estéril... "
	                                    + "\nPrefiro ficar aqui com minhas plantas.'");
	                            Estados.setFlag("permissao_botanica", true);
	                        } else {
	                            System.out.println("\n[FALHA] Gine: 'Obrigada, mas... melhor eu entregar pessoalmente. Não quero mal-entendidos.'");
	                        }
	                        break;
	                        
	                    case "2":
	                        System.out.println("\nVocê decide não se arriscar");
	                        break;
	                        
	                    default:
	                        System.out.println("\nOpção inválida.");
	                }
	                break;
	                
	            case "6":
	                System.out.println("\n'Obrigado pela conversa, Gine. Preciso ir.'");
	                break;
	                
	            default:
	                System.out.println("\nEscolha uma opção válida.");
	        }
	    }


	    System.out.println("\nAo sair, Gine corre atrás de você:");
	    System.out.println("\nGine: 'Espere! Se descobrir algo sobre plantas ou a doença... me avise? Quero ajudar essas pessoas.'");
	    System.out.println("\n(Você concorda, deixando-a esperançosa. Seu braço mecânico mostra que ela já foi uma delas.)");
	}
	
	
	
	/////////******************************///////////////////////
	
	
	
	public static void observar_parque() {
		
		System.out.println("\nUm parque esdruxulo. Não parece estar muito bem cuidado...");
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

	public static void dormir_Apt() {
	    System.out.println("Você dorme por algumas horas...");
	    
	    // Verifica se posso utilizar o diretorio
	    Path saveDir = Paths.get(System.getProperty("user.home"), ".seujogo");
	    if (!canWriteToDirectory(saveDir)) {
	        System.out.println("AVISO CRÍTICO: Não é possível escrever no diretório de save!");
	        System.out.println("Local: " + saveDir);
	        System.out.println("Por favor:");
	        System.out.println("1. Verifique as permissões da pasta");
	        System.out.println("2. Desative temporariamente o antivírus");
	        return;
	    }
	    
	    GameSave.salvarJogo();
	    
	    // Verifica save
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
	

}
