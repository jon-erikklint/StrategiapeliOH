package jek.gameprojects.strategiapelioh.logiikka.generointi.yksikot;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.logiikka.Indeksoija;

public interface YksikoidenAlustaja {
    
    public void alustaYksikot(Kartta kartta, Map<Integer,Pelaaja> pelaajat, Map<String,Yksikkotyyppi> yksikkotyypit, Indeksoija yksikoidenIndeksoija) throws Exception;
    
}
