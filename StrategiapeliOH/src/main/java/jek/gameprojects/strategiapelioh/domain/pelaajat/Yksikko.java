package jek.gameprojects.strategiapelioh.domain.pelaajat;

import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuva;
import java.util.Objects;
import jek.gameprojects.strategiapelioh.domain.RajoitettuLaskuri;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;

public class Yksikko implements Liikkuva, Omistettava{
    
    private Pelaaja omistaja;
    
    private final int id;
    
    private final Yksikkotyyppi yksikkotyyppi;
    
    private Vektori sijainti;
    private final RajoitettuLaskuri liikkuvuus;
    
    public Yksikko(Yksikkotyyppi yksikkotyyppi, Vektori sijainti, Pelaaja pelaaja, int id){
        this.yksikkotyyppi=yksikkotyyppi;
        liikkuvuus=new RajoitettuLaskuri(yksikkotyyppi.getLiikkuvuus(), 0);
        this.omistaja=pelaaja;
        this.sijainti=sijainti;
        
        this.id=id;
    }

    @Override
    public int liikkuvuus() {
        return liikkuvuus.getArvo();
    }

    @Override
    public void liiku(int kuluvaLiikemaara, Vektori kohdesijainti) {
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
    public Vektori getSijainti() {
        return sijainti;
    }

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    @Override
    public Pelaaja getOmistaja() {
        return omistaja;
    }

    public void setOmistaja(Pelaaja omistaja) {
        this.omistaja = omistaja;
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
    
    
  
}
