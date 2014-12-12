package jek.gameprojects.strategiapelioh.logiikka.generointi.kartta;

import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;

/**
 * 
 * Alustaa kartan
 * 
 */
public interface KartanAlustaja {
    
    /**
     * 
     * Alustaa kartan
     * 
     * @return kartta
     * @throws Exception virhe karttaa luodessa
     */
    public Kartta alustaKartta() throws Exception;
    
}
