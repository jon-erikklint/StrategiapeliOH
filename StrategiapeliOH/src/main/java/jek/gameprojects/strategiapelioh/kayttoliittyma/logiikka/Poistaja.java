package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Nakyva;
import java.util.ArrayList;
import java.util.List;


public class Poistaja {
    
    public static List<Nakyva> poistettavat = new ArrayList<>();
    
    public static void poistaPoistettavat(){
        for(Nakyva nakyva : poistettavat){
            poistaPoistettava(nakyva);
        }
        
        poistettavat.clear();
    }
    
    private static void poistaPoistettava(Nakyva nakyva){
        nakyva.setNakyvyys(false);
    }
}
