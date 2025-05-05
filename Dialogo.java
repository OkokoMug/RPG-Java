import java.util.Random;

public class Dialogo {
	
    private static boolean introCap1Mostrada = false;
    private static boolean introChegadaMostrada = false;
    private static boolean selectEspecMostrada = false;
	
	//Dialogos historia
	//Capitulo 1
	//Introdução
	
	public static void introCap1() {
		
		if (!introCap1Mostrada) {
	
		introCap1Mostrada = true;
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
				+ "\ndescobrir a origem da praga e expor os culpados — antes que a própria Cidade o engula também."
				+ "\nEntretanto, para um trabalho difícil e misterioso como esse, voce precisara de um novo nome: ");}
		
	}
	
	//Intro cidade
	
	public static void introChegadaCidade() {
		if (!introChegadaMostrada) {
			introChegadaMostrada = true;
		System.out.println("\nSendo assim...");
		System.out.println("\nA viagem até a Cidade não é longa, porém voce se sente exaurido.\n"+
						"Seja por conta das vibrações do trem, ou pela completa ausencia de qualquer verde pela janela...");}
	}
	
	//Seleção de especialização
	public static void selectEspec() {
		
		if (!selectEspecMostrada) {
			
		selectEspecMostrada = true;
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
