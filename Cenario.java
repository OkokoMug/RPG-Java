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

		System.out.println("Você decide:");
		for (String direcao : opcoes.keySet()) {
			System.out.println("- " + direcao);
		}
	}
	
	
	
	//Criando cenarios
	//"direção" , "Destino". Em pares, mais facil de extender o mapa depois
	public static void initCenarios() {				//Descrição, opcoes//
		
		Map<String, String> opcoesBilheteria = new LinkedHashMap<>();
		opcoesBilheteria.put("Voltar","Lobby");
		opcoesBilheteria.put("Vasculhar", "#vasculhar_caixa");
		
		Cenario bilheteria = new Cenario(
				"Voce está na bilheteria da estação.",opcoesBilheteria,"TremC_dialogoBilheteria"
				);
				
		
		cenarios.put("Bilheteria", bilheteria);
		
		Map<String, String> opcoesLobby = new LinkedHashMap<>();
		opcoesLobby.put("Bilheteria","Bilheteria");
		opcoesLobby.put("Saida", "Ruas");
		opcoesLobby.put("Manutencao", "Sala de Manutencao");
		opcoesLobby.put("Sanitarios","Sanitarios");
		
		Cenario lobby = new Cenario(
				"Voce está no lobby da estação de trem.",opcoesLobby,"TremC_dialogoLobby"
				);
		
		cenarios.put("Lobby",lobby);
				
		Map<String, String> opcoesSanitarios = new LinkedHashMap<>();
		opcoesSanitarios.put("Voltar","Lobby");
		opcoesSanitarios.put("Espelho","#olha_espelho");
		opcoesSanitarios.put("Toilet","#usa_toilet");
		
		Cenario sanitarios = new Cenario(
				"Voce está no banheiro.",opcoesSanitarios,"TremC_dialogoBanheiro"
				);
		
		cenarios.put("Sanitarios", sanitarios);
	}
}	
