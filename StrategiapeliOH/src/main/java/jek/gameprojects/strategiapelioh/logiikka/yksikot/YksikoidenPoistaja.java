package jek.gameprojects.strategiapelioh.logiikka.yksikot;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;

/**
 * 
 * Luokka jonka tehtävänä on poistaa kuolleet yksiköt pelistä
 * 
 */

public class YksikoidenPoistaja {
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    public YksikoidenPoistaja(){
        joukkojenHallinnoija = new JoukkojenHallinnoija();
    }
    
    public void poistaYksikko(Yksikko yksikko){
        joukkojenHallinnoija.poistayksikkoJoukostaan(yksikko);
    }
    
}
