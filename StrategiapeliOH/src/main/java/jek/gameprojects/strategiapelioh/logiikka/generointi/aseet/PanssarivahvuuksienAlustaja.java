package jek.gameprojects.strategiapelioh.logiikka.generointi.aseet;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;

/**
 * 
 * Alustaa panssarien vahvuudet eri asetyyppejä vastaan
 * 
 */
public interface PanssarivahvuuksienAlustaja {
    
    /**
     * Alustaa asetyyppien vahvuudet kertoimina eri panssarityyppejä vastaan
     * 
     * @return asetyyppien vahvuudet panssarityyppejä vastaan
     */
    public Map<Asetyyppi,Map<Panssarityyppi, Double>> panssarityyppienVahvuudet();
    
}
