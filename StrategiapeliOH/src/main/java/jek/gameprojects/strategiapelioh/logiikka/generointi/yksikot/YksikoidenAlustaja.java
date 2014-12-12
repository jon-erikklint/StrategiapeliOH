package jek.gameprojects.strategiapelioh.logiikka.generointi.yksikot;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.logiikka.Indeksoija;

/**
 * 
 * Alustaa yksiköt
 * 
 */
public interface YksikoidenAlustaja {
    
    /**
     * 
     * Luo alkuyksiköt, laittaa ne kartalle ja lisää ne pelaajille
     * 
     * @param kartta
     * @param pelaajat
     * @param yksikkotyypit yksikkötyypit joita yksiköt voivat olla
     * @param yksikoidenIndeksoija yksiköiden indeksointiin käytetty indeksoija, käytetään myöhemmin yksiköitä luodessa
     * @throws Exception virhe yksiköitä luotaessa
     */
    public void alustaYksikot(Kartta kartta, Map<Integer,Pelaaja> pelaajat, Map<String,Yksikkotyyppi> yksikkotyypit, Indeksoija yksikoidenIndeksoija) throws Exception;
    
}
