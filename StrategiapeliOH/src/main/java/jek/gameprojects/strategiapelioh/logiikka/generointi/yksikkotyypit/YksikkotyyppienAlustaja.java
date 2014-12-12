package jek.gameprojects.strategiapelioh.logiikka.generointi.yksikkotyypit;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;

/**
 * 
 * Alustaa yksikkötyypit 
 *
 */
public interface YksikkotyyppienAlustaja {
    
    /**
     * Alustaa yksikkötyypit ja tallettaa ne mappiin, jossa avaimina on niiden nimet
     * 
     * @return yksikkötyypit
     * @throws Exception virhe yksikkötyyppejä alustaessa
     */
    public abstract Map<String, Yksikkotyyppi> alustaYksikkotyypit() throws Exception;
    
}
