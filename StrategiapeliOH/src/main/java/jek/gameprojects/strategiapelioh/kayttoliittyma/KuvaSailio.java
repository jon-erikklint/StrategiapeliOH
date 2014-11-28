package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.KuvanLataaja;

public class KuvaSailio {
    
    private static final Map<String, Image> kuvat = new HashMap<>();
    
    public static void lataaKuvat(){
        lataaKuva("Painikkeet/aloituspainike.png", "aloituspainike");
    }
    
    public static void lataaKuva(String osoite, String nimi){
        KuvanLataaja lataaja = new KuvanLataaja();
        
        Image kuva = lataaja.lataaKuva(osoite);
        kuvat.put(nimi, kuva);
    }
    
    public static Image getKuva(String nimi){
        return kuvat.get(nimi);
    }
}
