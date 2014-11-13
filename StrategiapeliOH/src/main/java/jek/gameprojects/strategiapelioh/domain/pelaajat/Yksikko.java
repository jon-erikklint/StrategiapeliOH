package jek.gameprojects.strategiapelioh.domain.pelaajat;

import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuva;
import java.util.Objects;
import jek.gameprojects.strategiapelioh.domain.RajoitettuLaskuri;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;

public class Yksikko implements Liikkuva, Omistettava{
    
    private final int id;
    private Pelaaja omistaja;
    private Joukko joukko;
    
    private final Yksikkotyyppi yksikkotyyppi;
    private final RajoitettuLaskuri liikkuvuus;
    
    private Koordinaatti sijainti;
    
    public Yksikko(Yksikkotyyppi yksikkotyyppi, Koordinaatti sijainti, Pelaaja pelaaja, Joukko joukko, int id){
        this.yksikkotyyppi=yksikkotyyppi;
        this.liikkuvuus=new RajoitettuLaskuri(yksikkotyyppi.getLiikuntakyky().getLiikuntamaara(), 0);
        this.sijainti=sijainti;
        
        this.omistaja=pelaaja;
        this.joukko=joukko;
        
        this.id=id;
        
        this.joukko.lisaaYksikko(this);
    }

    @Override
    public int liikkuvuus() {
        return liikkuvuus.getArvo();
    }

    @Override
    public void liiku(int kuluvaLiikemaara, Koordinaatti kohdesijainti) {
        this.sijainti=kohdesijainti;
        liikkuvuus.lisaaArvoa(-kuluvaLiikemaara);
    }
    
    @Override
    public Liikkuvuus liikuntakyky() {
        return yksikkotyyppi.getLiikuntakyky();
    }
    
    public Yksikkotyyppi getYksikkotyyppi() {
        return yksikkotyyppi;
    }

    @Override
    public Koordinaatti getSijainti() {
        return sijainti;
    }

    public void setSijainti(Koordinaatti sijainti) {
        this.sijainti = sijainti;
    }

    @Override
    public Pelaaja getOmistaja() {
        return omistaja;
    }

    public void setOmistaja(Pelaaja omistaja) {
        this.omistaja = omistaja;
    }

    public Joukko getJoukko() {
        return joukko;
    }

    public void setJoukko(Joukko joukko) {
        this.joukko = joukko;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.omistaja);
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Yksikko other = (Yksikko) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return id+"";
    }
  
}
