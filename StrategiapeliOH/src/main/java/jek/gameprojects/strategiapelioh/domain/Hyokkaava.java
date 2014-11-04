package jek.gameprojects.strategiapelioh.domain;

import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Hyokkays;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public interface Hyokkaava{
    
    public Hyokkays hyokkays();
    
    public Vektori getSijainti();
    
    public Pelaaja getOmistaja();
    
}
