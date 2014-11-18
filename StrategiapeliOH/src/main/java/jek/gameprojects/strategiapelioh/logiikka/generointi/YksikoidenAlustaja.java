package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public interface YksikoidenAlustaja {
    
    public void alustaYksikot(Kartta kartta, List<Pelaaja> pelaajat);
    
}
