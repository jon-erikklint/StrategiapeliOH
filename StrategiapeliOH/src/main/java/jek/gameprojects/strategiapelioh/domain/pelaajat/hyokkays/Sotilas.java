package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

import jek.gameprojects.strategiapelioh.logiikka.laskurit.RajoitettuLaskuri;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;

/**
 * 
 * Yksikkö joka on kykenevä hyökkäämään
 * 
 */

public class Sotilas extends Yksikko implements Hyokkaava{

    private RajoitettuLaskuri elamat;
    private Ase aktiivinenAse;
    
    public Sotilas(Yksikkotyyppi yksikkotyyppi, Koordinaatti sijainti, Pelaaja pelaaja, Joukko joukko, int id){
        super(yksikkotyyppi, sijainti, pelaaja, joukko, id);
        
        elamat = new RajoitettuLaskuri(yksikkotyyppi.getHyokkays().getMaksimiElamat(), 0, yksikkotyyppi.getHyokkays().getMaksimiElamat());
        aktiivinenAse = yksikkotyyppi.getHyokkays().getAseet().get(0);
    }
    
    @Override
    public void menetaElamaa(int maara){
        elamat.lisaaArvoa(-maara);
    }
    
    @Override
    public double hyokkayskerroin(){
        return elamat.getArvo()/(double)elamat.getYlaraja();
    }
    
    @Override
    public boolean onkoKuollut(){
        return elamat.getArvo()<=0;
    }
    
    @Override
    public Hyokkays hyokkays() {
        return super.getYksikkotyyppi().getHyokkays();
    }

    @Override
    public int getElamat() {
        return elamat.getArvo();
    }
    
    @Override
    public void setElamat(int maara){
        elamat.setArvo(maara);
    }

    @Override
    public int getMaksimiElamat() {
        return elamat.getYlaraja();
    }   

    @Override
    public Ase getAktiivinenAse() {
        return aktiivinenAse;
    }

    @Override
    public void setAktiivinenAse(Ase aktiivinenAse) {
        this.aktiivinenAse = aktiivinenAse;
    }
    
}
