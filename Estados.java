import java.util.HashMap;
import java.util.Map;

public class Estados {
    public static final Map<String, Boolean> flags = new HashMap<>();
    
    static {
    	
        // Todas as flags
        flags.put("introCap1Mostrada", false);
        flags.put("introChegadaMostrada", false);
        flags.put("selectEspecMostrada", false);
        flags.put("chegadaQuarto", false);
        flags.put("dialogoquartoCompleto", false);
        flags.put("dialogoGarota_ruas", false);
        flags.put("dialogoLouca_1", false);
        flags.put("permissao_botanica", false);
        flags.put("elevador_acesso", false);
        flags.put("documentos_markOk", false);
        flags.put("garotaNoApt", false);
        flags.put("conheceu_Lua", false);
        flags.put("cap2_inicio", false);
        flags.put("dialogoLuaCap2Apt_mostrado", false);
        flags.put("confrontoMark_feito", false);
        flags.put("escolha_alig_Ajudar", false);
        flags.put("escolha_alig_Queimar", false);
        flags.put("escolha_alig_Familia", false);
        flags.put("mark_apelaFamilia", false);
        
    }
    
    public static boolean getFlag(String flagName) {
        return flags.getOrDefault(flagName, false);
    }
    
    public static void setFlag(String flagName, boolean value) {
        flags.put(flagName, value);
    }
    
    public static boolean isIntroCap1Mostrada() {
        return getFlag("introCap1Mostrada");
    }
    
    public static void setIntroCap1Mostrada(boolean value) {
        setFlag("introCap1Mostrada", value);
    }
    
    public static boolean isIntroChegadaMostrada() {
        return getFlag("introChegadaMostrada");
    }
    
    public static void setIntroChegadaMostrada(boolean value) {
        setFlag("introChegadaMostrada", value);
    }
    
    public static boolean isSelectEspecMostrada() {
        return getFlag("selectEspecMostrada");
    }
    
    public static void setSelectEspecMostrada(boolean value) {
        setFlag("selectEspecMostrada", value);
    }
    
    public static boolean isChegadaQuarto() {
        return getFlag("chegadaQuarto");
    }
    
    public static void setChegadaQuarto(boolean value) {
        setFlag("chegadaQuarto", value);
    }
    
    public static boolean isDialogoquartoCompleto() {
        return getFlag("dialogoquartoCompleto");
    }
    
    public static void setDialogoquartoCompleto(boolean value) {
        setFlag("dialogoquartoCompleto", value);
    }
    
    public static boolean isDialogoGarota_ruas() {
        return getFlag("dialogoGarota_ruas");
    }
    
    public static void setDialogoGarota_ruas(boolean value) {
        setFlag("dialogoGarota_ruas", value);
    }
    
    public static boolean getDialogoLouca_1() {
    	return getFlag("dialogoLouca_1");
    }
    
    public static void setDialogoLouca_1(boolean value) {
    	setFlag("dialogoLouca_1",value);
    }
    
    public static boolean getPermissao_Botanica() {
    	return getFlag("permissao_botanica");
    }
    
    public static void setPermissao_Botanica(boolean value) {
    	setFlag("permissao_botanica",value);
    }
    
    public static boolean getElevador_acesso() {
    	return getFlag("elevador_acesso");
    }
    
    public static void setElevador_acesso(boolean value) {
    	setFlag("elevador_acesso",value);
    }
    
    public static boolean getDocumentos_markOk() {
    	return getFlag("documentos_markOk");
    }
    
    public static void setDocumentos_markOk(boolean value) {
    	setFlag("documentos_markOk",value);
    }
        
}
