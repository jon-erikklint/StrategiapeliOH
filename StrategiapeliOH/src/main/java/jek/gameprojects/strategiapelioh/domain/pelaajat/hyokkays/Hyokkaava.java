package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Omistettava;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public interface Hyokkaava extends Omistettava{
    
    public Hyokkays hyokkays();
    
    public Vektori getSijainti();
    
    @Override
    public Pelaaja getOmistaja();
    
}
