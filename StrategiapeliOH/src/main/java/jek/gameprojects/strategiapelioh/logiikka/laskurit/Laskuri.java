package jek.gameprojects.strategiapelioh.logiikka.laskurit;

/**
 * 
 * Rajapinta jonka toteuttavat luokat tallettavat int-lukua joidenkin sääntöjen mukaan
 * 
 */

public abstract class Laskuri {
    
    public abstract void lisaaArvoa(int maara);
    
    public abstract void setArvo(int arvo);
    
    public abstract int getArvo();
    
}
