import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class SaveData implements Serializable {
    private static final long serialVersionUID = 3L;
    
    
    
    private Player player;
    private String cenarioAtual;
    private Map<String, Boolean> flagsJogo = new HashMap<>();
    
    public SaveData() {
    	this.flagsJogo = new HashMap<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getCenarioAtual() {
        return cenarioAtual;
    }

    public void setCenarioAtual(String cenarioAtual) {
        this.cenarioAtual = cenarioAtual;
    }
    
    public Map<String, Boolean> getFlagsJogo() {
        if (flagsJogo == null) {
            flagsJogo = new HashMap<>(); // Fazer com que nunca seja nulo
        }
        return flagsJogo;
    }
    
    public void setFlagsJogo(Map<String, Boolean> flagsJogo) {
        this.flagsJogo = flagsJogo != null ? new HashMap<>(flagsJogo) : new HashMap<>();
    }
    
    
}
    