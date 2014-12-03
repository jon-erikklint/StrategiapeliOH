package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Nakyva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public interface Painike extends Nakyva{
    
    public int getTaso();
    
    public boolean onkoPaalla(Vektori vektori, Kamera kamera);
    
    public void toimi();
    
}
