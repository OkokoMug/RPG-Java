import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class GameSave {
    private static final String SAVE_FOLDER = ".seujogo";
    private static final String SAVE_FILE = "savegame.ser";
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 1000;

    static {
        // Create save directory if it doesn't exist
        try {
            Files.createDirectories(Paths.get(System.getProperty("user.home"), SAVE_FOLDER));
        } catch (IOException e) {
            System.err.println("Não foi possível criar diretório de save: " + e.getMessage());
        }
    }

    public static void salvarJogo() {
        Path saveDir = Paths.get(System.getProperty("user.home"), SAVE_FOLDER);
        Path savePath = saveDir.resolve(SAVE_FILE);
        Path tempPath = saveDir.resolve("savegame.tmp");
        
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                // 1. Write to temp file with file lock
                try (FileChannel channel = FileChannel.open(tempPath, 
                        StandardOpenOption.CREATE, 
                        StandardOpenOption.WRITE,
                        StandardOpenOption.TRUNCATE_EXISTING);
                     ObjectOutputStream oos = new ObjectOutputStream(
                         Channels.newOutputStream(channel))) {
                    
                    SaveData saveData = new SaveData();
                    saveData.setPlayer(Player.get());
                    saveData.setCenarioAtual(Player.get().getCenarioAtual());
                    saveData.setIntroCap1Mostrada(Estados.introCap1Mostrada);
                    saveData.setIntroChegadaMostrada(Estados.introChegadaMostrada);
                    saveData.setSelectEspecMostrada(Estados.selectEspecMostrada);
                    saveData.setChegadaQuarto(Estados.chegadaQuarto);
                    saveData.setDialogoquartoCompleto(Estados.dialogoquartoCompleto);
                    
                    oos.writeObject(saveData);
                }

                // 2. Atomic replacement
                try {
                    Files.move(tempPath, savePath, 
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.ATOMIC_MOVE);
                } catch (AtomicMoveNotSupportedException e) {
                    Files.move(tempPath, savePath, 
                        StandardCopyOption.REPLACE_EXISTING);
                }

                // 3. Verify the save
                if (isSaveValid(savePath)) {
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    System.out.println("▒ Progresso salvo com sucesso ▒");
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    return;
                } else {
                    throw new IOException("Falha na verificação do save");
                }
                
            } catch (Exception e) {
                System.err.println("Tentativa " + attempt + " falhou: " + e.getMessage());
                try { 
                    Thread.sleep(RETRY_DELAY_MS); 
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                
                // Clean up failed temp file
                try { 
                    Files.deleteIfExists(tempPath); 
                } catch (IOException ie) {
                    System.err.println("Falha ao limpar arquivo temporário");
                }
            }
        }
        
        System.err.println("Falha ao salvar após " + MAX_RETRIES + " tentativas.");
    }

    public static boolean existeSave() {
        return isSaveValid(getSavePath());
    }

    public static void apagarSave() {
        try {
            Files.deleteIfExists(getSavePath());
        } catch (IOException e) {
            System.err.println("Erro ao apagar save: " + e.getMessage());
        }
    }

    public static void carregarJogo() {
        Path savePath = getSavePath();
        
        if (!isSaveValid(savePath)) {
            System.out.println("Nenhum save válido encontrado.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
            Files.newInputStream(savePath))) {
            
            SaveData saveData = (SaveData) ois.readObject();
            
            // Restore player
            Player.criarInstancia(saveData.getPlayer().getNome());
            Player player = Player.get();
            Player savedPlayer = saveData.getPlayer();
            
            player.setEspec(savedPlayer.getEspecIndex());
            player.setHp(savedPlayer.getHp());
            player.setAtk(savedPlayer.getAtk());
            
            // Force apartment as starting location
            player.setCenarioAtual("Apartamento");
            
            // Restore all game states
            Estados.introCap1Mostrada = saveData.getIntroCap1Mostrada();
            Estados.introChegadaMostrada = saveData.getIntroChegadaMostrada();
            Estados.selectEspecMostrada = saveData.getSelectEspecMostrada();
            Estados.chegadaQuarto = saveData.getChegadaQuarto();
            Estados.dialogoquartoCompleto = saveData.getDialogoquartoCompleto();
            
            System.out.println("\n▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("▒ Memórias recuperadas com sucesso ▒");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            
        } catch (Exception e) {
            System.err.println("Erro ao carregar: " + e.getMessage());
            System.out.println("As memórias estão fragmentadas...");
        }
    }

    private static Path getSavePath() {
        return Paths.get(System.getProperty("user.home"), SAVE_FOLDER, SAVE_FILE);
    }

    private static boolean isSaveValid(Path path) {
        if (!Files.exists(path)) {
            return false;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
            Files.newInputStream(path))) {
            
            Object obj = ois.readObject();
            if (!(obj instanceof SaveData)) {
                return false;
            }
            
            SaveData data = (SaveData) obj;
            return data.getPlayer() != null && 
                   data.getCenarioAtual() != null &&
                   data.getPlayer().getHp() > 0;
            
        } catch (Exception e) {
            return false;
        }
    }
}