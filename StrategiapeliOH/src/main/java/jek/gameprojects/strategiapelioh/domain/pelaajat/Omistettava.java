package jek.gameprojects.strategiapelioh.domain.pelaajat;

/**
 * 
 * Rajapinta, jonka toteuttavat oliot ovat jonkun pelaajan omaisuutta
 * 
 */

public interface Omistettava {
    
    /**
     * Palauttaa kenen omistama omistettava objekti on
     * 
     * @return omistaja
     */
    public Pelaaja getOmistaja();
    
}
