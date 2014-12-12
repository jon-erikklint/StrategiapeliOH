package jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen;

import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Omistettava;

/**
 * 
 * Rajapinta, jonka toteuttavat oliot pystyvät liikkumaan sijainnista toiseen itsenäisesti
 * 
 */

public interface Liikkuva extends Omistettava{
    
    /**
     * Palauttaa kuinka monta ruutua liikkuva voi liikkua vielä tällä vuorolla.
     * 
     * @return liikuntamäärä ruuduissa
     */
    public int liikkuvuus();
    
    
    /**
     * Palauttaa Liikkuvuus:en, joka on tietopakkaus liikkuvan liikkuvuuteen 
     * liittyvistä tiedoista.
     * 
     * @return liikkuvuus
     */
    public Liikkuvuus liikuntakyky();
    
    /**
     * Palauttaa tiedon siitä missä yksikkö on nyt
     * 
     * @return sijainti
     */
    public Koordinaatti getSijainti();
    
    /**
     * 
     * Liikuttaa liikkuvan annettuun koordinaattiin ja poistaa siltä annetun määrän liikemäärää tältä vuorolta.
     * 
     * @param kuluvaLiikemaara vähennettävä liikemäärä tältä vuorolta
     * @param kohdesijainti sijainti johon liikkuva siirretään
     */
    public void liiku(int kuluvaLiikemaara, Koordinaatti kohdesijainti);
}
