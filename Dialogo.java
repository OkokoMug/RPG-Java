import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
	        System.out.println("\nVocê finalmente chega no local aonde você vai ficar...");
	        dialogoCliente_IntroHotel();
	        Estados.setFlag("chegadaQuarto", true);
	    } else {
	        System.out.println("\nÉ um apartamento pequeno e simples..."); 
	    }


	    if (Estados.getFlag("documentos_markOk") && !Estados.getFlag("garotaNoApt")) {
	        System.out.println("\nMas algo está diferente..."); 
	        encontroGarotaApt(); 
	    }
	    
	    if (Estados.getFlag("conheceu_Lua") && 
	       Estados.getFlag("Cap2_inicio") && 
	       !Estados.getFlag("dialogoLuaCap2Apt_mostrado")) {
	        dialogoLuaCap2();
	    }
	}
	
	private static void encontroGarotaApt() {
	    Estados.setFlag("garotaNoApt", true);
	    
	    System.out.println("\nVocê finalmente chegou no seu apartamento. Porta rangendo. Rato. Goteira. Você já sabe como é.");
	    System.out.println("Você está prestes a ligar o filtrador quando percebe a janela aberta. Você deixou ela aberta?");
	    System.out.println("Você fecha a janela e seu corpo entra em estado de alerta - alguém entrou aqui.");
	    System.out.println("\nFamília Alighieri? Arasaka? O cliente lhe traiu?");
	    System.out.println("Sua mente entra em um turbilhão de possibilidades...");
	    
	    try { 
	    	Thread.sleep(1500); 
	    	} catch (InterruptedException e) {}
	    
	    System.out.println("\nA maçaneta do banheiro gira lentamente.");
	    
	    try { 
	    	Thread.sleep(1000); 
	    	} catch (InterruptedException e) {}
	    
	    System.out.println("Você se prepara para o pior, mãos firmes...");
	    
	    try { 
	    	Thread.sleep(1000); 
	    	} catch (InterruptedException e) {}
	    
	    System.out.println("\nA porta se abre - e revela... uma criança?");
	    System.out.println("Você e a garota se encaram em silêncio por um momento eterno.");
	    System.out.println("Seus músculos relaxam gradualmente, mas sua mente ainda está em alerta.");
	    
	    System.out.println("\nEla parece ter não mais que 10 anos:");
	    System.out.println("- Estatura pequena, sinais de subnutrição");
	    System.out.println("- Cabelo longo e castanho, sujo de fuligem");
	    System.out.println("- Veste um macacão industrial grande demais");
	    System.out.println("- Máscara de gás infantil desgastada");
	    System.out.println("\nVocê a reconhece - é a mesma garota do beco mais cedo.");
	    
	    System.out.println("\nApós um silêncio tenso, ela finalmente fala:");
	    System.out.println("Garota: ‘Você não é um invasor. "
	    		+ "\nVocê é o salvador de Lua, Lua grata e Lua proteger casa. Fique a vontade.’");
	    
	    System.out.println("\nOk, ela abrir a boca só parece deixar a situação mais confusa e inusitada. "
	    		+ "\nVocê liga o filtrador para pensar melhor. Alguns questionamentos devem serem feitos. ");
	    
	    System.out.println("\n1 -> 'Quem é você, pequena?'");
	    System.out.println("2 -> 'O que você está fazendo aqui?'");
	    System.out.println("3 -> 'Onde estão seus pais?'");
	    System.out.println("4 -> 'De manhã, ouvi os garotos chamando você de \"filha de bruxa\", porque?'");
	    System.out.println("5 -> Continuar");

	    String escolha = "";
	    while (!escolha.equals("5")) {  
	        escolha = scanner.nextLine();
	        
	        if (escolha.equals("1")) {
	            System.out.println("\n'Lua é Lua.'");
	        } 
	        else if (escolha.equals("2")) {
	            System.out.println("\nGarota: 'Lua proteger casa de homens maus.'");
	        }
	        else if (escolha.equals("3")) {
	            System.out.println("\nGarota: 'Lua não sabe, Lua procura, mas mamãe, puuuf, sumiu.'");
	        }
	        else if (escolha.equals("4")) {
	            System.out.println("\nA garota parece ter se irritado com a pergunta, ou melhor, pela lembrança.");
	            System.out.println("Ela abaixa a cabeça, enquanto olha nos seus olhos de forma tímida antes de falar.");
	            System.out.println("\n'Porque mamãe de Lua era inteligente e eles são burros.'");
	        }
	        else if (escolha.equals("5")) {
	            System.out.println("\nVocê decide mudar de assunto...");
	            break; 
	        }
	        else {
	            System.out.println("\nOpção inválida. Escolha de 1 a 5.");
	        }

	        if (!escolha.equals("5")) {
	            System.out.println("\nO que mais você quer perguntar?");
	            System.out.println("1 -> 'Quem é você, pequena?'");
	            System.out.println("2 -> 'O que você está fazendo aqui?'");
	            System.out.println("3 -> 'Onde estão seus pais?'");
	            System.out.println("4 -> 'De manhã, ouvi os garotos chamando você de \"filha de bruxa\", porque?'");
	            System.out.println("5 -> Continuar");
	        }
	    }
	    
	    System.out.println("\nA criança, aparentemente chamada de “Lua”, sua mãe está desaparecia e ela tem sofrido bullying "
    			+ "\npor causa de “Bruxaria” da mesma. Além disso, ela invadiu sua casa querendo lhe recompensar “protegendo” sua casa. "
    			+ "\nA realidade é mais dura do que isso, a garota é órfã e só não tem aonde ir, talvez você tenha sido a única pessoa a ajuda-la nesse tempo. "
    			+ "\nVocê agora não só deve cuidar da criança, mas saber o porquê dessas caça as bruxas com ela. "
    			+ "\nVocê em silêncio vai em direção ao banheiro, a garota fica com medo da sua aproximação ser uma possível expulsão dela, mas… "
    			+ "\nVocê só quer tomar banho. As paredes não são nem um pouco grossa, então você conegue ouvir Lua falando enquanto toma banho.");
    	
	    System.out.println("\nLua: 'Lua vai ficar com homem forte e assutador, ai Lua vai aprender a ser forte e assutadora, ai Lua vai assustar os homens maus igual "
    			+ "\no homem forte e assustador! "
    			+ "\nLua vai ser a mulher mais forte do mundo!'");
    	System.out.println("\nO resto do que você ouve é uma sequência de socos e chutes encenados pela garota. Você vai ter que cuidar dela pelo visto. "
    			+ "\nAo sair do banheiro já vestido e sem sua máscara, você prepara uma refeição básica para você e a sua nova residente antes de "
    			+ "\nse sentar na cama e conversar com ela mais.");
    	System.out.println("\n'Prazer em conhece-la, Lua, me chamo " + Player.get().getNome() + ". Você pode ficar aqui. "
    			+ "\nEu preciso de alguém que cuide da minha casa enquanto estiver fora");
    	System.out.println("\nA garota está ainda usando sua máscara mesmo com o filtrado ligado. Ela come colocando a comida debaixo da máscara, "
    			+ "\ne parece estar adorando mesmo sendo algo simples. Ela fala de boca cheia.");
    	System.out.println("Lua: 'Lua vai cuidar! Enquanto " + Player.get().getNome()+ "estiver fora, Lua cuida! Lua não ser forte, mas ser inteligente. "
    			+ "\nMamãe dizia isso.'");
    	System.out.println("\nVocê não conseguirá nenhuma informação vindo dela. Talvez com o tempo? No momento, ela está claramente faminta e cansada. "
    			+ "\nUm banho deve ser dado a ela de manhã, e voce deve escolher onde dormir. Hoje você não ficará no colchão velho e sim no chão úmido.");
    	
    	System.out.println("\n'Lua, porque você não tira a máscara?'");
    	System.out.println("\nLua:'Mamãe disse que Lua não respira sem a máscara. Lua precisa respirar.'");
    	System.out.println("\n'Mas há filtradores pela casa, está tudo bem.'");
    	System.out.println("\nLua: 'O que é isso?'");
    	System.out.println("\n'É o que me permite respirar sem a máscara. Não vê que estou sem? Você também pode, Lua, só tentar.'");
    	
    	System.out.println("\nA garota para sua refeição para pensar no que você disse e, após um pequeno momento, "
    			+ "\nela pega a máscara e coloca apenas merade do rosto para fora. Agora é visível seus olhos curiosos e perdidos, "
    			+ "\nalém de um sorriso sincero pela situação, mas parece não querer tirar a máscara por costume.");
    	System.out.println("\nLua: 'Hehe, mestre ensinou Lua a respirar sem máscara'");
    	System.out.println("\n'Mestre? Eu não te ensinei a respirar sem, quando estiver do lado de fora deve vestir novamente.'");
    	System.out.println("\nLua: 'Sim! Você ser mestre de Lua! Não precia ensinar, Lua aprende sozinha vendo mestre. "
    			+ "Lua inteligente, se lembre.'");
    	System.out.println("\n'Me lembrarei, Lua…'");
    	
    	System.out.println("\nA refeição enfim termina. Lua insiste em ficar acordada para “vigia noturna”, mas suas insistências e "
    			+ "\na refeição enfim deram sono a ela. Ela dormiu no colchão e logo em seguida você também dormiu, no chão.");
    	
    	GameSave.salvarJogo();
    	PassagemTempo_Hora();
	    Estados.setFlag("conheceu_Lua", true);
	    Estados.setFlag("Cap2_inicio",true);
	}
	
	public static void dialogoLuaCap2() {
	    System.out.println("\nVocê finalmente está pronto para mais um dia de trabalho.");
	    System.out.println("Lua está alimentada, tomou um banho apesar da resistência,");
	    System.out.println("e agora está assistindo na TV velha do apartamento, ainda com metade da máscara.");
	    System.out.println("Está na hora de ir.\n");
	    
	    System.out.println("Ao tentar sair...");
	    System.out.println("Lua: 'Onde está indo, mestre?'");
	    System.out.println("'Já falei para não me chamar de mestre, Lua. E estou saindo a trabalho.'");
	    System.out.println("Lua: 'Lua pode ir junta?! Lua quer aprender.'");
	    System.out.println("'Talvez em outro momento, mas não agora. Irei conversar com pessoas importantes. Você deve ficar aqui.'");
	    System.out.println("Ela faz um bico de birra, mas assente com sua ordem.");
	    
	    Estados.setFlag("dialogoLuaCap2Apt_mostrado", true);
	}
	
	//Dialogo confronto mark
	public static void confrontoMark() {

		System.out.print("\033[H\033[2J");
		System.out.flush();


		System.out.println("\nVocê está no átrio do laboratório. Sua visita era mais do que esperada.");
		System.out.println("Os guardas permitem sua entrada e o seguem logo atrás de você.");
		System.out.println("Finalmente você adentra no escritório do senhor Mark Alighieri. O confronto será agora.\n");

		System.out.println("Você está de frente a frente com o senhor Mark. Ele não está usando sua máscara,");
		System.out.println("então você também retira a sua em sinal de respeito e vocês dois finalmente se olham cara a cara.\n");

		System.out.println("Mark aparenta sinais de velhice no rosto, cabelo grisalho mas sem sinais de calvície,");
		System.out.println("seu rosto velho não demonstra cansaço e seu olhar parece julgar cada movimento seu.");
		System.out.println("Ele usa um terno social sob medida e seu corpo não parece demonstrar sinais de fraqueza.\n");

		System.out.println("Mark: 'Sabe, achei curioso quando encontrei esta moeda na minha mesa.'");
		System.out.println("'Tenho diversas na minha conta, mas essa em particular me chamou a atenção,'");
		System.out.println("'principalmente quando descubro que tenho um invasor.'");
		System.out.println("'Me diga, " + Player.get().getNome() + ", o que você procura chamando minha atenção?'");
		System.out.println("'Espero que seja um bom motivo.'\n");

		System.out.println("Ele sabe seu nome sem nem mesmo você falar para ele. Ele fez seu dever de casa.");
		System.out.println("As escolhas de palavras devem ser feitas com sabedoria. Ele parece complacente agora,");
		System.out.println("mas não por muito tempo.");

		String escolha = "";
		while (!escolha.equals("4")) {
		    System.out.println("\n1 -> 'Perdoe-me pela invasão, estou aqui para investigar a doença'");
		    System.out.println("2 -> 'Gostaria de falar um pouco sobre a Arasaka...'");
		    System.out.println("3 -> 'Gostaria de falar um pouco sobre a Doença em si...'");
		    System.out.println("4 -> 'Continuar'");
		    
		    escolha = scanner.nextLine();
		    
		    switch (escolha) {
		        case "1":
		            InvestigacaoOpcoes();
		            break;
		        case "2":
		            ArasakaOpcoes();
		            break;
		        case "3":
		            DoencaOpcoes();
		            break;
		        case "4":
		            System.out.println("\nVocê decide mudar de abordagem...");
		            break;
		        default:
		            System.out.println("Digite uma escolha válida...");
		    }
		}

		System.out.println("\nVocê pega sua máscara e antes de sair do escritório, você ouve Mark falando:");
		System.out.println("MARK: 'Detetive, por favor, aceite isso como um gesto amigável.'");
		System.out.println("Uma maçã. Uma política da empresa entregar maçãs para visitantes e funcionários.");

		Estados.setFlag("confrontoMark_feito", true);

		}

		private static void InvestigacaoOpcoes() {
		System.out.println("\nMARK: 'E você veio investigar onde esteve o primeiro relato.'");
		System.out.println("'De fato foi nessas instalações, sou suspeito de ser culpado, detetive?'");


		System.out.println("\n1 -> 'Sim, você é.'");
		System.out.println("2 -> 'Não, você não é.'");
		System.out.println("3 -> 'Ainda é cedo demais para julgar.'");

		String escolha = scanner.nextLine();
		switch (escolha) {
		    case "1":
		        System.out.println("\nEle ri para sua resposta antes de responder.");
		        System.out.println("MARK: 'Pelo menos é sincero.'");
		        break;
		    case "2":
		        System.out.println("\nEle parece surpreso com sua resposta, mas rapidamente retoma a compostura.");
		        System.out.println("MARK: 'Fico feliz que saiba reconhecer um homem inocente quando vê um.'");
		        break;
		    case "3":
		        System.out.println("\nSua resposta parece ter desagradado ele.");
		        System.out.println("MARK: 'Indeciso, detetive? Ou apenas com medo de ser sincero comigo?'");
		        break;
		    default:
		        System.out.println("Faça uma escolha válida...");
		}
		

		}

		public static void ArasakaOpcoes() {
		System.out.println("\nMARK: 'Ah, deixa eu imaginar, seu segundo suspeito? Terei o prazer de queimar a reputação deles.'");
		System.out.println("Um sorriso sádico aparece no rosto dele.");

		System.out.println("\n1 -> 'O que você sabe do chefe da família Arasaka?'");
		System.out.println("2 -> 'Acha que a doença foi, de alguma forma, causada por eles?'");

		String escolha = scanner.nextLine();
		switch (escolha) {
		    case "1":
		        System.out.println("\nMARK: 'Não sei mais do que você sabe, mas acho estranho seu repentino sumiço");
		        System.out.println("após o aparecimento da doença. Uma coincidência, não?'");
		        System.out.println("Ele não estava brincando quando disse que queria difamá-los.");
		        break;
		    case "2":
		        System.out.println("\nMARK: 'É óbvio, não me surpreenda que uma doença desconhecida nasça");
		        System.out.println("naquelas condições insalubres. Aqui temos equipamento adequado para lidar com tudo.'");
		        System.out.println("Sujo falando do mal lavado...");
		        break;
		    default:
		        System.out.println("Faça uma escolha válida...");
		}

		}

		public static void DoencaOpcoes() {
		System.out.println("\nMARK: 'Ah, claro, o tópico mais importante e o motivo da sua presença.'");
		System.out.println("'Por que deveria respondê-lo? Não sei qual a origem da doença,'");
		System.out.println("'mas se tivesse origem aqui seria um problema para minha imagem.'");
		System.out.println("'Por que deveria colaborar, detetive?'");

		System.out.println("\nEle não está completamente contra compartilhar informações,");
		System.out.println("apenas está testando você. Escolher a resposta certa é crucial.");

		String escolha = "";
		while (!escolha.equals("4")) {
		    System.out.println("\n1 -> Ajudar as pessoas");
		    System.out.println("2 -> Queimar a família Arasaka");
		    System.out.println("3 -> Mencione a família dele e o risco");
		    System.out.println("4 -> Continuar");
		    
		    escolha = scanner.nextLine();
		    
		    switch (escolha) {
		        case "1":
		            if (!Estados.getFlag("escolha_alig_Ajudar")) {
		                Estados.setFlag("escolha_alig_Ajudar", true);
		                System.out.println("\nMARK: 'Não somos uma instituição de caridade, detetive.'");
		            } else {
		                System.out.println("Ele menospreza sua resposta. Você não conseguirá nada sobre a doença assim.");
		            }
		            break;
		        case "2":
		            if (!Estados.getFlag("escolha_alig_Queimar")) {
		                Estados.setFlag("escolha_alig_Queimar", true);
		                System.out.println("\nMARK: 'De fato é interessante sua ideia, mas...'");
		                System.out.println("'Isso não torna toda a investigação sem sentido?'");
		                System.out.println("'Ou pretendia me fazer de tolo?'");
		            } else {
		                System.out.println("Você parece ter ofendido ele. Não foi a resposta mais inteligente.");
		            }
		            break;
		        case "3":
		            FamiliaApelo();
		            break;
		        case "4":
		            break;
		        default:
		            System.out.println("Faça uma escolha válida.");
		    }
		}

		}

		public static void FamiliaApelo() {
		if (!Estados.getFlag("escolha_alig_Familia")) {
		Estados.setFlag("escolha_alig_Familia", true);
		System.out.println("\nMark fica com expressão séria ao mencionar a família.");
		System.out.println("MARK: 'Continue, detetive, mas meça suas palavras com cuidado.'");
		System.out.println("\nVocê deve apelar para sua filha doente, mas... qual era o nome dela?");

		    System.out.println("\n1 -> Amanda");
		    System.out.println("2 -> Michele");
		    System.out.println("3 -> Julia");
		    System.out.println("4 -> Apele para a família toda [Persuasão]");
		    
		    String escolha = scanner.nextLine();
		    switch (escolha) {
		        case "1":
		            System.out.println("\nMARK: 'Minha esposa está segura em casa longe dessa infecção.'");
		            System.out.println("'Por favor, detetive, se retire antes que eu o faça.'");
		            break;
		        case "2":
		            System.out.println("\nMARK: 'Minha filha e sucessora está mais do que ciente.'");
		            System.out.println("'Ela é jovem e saudável, essa doença não chegará nela.'");
		            break;
		        case "3":
		            System.out.println("\nMARK: 'Você!..'");
		            System.out.println("\nEle se levanta em revolta pela menção de sua filha doente.");
		            System.out.println("Ele se senta novamente, com raiva visível em seu olhar.");
		            System.out.println("MARK: 'Você sabe que ela é a mais vulnerável.'");
		            System.out.println("'Seja racional e me ajude na investigação.'");
		            System.out.println("\nEle dá uma pausa antes de continuar:");
		            System.out.println("MARK: 'Pergunte o que quiser.'");
		            perguntas_mark_sucesso();
		            break;
		        case "4":
		            if (!Estados.getFlag("mark_apelaFamilia")) {
		                Estados.setFlag("mark_apelaFamilia", true);
		                if (Utils.rollPersuasao(Player.get().getPersuasao())) {
		                    System.out.println("\n[SUCESSO] MARK parece ter sido atingido por suas palavras.");
		                    System.out.println("MARK: 'Prossiga com suas perguntas, detetive.'");
		                    
		                    perguntas_mark_sucesso();
		                } else {
		                    System.out.println("\n[FALHA] MARK ri da sua tentativa de convencê-lo.");
		                    System.out.println("MARK: 'O problema dos proletários não chegará nas castas mais altas.'");
		                    System.out.println("'Agora pare de desperdiçar meu tempo.'");
		                }
		            } else {
		                System.out.println("\nEle parece ter visto você como um inútil.");
		                System.out.println("Você não conseguirá mais nada dele e resolve ir embora.");
		            }
		            break;
		        default:
		            System.out.println("Faça uma escolha válida.");
		    }
		}


		}
		
		public static void perguntas_mark_sucesso() {
	        System.out.println("\n1 -> 'Qual a origem da doença?'");
	        System.out.println("2 -> 'O que fez quando descobriu a doença?'");
	        System.out.println("3 -> 'Por que o nome “Febre da engrenagem” e “peste cardíaca”?'");
	        System.out.println("4 -> 'Acha que a origem possa ter sido no laboratório?'");
	        System.out.println("5 -> 'Como foi o contágio?'");
	        System.out.println("6 -> Sair");

	        String escolha = "";
	        while (!escolha.equals("6")) {
	            escolha = scanner.nextLine();
	            switch(escolha) {
	                case "1":
	                    System.out.println("\nMark: 'Como dito anteriormente, não sabemos e nem temos ideia. A doença só apareceu do nada e matou diversos dos meus homens.'");
	                    break;
	                case "2":
	                    System.out.println("\nMark: 'Tentamos isolar os infectados para estudo, mas já era tarde demais e saiu do controle. Priorizamos manter os nossos acima de tudo.'");
	                    break;
	                case "3":
	                    System.out.println("\nMark: '“Peste cardíaca” porque o último estágio é marcado por aceleração do coração, que já declara a morte do infectado."
	                            + "\n“Febre da engrenagem” é o nome popular, pois o coração se torna semelhante a um pistão instável.'");
	                    break;
	                case "4":
	                    System.out.println("\nMark: 'Sou suspeito para dizer, detetive, mas diria que é improvável. Principalmente uma infecção dessa escala — teríamos notado nos seus estágios iniciais.'");
	                    break;
	                case "5":
	                    System.out.println("\nMark: 'Foi… curioso, no mínimo. Mesmo isolando os infectados, começaram a aparecer casos em meio às ruas e, de repente, estava fora de controle."
	                            + "\nÉ difícil dizer como funciona a transmissão.'");
	                    break;
	                case "6":
	                    System.out.println("\nVocê encerrou a conversa com Mark.");
	                    break;
	                default:
	                    System.out.println("\nFaça uma escolha válida.");
	            	}
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
		System.out.println("\nAs horas passam...");
	    for (int i = 0; i < 3; i++) {
	        System.out.print(".");
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	    
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
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
	
	public static void dialogoLabPrincipal() {
		System.out.println("\nPessoas vestidas em jalecos caminham de um lado ao outro com passos apressados.");
	}
	
	public static void dialogoLabFundos() {
		System.out.println("\nVoce ve alguns funcionarios fumando, mas nenhum segurança...");
	}
	
	public static void dialogoLabArmazem() {
		System.out.println("\nVoce ve caixas empilhadas e há uma porta para entrada de funcionarios.");
	}
	
	public static void dialogoLab() {
		System.out.println("\nO laboratório é um prédio branco enorme altamente guardado. "
				+ "\nCâmeras de segurança então por todo o canto, guardas em patrulha, cargas indo e vindo. "
				+ "\nO local é mais bem cuidado que muitos bancos.");
		
		if (!Estados.getFlag("dialogoLouca_1")) {
			System.out.println("\nSeria melhor dar uma olhada no Parque");
		}
	}
	
	public static void HotelDialogo() {
		System.out.println("Um hotel com aparencia antiga e decadente.");
	}
	
	public static void dialogo_botanica() {
	    Estados.setFlag("dialogoLouca_1", true);
	    Cenario.updtLabOpcoes();
	    
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
	                
	                System.out.println("\nGine: 'Pessoalmente? Não, só trabalho profissionalmente. Ele compra plantas para seus laboratórios.'");
	                System.out.println("\nEla fornece plantas para Mark? Isso pode ser útil...");
	                System.out.println("\n1 -> 'Eu poderia entregar para você' [Persuasão]");
	                System.out.println("2 -> Melhor não se meter");
	                
	                escolha = scanner.nextLine();
	                switch(escolha) {
	                    case "1":
	                    	
	                    	if (Estados.getFlag("permissao_botanica")) {
	    	                    System.out.println("\nGine: 'Já falamos sobre isso, lembra? Você vai entregar minhas plantas pra ele.'");
	    	                    break;
	    	                }
	                    	
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
	    System.out.println("\nVocê concorda, deixando-a esperançosa. Seu braço mecânico mostra que ela já foi uma delas.");
	}
	
	
	
	public static void dialogoElevador() {
		System.out.println("\nVoce se aproxima do elevador");
		if (!Estados.getFlag("permissao_botanica")) {
			System.out.println("Um segurança aparece, e o questiona.");
			System.out.println("\n'Voce não possui uma permissao. Saia imediatamente.'");
			System.out.println("\n1 -> 'Eu tenho permissão sim, mas eu esqueci minha credencial...' [Persuasão]");
	        System.out.println("2 -> Atordoar o segurança. [Atletismo]");
	        System.out.println("3 -> Voltar.");
	        
	        String escolha = scanner.nextLine();
	        switch(escolha) {
	            case "1": 
	                if (Utils.rollPersuasao(Player.get().getPersuasao())) {
	                    System.out.println("\n[SUCESSO] Você mostra um papel qualquer com confiança."
	                        + "\nSEGURANÇA: 'Hmm... tudo bem, pode passar. Nunca vi esse rosto antes...'");
	                    Estados.setFlag("elevador_acesso", true);
	                } else {
	                    System.out.println("\n[FALHA] Segurança: 'Isso é claramente falso. So saia daqui e não me encha a paciencia.'");
	                }
	                break;
	                
	            case "2": 
	                if (Utils.rollAtletismo(Player.get().getAtk())) {
	                    System.out.println("\n[SUCESSO] Você atordoa o segurança com um golpe preciso."
	                        + "\nVoce esconde seu corpo adormecido em um canto.");
	                    Estados.setFlag("elevador_acesso", true);
	                } else {
	                    System.out.println("\n[FALHA] O segurança desvia e te imobiliza!"
	                        + "\nSEGURANÇA: 'Patético. Vá embora daqui, seu rufião!'");
	                }
	                break;
	                
	            case "3":
	            	System.out.println("\nVocê recua calmamente. Melhor não arriscar.");
	            	break;
	            	
	            default:
	            	System.out.println("\nOpção inválida!");
	        	}
	        
			} else {
			System.out.println("\n'Ouvi que a Gina não pode entregar as flores hoje.'"
	            + "\nSegurança: Ele acena com a cabeça. 'Pode passar, entregador.'");
				}
		
	}
	
	public static void dialogoEscritorio() {
		
		System.out.println("\nO escritorio tem uma porta de carvalho escuro talhado nos mais perfeitos detalhes.");
		
		if (!Estados.getDocumentos_markOk()) {
		System.out.println("\nVocê entra finalmente no escritório dele, é um local com baixa segurança levando em consideração o lado de fora. "
				+ "\nVocê começa a vasculhar seus pertences, sua escrivaninha, seus livros, até mesmo sua coleção de vinhos caros, "
				+ "\naté que você acha escondido embaixo do piso de madeira uma pilha de documentos. Clássico. "
				+ "\nOs documentos são variados, desde inimigos corporativos, escândalos políticos, mas seu foco aqui é no próprio Mark e na doença. "
				+ "\nNovamente, você precisa ser rápido.");
		}
	}
	
	public static void documentos_mark() {
	    System.out.println("\nVocê encontra documentos confidenciais sobre Mark Alighieri:");
	    

	    Map<Integer, String> topicos = new LinkedHashMap<>();
	    topicos.put(1, "- Mark");
	    topicos.put(2, "- Família");
	    topicos.put(3, "- Doença");
	    topicos.put(4, "- Empresa");
	    topicos.put(5, "- Arasaka");
	    
	    List<Integer> topicosDisponiveis = new ArrayList<>(topicos.keySet());
	    Collections.shuffle(topicosDisponiveis);
	    topicosDisponiveis = topicosDisponiveis.subList(0, 3);
	    

	    topicosDisponiveis.add(6); 
	    
	    String escolha = "";
	    int escolhasFeitas = 0;
	    boolean readAll = false;
	    
	    while (escolhasFeitas < 3 && !escolha.equals("0")) {
	        System.out.println("\nEscolha um tópico (ou 0 para sair):");
	        
	        // Show available topics
	        for (Integer topicId : topicosDisponiveis) {
	            if (topicId == 6) {
	                System.out.println("6 -> Arrisque uma leitura rápida [Lógica]");
	            } else {
	                System.out.println(topicId + " -> " + topicos.get(topicId));
	            }
	        }
	        
	        escolha = scanner.nextLine();
	        
	        switch(escolha) {
	            case "1":
	                System.out.println("\nMark Alighieri: Considerado o pai da medicina moderna. Dono de um conglomerado farmacêutico."
	                    + "\nPoucas aparições públicas revelam um homem apático às condições do mundo.");
	                topicosDisponiveis.remove(Integer.valueOf(1));
	                escolhasFeitas++;
	                break;
	                
	            case "2":
	                System.out.println("\nFamília:"
	                    + "\n- Amanda Alighieri: Esposa e braço direito, mais empática"
	                    + "\n- Michelle Alighieri: Filha mais velha, abordagem propagandista"
	                    + "\n- Julia Alighieri: Filha mais nova, isolada por problemas de saúde");
	                topicosDisponiveis.remove(Integer.valueOf(2));
	                escolhasFeitas++;
	                break;
	                
	            case "3":
	                System.out.println("\nDoença (Febre da Engrenagem/Peste Cardíaca):"
	                    + "\nFase 1: Fadiga, olhos vermelhos, suor metálico"
	                    + "\nFase 2: Manchas acinzentadas, dores articulares"
	                    + "\nFase 3: Aceleração cardíaca, colapso neurológico, morte");
	                topicosDisponiveis.remove(Integer.valueOf(3));
	                escolhasFeitas++;
	                break;
	                
	            case "4":
	                System.out.println("\nEmpresa:"
	                    + "\nIniciou com valores solidários, mas tornou-se gananciosa"
	                    + "\nCria soluções temporárias para problemas industriais"
	                    + "\nSuspeita de criar problemas para vender soluções");
	                topicosDisponiveis.remove(Integer.valueOf(4));
	                escolhasFeitas++;
	                break;
	                
	            case "5":
	                System.out.println("\nArasaka:"
	                    + "\nRival simbiótico - maltrata funcionários que depois usam remédios Alighieri"
	                    + "\nChefe da família recentemente ausente"
	                    + "\nPossível conluio sombrio entre as corporações");
	                topicosDisponiveis.remove(Integer.valueOf(5));
	                escolhasFeitas++;
	                break;
	                
	            case "6":
	                if (Utils.rollLogica(Player.get().getLogica())) {
	                    System.out.println("\n[SUCESSO] Você rapidamente escaneia todos os documentos!");
	                    readAll = true;
	                    escolhasFeitas = 3; 
	                } else {
	                    System.out.println("\n[FALHA] Não há tempo suficiente para ler tudo cuidadosamente!");
	                    topicosDisponiveis.remove(Integer.valueOf(6)); 
	                }
	                break;
	                
	            case "0":
	                System.out.println("\nVocê decide sair antes de ser pego...");
	                break;
	                
	            default:
	                System.out.println("\nTópico inválido!");
	        }
	    }
	    
	    System.out.println("\nO tempo acabou. Você deve sair antes que os guardas cheguem.");
	    if (readAll) {
	        System.out.println("\n(Você conseguiu absorver todas as informações importantes)");
	    } else {
	        System.out.println("\n(Você só conseguiu partes da informação)");
	    }
	    
	    System.out.println("\nVocê deixa uma moeda de despedida na mesa - um convite indireto para Mark."
	        + "\nAmanhã, você o confrontará pessoalmente...");
	    
	    System.out.println("\nVoce deveria volar para o apartamento.");
	    
	    Estados.setFlag("documentos_markOk",true);
	}
	
	
	
	public static void dialogoMaxAndar() {
		System.out.println("\nO piso e as paredes estão cobertas em mármore e há peças de arte em estantes.");
	}
	
	public static void dialogoEscadas() {
		System.out.println("\nAs escadas de emergencia se estendem alto ate onde o breu consome toda a luz.");
	}
	
	public static void dialogoCorredores() {
		System.out.println("\nOs corredores se encontram cheios de caixas, jogadas ao aleatorio em sua extensão.");
	}
	
	public static void observar_fundos() {
		System.out.println("Surpreendentemente, não há nenhum seguraça. A porta parece estar destrancada.");
	}
	
	public static void observarArmazem() {
		System.out.println("\nÉ um armazem um tanto quanto cheio. Voce consegue identificar diferentes substancias nos rotulos das caixas.");
	}
	
	public static void observar_corredores() {
		System.out.println("\nOs corredores estão escuros e extintos de qualquer forma de vida.");
	}
	
	
	public static void observar_labAtrio() {
		System.out.println("\nOs funcionarios estão apressados e com rostos serios.");
	}
	
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
