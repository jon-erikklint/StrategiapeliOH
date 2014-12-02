package jek.gameprojects.strategiapelioh.logiikka.generointi.aseet;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;

public interface PanssarivahvuuksienAlustaja {
    
    public Map<Asetyyppi,Map<Panssarityyppi, Double>> panssarityyppienVahvuudet();
    
}
