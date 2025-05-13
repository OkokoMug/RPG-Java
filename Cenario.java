import java.util.Map;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Cenario {
	
	private String descricao;
	private Map<String, String> opcoes;
	private String dialogoMetodo;
	
	public static Map<String, Cenario> cenarios = new HashMap<>();
	
	public Cenario(String desc, Map<String, String> opcao, String dialogo) {
		this.descricao=desc;
		this.opcoes=opcao;
		this.dialogoMetodo = dialogo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Map<String, String> getOpcoes(){
		return opcoes;
	}
	
	public String getDialogoMetodo() {
        return dialogoMetodo;
    }
	
	//Testando criar cenarios de forma mais simples
	public static Map<String, String> criarOpcoes(String... direcoes){
		Map<String, String> mapa = new HashMap<>();
		for (int i = 0; i <direcoes.length - 1; i +=2) {
			String direcaoNormalizada = Utils.removerAcentos(direcoes[i].toLowerCase());
			 direcaoNormalizada = direcaoNormalizada.substring(0, 1).toUpperCase() + direcaoNormalizada.substring(1);
			mapa.put(direcoes[i], direcoes[i+1]);
		}
		return mapa;
	}
	
	public void mostrarCenario() {
		System.out.println("\n" + descricao);

		if (dialogoMetodo != null && !dialogoMetodo.isEmpty()) {
			try {
				Method metodo = Dialogo.class.getMethod(dialogoMetodo);
				metodo.invoke(null);
			} catch (Exception e) {
				System.out.println("Erro ao realizar diálogo: " + e.getMessage());
			}
		}

		System.out.println("\nVocê decide:");
		for (String direcao : opcoes.keySet()) {
			System.out.println("- " + direcao);
		}
	}
	
	
	
	//Criando cenarios
	//"direção" , "Destino". Em pares, mais facil de extender o mapa depois
	public static void initCenarios() {				//Descrição, opcoes//
		
		//Bilheteria
		Map<String, String> opcoesBilheteria = new LinkedHashMap<>();
		opcoesBilheteria.put("Voltar","Lobby");
		opcoesBilheteria.put("Vasculhar", "#vasculhar_caixa");
		
		Cenario bilheteria = new Cenario(
				"Voce está na bilheteria da estação.",opcoesBilheteria,"TremC_dialogoBilheteria"
				);
				
		
		cenarios.put("Bilheteria", bilheteria);
		
		//Lobby
		Map<String, String> opcoesLobby = new LinkedHashMap<>();
		opcoesLobby.put("Bilheteria","Bilheteria");
		opcoesLobby.put("Saida", "Ruas");
		opcoesLobby.put("Manutencao", "Sala de Manutencao");
		opcoesLobby.put("Sanitarios","Sanitarios");
		
		Cenario lobby = new Cenario(
				"Voce está no lobby da estação de trem.",opcoesLobby,"TremC_dialogoLobby"
				);
		
		cenarios.put("Lobby",lobby);
				
		//Sanitarios
		Map<String, String> opcoesSanitarios = new LinkedHashMap<>();
		opcoesSanitarios.put("Voltar","Lobby");
		opcoesSanitarios.put("Espelho","#olha_espelho");
		opcoesSanitarios.put("Toilet","#usa_toilet");
		
		Cenario sanitarios = new Cenario(
				"Voce está no banheiro.",opcoesSanitarios,"TremC_dialogoBanheiro"
				);
		
		cenarios.put("Sanitarios", sanitarios);
		
		//Ruas
		Map<String, String> opcoesRuas = new LinkedHashMap<>();
		opcoesRuas.put("Bar", "PubG");
		opcoesRuas.put("Hotel", "Hotel");
		opcoesRuas.put("Estacao", "Lobby");
		opcoesRuas.put("Parque", "Parque");
		
		Cenario ruas = new Cenario(
				"Você está nas Ruas", opcoesRuas, "RuasDialogo");
		
		cenarios.put("Ruas", ruas);
		
		//Hotel
		Map<String, String> opcoesHotel = new LinkedHashMap<>();
		opcoesHotel.put("Apartamento", "Apartamento");
		opcoesHotel.put("Saida", "Ruas");
		
		Cenario hotel = new Cenario(
				"Voce esta no seu Hotel.", opcoesHotel, "HotelDialogo");
		
		cenarios.put("Hotel",hotel);
		
		//Apartamento
		Map<String, String> opcoesApartamento = new LinkedHashMap<>();
		opcoesApartamento.put("Dormir", "#dormir_Apt");
		opcoesApartamento.put("Voltar", "Hotel");
		
		Cenario apartamento = new Cenario(
				"Voce esta em seu quarto de apartamento.", opcoesApartamento, "Intro_Apt");
		
		cenarios.put("Apartamento", apartamento);
		
		//Parque
		
		Map<String, String> opcoesParque = new LinkedHashMap<>();
		opcoesParque.put("Observar","#observar_parque");
		opcoesParque.put("Voltar", "Ruas");
		
		if (Estados.getFlag("dialogoGarota_ruas")) {
			opcoesParque.put("Laboratorio","Laboratorio");
			opcoesParque.put("Botanica", "#dialogo_botanica");
		}
		
		Cenario parque = new Cenario("Voce está no parque.", opcoesParque, "dialogoParque" );
		
		cenarios.put("Parque",parque);
		
		//Laboratorio
		
		Map<String,String> opcoesLab = new LinkedHashMap<>();
		opcoesLab.put("Voltar", "Parque");
		
		if (Estados.getFlag("dialogoLouca_1")) {
			opcoesLab.put("Entrada", "Entrada");
			opcoesLab.put("Fundos", "Fundos");
			opcoesLab.put("Armazem","Armazem");
		}
		
		
		Cenario lab = new Cenario("Voce está no laboratório.", opcoesLab,"dialogoLab");
			
		cenarios.put("Laboratorio", lab);
		
		//Entrada Principal LAb
		
		Map<String,String> opcoesLabEntrPrincipal = new LinkedHashMap<>();
		opcoesLabEntrPrincipal.put("Voltar", "Laboratorio");
		opcoesLabEntrPrincipal.put("Elevador", "Elevador");
		opcoesLabEntrPrincipal.put("Observar", "#observar_labAtrio");
		
		Cenario labEntradaPrincipal = new Cenario("Voce está no Átrio do laboratório.", opcoesLabEntrPrincipal,"dialogoLabPrincipal");
			
		cenarios.put("Entrada", labEntradaPrincipal);
		
		//Elevador lab
		
		Map<String,String> opcoesElevadorLab = new LinkedHashMap<>();
		opcoesElevadorLab.put("Voltar", "Laboratorio");
		opcoesElevadorLab.put("Subir","Andar Max");
		
		Cenario labElevador = new Cenario("Voce está no Elevador.", opcoesElevadorLab,"dialogoElevador");
			
		cenarios.put("Elevador", labElevador);
		
		//Fundos lab
		
		Map<String,String> opcoesLabFundos = new LinkedHashMap<>();
		opcoesLabFundos.put("Voltar", "Laboratorio");
		opcoesLabFundos.put("Invadir", "Escadas");
		opcoesLabFundos.put("Observar", "#observar_fundos");
		
		Cenario labFundos = new Cenario("Voce está nos fundos do laboratorio.", opcoesLabFundos,"dialogoLabFundos");
			
		cenarios.put("Fundos", labFundos);
		
		//Escads lab
		
		Map<String,String> opcoesEscadasLab = new LinkedHashMap<>();
		opcoesEscadasLab.put("Voltar", "Fundos");
		opcoesEscadasLab.put("Subir", "Andar Max");
		
		Cenario labEscadas = new Cenario("Voce está nas escadas.", opcoesEscadasLab,"dialogoEscadas");
			
		cenarios.put("Escadas", labEscadas);
		
		//Armazem lab
		
		Map<String,String> opcoesLabArmazem = new LinkedHashMap<>();
		opcoesLabArmazem.put("Voltar", "Laboratorio");
		opcoesLabArmazem.put("Porta", "Corredores");
		opcoesLabArmazem.put("Observar", "#observarArmazem");
		
		Cenario labArmazem = new Cenario("Voce está no armazem laboratório.", opcoesLabArmazem,"dialogoLabArmazem");
			
		cenarios.put("Armazem", labArmazem);
		
		//Corredores
		
		Map<String,String> opcoesCorredores = new LinkedHashMap<>();
		opcoesCorredores.put("Voltar", "Armazem");
		opcoesCorredores.put("Escadas", "Andar Max");
		opcoesCorredores.put("Observar", "#observar_corredores");
		
		Cenario labCorredores = new Cenario("Voce está nos corredores.", opcoesCorredores,"dialogoCorredores");
			
		cenarios.put("Corredores", labCorredores);
		
		//Andar max
		
		Map<String,String> opcoesMax = new LinkedHashMap<>();
		opcoesMax.put("Sair", "Entrada");
		opcoesMax.put("Escritorio", "Escritorio");
		
		Cenario labMax = new Cenario("Voce está no andar mais alto do prédio.", opcoesMax,"dialogoMaxAndar");
			
		cenarios.put("Andar Max", labMax);
		
		//Escritorio alighieri
		
		Map<String,String> opcoesEscritorio = new LinkedHashMap<>();
		opcoesEscritorio.put("Voltar", "Andar Max");
		opcoesEscritorio.put("Analisar documentos", "#documentos_mark");
		
		Cenario labEscritorio = new Cenario("Voce está no escritório de Alighieri.", opcoesEscritorio,"dialogoEscritorio");
			
		cenarios.put("Escritorio", labEscritorio);
		
	}
	
	////////////////////////////////////
	public void updtOpcoes(Map<String,String> novasOpcoes) {
		this.opcoes = novasOpcoes;
	}
	
	public static void updtParqueOpcoes() {
	    Cenario parque = Cenario.cenarios.get("Parque");
	    if (parque != null) {
	        Map<String, String> newOpcao = new LinkedHashMap<>();
	        newOpcao.put("Observar", "#observar_parque");
	        newOpcao.put("Voltar", "Ruas");

	        if (Estados.getFlag("dialogoGarota_ruas")) {
	            newOpcao.put("Laboratorio", "Laboratorio");
	            newOpcao.put("Botanica", "#dialogo_botanica");
	        }

	        parque.updtOpcoes(newOpcao); 
	    }
	}
	
	public static void updtLabOpcoes() {
	    Cenario lab = Cenario.cenarios.get("Laboratorio");
	    if (lab != null) {
	        Map<String, String> newOpcao = new LinkedHashMap<>();
	        newOpcao.put("Voltar", "Parque");


	        if (Estados.getFlag("dialogoLouca_1")) {
	        	newOpcao.put("Entrada", "Entrada");
				newOpcao.put("Fundos", "Fundos");
				newOpcao.put("Armazem","Armazem");
	        }

	        lab.updtOpcoes(newOpcao); 
	    }
	}
	
	
}	
