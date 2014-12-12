package jek.gameprojects.strategiapelioh.logiikka.laskurit;

/**
 * 
 * Rajapinta jonka toteuttavat luokat tallettavat int-lukua joidenkin sääntöjen mukaan
 * 
 */

public abstract class Laskuri {
    
    /**
     * Lisaa laskurin arvoa annetun arvon verran
     * 
     * @param maara 
     */
    public abstract void lisaaArvoa(int maara);
    
    /**
     * Asettaa laskurin arvon annettuun arvoon
     * 
     * @param arvo 
     */
    public abstract void setArvo(int arvo);
    
    /**
     * Palauttaa laskurin tämänhetkisen arvon
     * 
     * @return nykyinen arvo
     */
    public abstract int getArvo();
    
}
