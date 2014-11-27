package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.KuvanLataaja;

public class KuvaSailio {
    
    public Map<String, Image> kuvat;
    
    public KuvaSailio(){
        kuvat = new HashMap<>();
    }
    
    public void lataaKuvat(){
        lataaKuva("Painikkeet/aloituspainike.png", "aloituspainike");
    }
    
    public void lataaKuva(String osoite, String nimi){
        KuvanLataaja lataaja = new KuvanLataaja();
        
        Image kuva = lataaja.lataaKuva(osoite);
        kuvat.put(nimi, kuva);
    }
    
    public Image getKuva(String nimi){
        return kuvat.get(nimi);
    }
}
