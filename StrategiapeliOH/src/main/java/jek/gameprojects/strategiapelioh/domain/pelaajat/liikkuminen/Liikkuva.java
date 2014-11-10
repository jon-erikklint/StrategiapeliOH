package jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen;

import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Omistettava;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public interface Liikkuva extends Omistettava{
    
    public int liikkuvuus();
    
    public Liikkuvuus liikuntakyky();
    
    public Koordinaatti getSijainti();
    
    @Override
    public Pelaaja getOmistaja();
    
    public void liiku(int kuluvaLiikemaara, Koordinaatti kohdesijainti);
}
