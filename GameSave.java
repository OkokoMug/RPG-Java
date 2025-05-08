import java.io.*;

public class GameSave {
	
	public static void salvarJogo(Player jogador) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"))){
			out.writeObject(jogador);
			System.out.println("\nProgresso foi salvo...");
		} catch (IOException e) {
			System.out.println("Erro ao salvar progresso: " + e.getMessage());
		}
	}
	
	public static Player carregaJogo() {
		try (ObjectInputStream in = new ObjectInputStream(new  FileInputStream("save.dat"))){
			return (Player) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("\n[Nenhum progresso salvo encontrado]: ");
			return null;
		}
	}

}
