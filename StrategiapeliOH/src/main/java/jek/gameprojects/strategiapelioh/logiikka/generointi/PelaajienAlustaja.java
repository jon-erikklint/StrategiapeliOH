package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.List;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public interface PelaajienAlustaja {
    
    public List<Pelaaja> alustaPelaajat(List<String> pelaajienNimet);
    
}
