package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Nakyva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

/**
 * 
 * Ruudulla sijaitseva painike, joka reagoi siihen kohdistuneisiin hiiren painalluksiin
 * 
 */
public interface Painike extends Nakyva{
    
    public boolean onkoPaalla(Vektori vektori, Kamera kamera);
    
    public void toimi();
    
}
