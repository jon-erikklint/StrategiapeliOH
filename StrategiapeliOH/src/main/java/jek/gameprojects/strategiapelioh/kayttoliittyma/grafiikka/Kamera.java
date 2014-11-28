package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class Kamera{
    
    private Vektori kartanKoko;
    
    private Vektori sijainti;
    private Vektori koko;
    
    public Kamera(Vektori sijainti, Vektori koko, Vektori kartanKoko){
        this.kartanKoko = kartanKoko;
        
        this.sijainti = sijainti;
        this.koko = koko;
    }
    
    public Vektori[] koordinaatinmuutos(Vektori sijainti, Vektori koko){
        Vektori[] sijaintitiedot = new Vektori[2];
        sijaintitiedot[0] = sijainti;
        sijaintitiedot[1] = koko;
        
        return koordinaatinmuutos(sijaintitiedot);
    }
    
    public Vektori[] koordinaatinmuutos(Vektori[] sijaintitiedot){
        double sx = sijaintitiedot[0].getX();
        double sy = sijaintitiedot[0].getY();
        double kx = sijaintitiedot[1].getX();
        double ky = sijaintitiedot[1].getY();
        
        if(sx > sijainti.getX()+koko.getX() || sx+kx<sijainti.getX() || sy > sijainti.getY()+koko.getY() || sy+ky < sijainti.getY()){
            return null;
        }
        
        Vektori[] palautettava = new Vektori[2];
        
        palautettava[0] = new Vektori(sx-sijainti.getX(), sy-sijainti.getX());
        palautettava[1] = new Vektori(kx * (kartanKoko.getX()/koko.getX()), ky * (kartanKoko.getY()/koko.getY()));
        
        return palautettava;
    }

    public Vektori getKartanKoko() {
        return kartanKoko;
    }

    public void setKartanKoko(Vektori kartanKoko) {
        this.kartanKoko = kartanKoko;
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

}
