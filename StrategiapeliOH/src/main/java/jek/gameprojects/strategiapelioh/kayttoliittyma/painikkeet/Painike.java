package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Tasollinen;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public interface Painike extends Tasollinen{
    
    public boolean onkoPaalla(Vektori vektori, Kamera kamera);
    
    public void toimi();
    
}
