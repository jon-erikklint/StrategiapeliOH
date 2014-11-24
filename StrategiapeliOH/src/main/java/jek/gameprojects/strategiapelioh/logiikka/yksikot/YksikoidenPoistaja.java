package jek.gameprojects.strategiapelioh.logiikka.yksikot;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;

public class YksikoidenPoistaja {
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    public YksikoidenPoistaja(){
        joukkojenHallinnoija = new JoukkojenHallinnoija();
    }
    
    public void poistaYksikko(Yksikko yksikko){
        joukkojenHallinnoija.poistayksikkoJoukostaan(yksikko);
    }
    
}
