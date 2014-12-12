package jek.gameprojects.strategiapelioh.logiikka.yksikot;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;

/**
 * 
 * Luokka jonka tehtävänä on poistaa kuolleet yksiköt pelistä
 * 
 */

public class YksikoidenPoistaja {
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    public YksikoidenPoistaja(JoukkojenHallinnoija joukkojenHallinnoija){
        this.joukkojenHallinnoija = joukkojenHallinnoija;
    }
    
    /**
     * Poistaa yksikön pelistä
     * 
     * @param yksikko poistettava
     */
    public void poistaYksikko(Yksikko yksikko){
        joukkojenHallinnoija.poistayksikkoJoukostaan(yksikko);
        
        joukkojenHallinnoija.poistaTyhjatJoukot();
    }
    
}
