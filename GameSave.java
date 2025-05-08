import java.io.*;

public class GameSave {

    public static boolean existeSave() {
        File arquivo = new File("savegame.ser");
        return arquivo.exists();
    }
    
    public static void carregarJogo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savegame.ser"))) {
            Player playerSalvo = (Player) ois.readObject();
            Player.criarInstancia(playerSalvo.getNome()); // Recrianaod instância do player
            Player.get().setCenarioAtual(playerSalvo.getCenarioAtual()); //Restaurando o cenário atual
            System.out.println("Progresso carregado com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o progresso.");
            e.printStackTrace();
        }
    }

    public static void salvarJogo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savegame.ser"))) {
            oos.writeObject(Player.get()); 
            System.out.println("Progresso foi salvo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o progresso.");
            e.printStackTrace();
        }
    }

    public static void apagarSave() {
        File arquivo = new File("savegame.ser");
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }
}

