package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Paivittyva;

public interface Nakyva extends Paivittyva{
    
    public void setNakyvyys(boolean nakyvyys);
    public boolean getNakyvyys();
    
}
