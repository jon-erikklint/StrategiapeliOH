package jek.gameprojects.strategiapelioh.domain;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Liikkuvuus;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;

public interface Liikkuva {
    
    public int liikkuvuus();
    
    public Liikkuvuus liikuntakyky();
    
    public Vektori getSijainti();
    
    public void liiku(Liike liike);
}
