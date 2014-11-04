package jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen;

import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Omistettava;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public interface Liikkuva extends Omistettava{
    
    public int liikkuvuus();
    
    public Liikkuvuus liikuntakyky();
    
    public Vektori getSijainti();
    
    @Override
    public Pelaaja getOmistaja();
    
    public void liiku(int kuluvaLiikemaara, Vektori kohdesijainti);
}
