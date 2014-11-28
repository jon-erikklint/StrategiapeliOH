package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public abstract class NelioPainike implements Painike{

    private Vektori sijainti;
    private Vektori koko;
    
    private int taso;

    public NelioPainike(Vektori sijainti, Vektori koko, int taso) {
        this.sijainti = sijainti;
        this.koko = koko;
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
    
}
