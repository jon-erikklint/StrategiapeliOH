package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Omistettava;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public interface Hyokkaava extends Omistettava{
    
    public boolean onkoHyokkaava();
    
    public Hyokkays hyokkays();
    
    public Koordinaatti getSijainti();
    
    @Override
    public Pelaaja getOmistaja();
    
}
