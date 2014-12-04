package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Tasollinen;

public interface Nakyva extends Tasollinen{
    
    public void setNakyvyys(boolean nakyvyys);
    public boolean getNakyvyys();
    
}
