
import java.io.Serializable;

public class SaveData implements Serializable {
    private static final long serialVersionUID = 3L;
    
    private Player player;
    private String cenarioAtual;
    private boolean introCap1Mostrada;
    private boolean introChegadaMostrada;
    private boolean selectEspecMostrada;
    private boolean chegadaQuarto;
    private boolean dialogoquartoCompleto;

    // Getters and setters for all fields
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
    
    public boolean getIntroCap1Mostrada() {
    	return introCap1Mostrada;
    }
    
    public void setIntroCap1Mostrada(boolean set) {
    	this.introCap1Mostrada = set;
    }
    
    public boolean getIntroChegadaMostrada() {
    	return introChegadaMostrada;
    }
    
    public void setIntroChegadaMostrada(boolean set) {
    	this.introChegadaMostrada = set;
    }
    
    public boolean getSelectEspecMostrada() {
    	return selectEspecMostrada;
    }
    
    public void setSelectEspecMostrada(boolean set) {
    	this.selectEspecMostrada = set;
    }
    
    public boolean getChegadaQuarto() {
    	return chegadaQuarto;
    }
    
    public void setChegadaQuarto(boolean set) {
    	this.chegadaQuarto = set;
    }
    
    public boolean getDialogoquartoCompleto() {
    	return dialogoquartoCompleto;
    }
    
    public void setDialogoquartoCompleto(boolean set) {
    	this.dialogoquartoCompleto = set;
    }
    

}