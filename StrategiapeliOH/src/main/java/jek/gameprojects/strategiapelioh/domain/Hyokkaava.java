package jek.gameprojects.strategiapelioh.domain;

import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Hyokkays;

public interface Hyokkaava {
    
    public Hyokkays hyokkays();
    
    public Vektori getSijainti();
    
}
