import java.text.Normalizer;

public class Utils {
	
	public static String removerAcentos(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]","");
		return texto;
	}

}
