package jek.gameprojects.strategiapelioh.domain.pelaajat;

import jek.gameprojects.strategiapelioh.domain.Liike;
import jek.gameprojects.strategiapelioh.domain.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.Liikuntakyky;
import jek.gameprojects.strategiapelioh.domain.RajoitettuLaskuri;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;

public class Yksikko implements Liikkuva{
    
    private final Yksikkotyyppi yksikkotyyppi;
    
    private Vektori sijainti;
    private final RajoitettuLaskuri liikkuvuus;
    
    public Yksikko(Yksikkotyyppi yksikkotyyppi, Vektori sijainti){
        this.yksikkotyyppi=yksikkotyyppi;
        liikkuvuus=new RajoitettuLaskuri(yksikkotyyppi.getLiikkuvuus(), 0);
    }

    @Override
    public int liikkuvuus() {
        return liikkuvuus.getArvo();
    }

    @Override
    public void liiku(Liike liike) {
        this.sijainti=liike.getKohde();
        liikkuvuus.lisaaArvoa(liike.getTarvittavaLiikunta());
    }
    
    @Override
    public Liikuntakyky liikuntakyky() {
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

}
