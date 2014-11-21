package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public interface PelaajienAlustaja {
    
    public Map<Integer,Pelaaja> alustaPelaajat(List<String> pelaajienNimet);
    
}
