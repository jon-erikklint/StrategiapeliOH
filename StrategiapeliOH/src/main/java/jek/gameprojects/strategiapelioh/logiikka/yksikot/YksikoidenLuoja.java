package jek.gameprojects.strategiapelioh.logiikka.yksikot;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.logiikka.Indeksoija;

/**
 * 
 * Luokka jonka tehtävä on luoda uusia yksiköitä annettujen tietojen perusteella
 * 
 */

public class YksikoidenLuoja {
    
    private Kartta kartta;
    private Map<Integer, Pelaaja> pelaajat;
    private Map<String, Yksikkotyyppi> yksikkotyypit;
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    private Indeksoija yksikoidenIndeksoija;
    
    public YksikoidenLuoja(Kartta kartta, Map<Integer, Pelaaja> pelaajat, Map<String, Yksikkotyyppi> yksikkotyypit, Indeksoija yksikoidenIndeksoija){
        this.kartta = kartta;
        this.pelaajat = pelaajat;
        this.yksikkotyypit = yksikkotyypit;
        
        this.yksikoidenIndeksoija = yksikoidenIndeksoija;
        this.joukkojenHallinnoija = new JoukkojenHallinnoija();
    }
    
}
