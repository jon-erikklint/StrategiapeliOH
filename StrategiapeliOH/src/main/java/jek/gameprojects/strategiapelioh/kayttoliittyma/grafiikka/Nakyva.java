package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Tasollinen;

/**
 * 
 * Rajapinta jonka toteuttavat luokat toteuttavat jollakin tavalal näkyvyyden. Tämä voit tarkoittaa esimerkiksi aktiivisuutta.
 * 
 */
public interface Nakyva extends Tasollinen{
    
    public void setNakyvyys(boolean nakyvyys);
    public boolean getNakyvyys();
    
}
