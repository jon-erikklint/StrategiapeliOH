package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class Kamera{
    
    private Vektori kartanKoko;
    
    private Vektori sijainti;
    private Vektori koko;
    
    public Kamera(Vektori kartanKoko, Vektori sijainti, Vektori koko){
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
        Vektori[] palautettava = new Vektori[2];
        
        palautettava[0] = muutaSijainti(sijaintitiedot[0]);
        palautettava[1] = muutaKoko(sijaintitiedot[1]);
        
        return palautettava;
    }
    
    public Vektori muutaSijainti(Vektori sijainti){
        double sx = sijainti.getX();
        double sy = sijainti.getY();
        
        return new Vektori(sx - this.sijainti.getX() * kokosuhdeX(), sy - this.sijainti.getY() * kokosuhdeY());
    }
    
    public Vektori muutaKoko(Vektori koko){
        double kx = koko.getX();
        double ky = koko.getY();
        
        return new Vektori(kx * kokosuhdeX(), ky * kokosuhdeY());
    }
    
    public double kokosuhdeX(){
        return kartanKoko.getX()/koko.getX();
    }
    
    public double kokosuhdeY(){
        return kartanKoko.getY()/koko.getY();
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
