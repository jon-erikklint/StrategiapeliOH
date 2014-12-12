package jek.gameprojects.strategiapelioh.logiikka.generointi.pelaajat;

import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

/**
 * 
 * Alustaa pelaajat 
 *
 */
public interface PelaajienAlustaja {
    
    /**
     * Alustaa kartan pelaajista jossa avaimet ovat pelaajien indeksejä. Nimeää pelaajat annettujen nimien mukaan.
     * 
     * @param pelaajienNimet
     * @return pelaajat
     */
    public Map<Integer,Pelaaja> alustaPelaajat(List<String> pelaajienNimet);
    
}
