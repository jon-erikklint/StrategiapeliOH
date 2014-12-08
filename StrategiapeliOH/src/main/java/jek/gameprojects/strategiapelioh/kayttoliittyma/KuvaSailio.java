package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.KuvanLataaja;

public class KuvaSailio {
    
    private static final Map<String, Image> kuvat = new HashMap<>();
    
    public static void lataaKuvat(){
        lataaKuva("Painikkeet/aloituspainike.png", "aloituspainike");
        lataaKuva("Painikkeet/hyokkayspainike.png", "hyokkayspainike");
        lataaKuva("Painikkeet/liikutuspainike.png", "liikutuspainike");
        lataaKuva("Painikkeet/vuoronvaihtopainike.png", "vuoronvaihtopainike");
        
        lataaKuva("Ruudut/Ruutu.maa.png", "[maa,avomaa]");
        lataaKuva("Ruudut/Ruutu.vesi.png", "[vesi,avomaa]");
        lataaKuva("Ruudut/Ruutu.maa.metsa.png", "[maa,metsa]");
        
        lataaKuva("Ruudut/Ruutu.maa.valittu:liikkuminen.png", "[maa,avomaa]:LIIKUTTAVA");
        lataaKuva("Ruudut/Ruutu.vesi.valittu:liikkuminen.png", "[vesi,avomaa]:LIIKUTTAVA");
        lataaKuva("Ruudut/Ruutu.maa.metsa.valittu:liikkuminen.png", "[maa,metsa]:LIIKUTTAVA");
        
        lataaKuva("Ruudut/Ruutu.maa.valittu:hyokkaaminen.png", "[maa,avomaa]:HYOKATTAVA");
        lataaKuva("Ruudut/Ruutu.vesi.valittu:hyokkaaminen.png", "[vesi,avomaa]:HYOKATTAVA");
        lataaKuva("Ruudut/Ruutu.maa.metsa.valittu:hyokkaaminen.png", "[maa,metsa]:HYOKATTAVA");
        
        lataaKuva("Ruudut/Ruutu.maa.valittu:aktiivinen.png", "[maa,avomaa]:AKTIIVINEN");
        lataaKuva("Ruudut/Ruutu.vesi.valittu:aktiivinen.png", "[vesi,avomaa]:AKTIIVINEN");
        lataaKuva("Ruudut/Ruutu.maa.metsa.valittu:aktiivinen.png", "[maa,metsa]:AKTIIVINEN");

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
