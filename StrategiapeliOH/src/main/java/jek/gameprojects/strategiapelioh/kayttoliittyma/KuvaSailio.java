package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.KuvanLataaja;

public class KuvaSailio {
    
    private static final Map<String, Image> kuvat = new HashMap<>();
    private static final KuvanLataaja lataaja = new KuvanLataaja();
    
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

        lataaKuva("Ruudut/Yksikoita1.png", "Yksikoita:1");
        lataaKuva("Ruudut/Yksikoita2.png", "Yksikoita:2");
        lataaKuva("Ruudut/Yksikoita3.png", "Yksikoita:3");
        
        lataaKuva("Yksikot/elamat.png", "elamat");
        lataaKuva("Yksikot/elamat_pohja.png", "elamat_pohja");
        
        lataaKuva("Yksikot/puolustuslinnoitus.png", "Puolustuslinnoitus");
        lataaKuva("Yksikot/tarkka-ampuja.png", "Tarkka-ampuja");
        lataaKuva("Yksikot/tiedustelija.png", "Tiedustelija");
        lataaKuva("Yksikot/tuhoaja.png","Tuhoaja");
        lataaKuva("Yksikot/tykki.png", "Tykki");
        
        lataaKuva("Yksikot/puolustuslinnoitus:valittu.png", "Puolustuslinnoitus:valittu");
        lataaKuva("Yksikot/tarkka-ampuja:valittu.png", "Tarkka-ampuja:valittu");
        lataaKuva("Yksikot/tiedustelija:valittu.png", "Tiedustelija:valittu");
        lataaKuva("Yksikot/tuhoaja:valittu.png", "Tuhoaja:valittu");
        lataaKuva("Yksikot/tykki:valittu.png", "Tykki:valittu");
    }
    
    public static void lataaKuva(String osoite, String nimi){
        Image kuva = lataaja.lataaKuva(osoite);
        kuvat.put(nimi, kuva);
    }
    
    public static Image getKuva(String nimi){
        return kuvat.get(nimi);
    }
}
