package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Efekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class NelioPainike extends EfektiPainike{

    private Vektori sijainti;
    private Vektori koko;
    
    private int taso;
    
    private boolean onkoAktiivinen;

    public NelioPainike(Efekti efekti, Vektori sijainti, Vektori koko, int taso) {
        super(efekti);
        this.sijainti = sijainti;
        this.koko = koko;
        
        onkoAktiivinen = true;
    }
    
    public Vektori getSijainti() {
        return sijainti;
    }

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    public Vektori getKoko() {
        return koko;
    }

    public void setKoko(Vektori koko) {
        this.koko = koko;
    }
    
    @Override
    public int getTaso(){
        return taso;
    }
    
    @Override
    public boolean onkoPaalla(Vektori vektori, Kamera kamera) {
        Vektori[] muunnettuSijainti = kamera.koordinaatinmuutos(sijainti, koko);
        
        double vx = vektori.getX();
        double vy = vektori.getY();
        double x = muunnettuSijainti[0].getX();
        double y = muunnettuSijainti[0].getY();
        double lev = muunnettuSijainti[1].getX();
        double kor = muunnettuSijainti[1].getY();
        
        return (vx>=x && vx<x+lev) && (vy>=y && vy<y+kor);
    }
    
    @Override
    public boolean getNakyvyys(){
        return onkoAktiivinen;
    }
    
    @Override
    public void setNakyvyys(boolean nakyva){
        onkoAktiivinen = nakyva;
    }

    @Override
    public void paivita() {}
    
}
