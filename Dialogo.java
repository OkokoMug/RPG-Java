import java.util.Random;

public class Dialogo {
	
	//Dialogos historia
	//Capitulo 1
	//Introdução
	
	public static void introCap1() {
		
		System.out.println("O céu perdeu sua cor há muito tempo."+
				"\nUm manto cinza cobre a Cidade, onde o som das máquinas nunca dorme."
				+ "\nAs caldeiras fervem noite e dia, alimentadas por petróleo e vidas humanas."
				+ "\nA cada suspiro, os pulmões da população enchem de fumaça e algo mais..."
				+ "\nUma febre sombria se espalha pelos bairros baixos"
				+ "\n - começa com tosse seca e termina com delírios e morte."
				+ "\nAs autoridades silenciam. Medicos desaparecem. E a PetrolMax, "
				+ "\nmegacorporação que controla as refinarias, os trens, os jornais e até governo, "
				+ "\nnega qualquer responsabilidade."
				+ "\nÉ nesse cenário de sombras que você entra." 
				+ "\nUm investigador ambiental renomado, conhecido por resolver casos que ninguém mais ousa tocar."
				+ "\nContratado por alguém que se identifica apenas como O Cliente, sua missão é clara: " 
				+ "\ndescobrir a origem da praga e expor os culpados — antes que a própria Cidade o engula também."
				+ "\nEntretanto, para um trabalho difícil e misterioso como esse, voce precisara de um novo nome: ");
	}
	
	public static void introChegadaCidade() {
		System.out.println("Sendo assim...");
		System.out.println("A viagem até a Cidade não é longa, porém voce se sente exaurido.\n"+
						"Seja por conta das vibrações do trem, ou pela completa ausencia de qualquer verde pela janela...");
	}
	
	
	//Seleção de especialização
	public static void selectEspec() {
		System.out.println("\n"+
				"Assim como os melhores ivestigadores não são perfeitos, voce também não é excelente em tudo."+
				"\nIndique qual a sua especialidade...");
		System.out.println("1 - Carisma");
	    System.out.println("2 - Inteligência");
	    System.out.println("3 - Briga");
	    System.out.println("4 - Furtividade");
	    System.out.println("Digite o número correspondente à especialização: ");
		
	}
	
	
	//Dialogo de combate
	private static final String[] iniCombate= {
			"Dialogo inicio de combate","Dialogo inicio de combate",
			"Dialogo inicio de combate","Dialogo inicio de combate",
			"Dialogo inicio de combate","Dialogo inicio de combate"
	};
	
	//Dialogo de vitoria
	private static final String[] dialogoVitoria= {
			
			"Dialogo vitoria","Dialogo vitoria","Dialogo vitoria",
			"Dialogo vitoria","Dialogo vitoria","Dialogo vitoria"
	};
	
	//Dialogo de itens
	private static final String[] dialogoItem= {
			
			"Voce encontrou um item","Voce encontrou um item","Voce encontrou um item",
			"Voce encontrou um item","Voce encontrou um item","Voce encontrou um item"
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
		System.out.println(dialogoItem[i] + " Voce achou " + nomeItem + "!");
	}
	
	
	
	
	

}
