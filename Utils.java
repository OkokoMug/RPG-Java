import java.text.Normalizer;
import java.util.Scanner;

public class Utils {
	
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	
	public static String removerAcentos(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]","");
		return texto;
	}

	public static int lerInteiro(Scanner scanner, int min, int max, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            
            try {
                int valor = Integer.parseInt(input);
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.printf("Por favor, digite um número entre %d e %d.\n", min, max);
                }
            } catch (NumberFormatException e) {
            	System.out.println(RED + "Entrada inválida. Por favor, digite um número." + RESET);
            }
        }
    }
	
	public static void mostrarAnimacaoCarregamento() {
	    System.out.print("\nRelembrando ");
	    for (int i = 0; i < 3; i++) {
	        System.out.print(".");
	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	    System.out.println();
	}
	
	
}
