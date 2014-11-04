package jek.gameprojects.strategiapelioh.domain.kartta;

import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public class Ruutu {
    
    private Vektori sijainti;
    private Maasto maasto;

    public Ruutu(Vektori sijainti, Maasto maasto) {
        this.sijainti = sijainti;
        this.maasto = maasto;
    }
    
    public Pelaaja kenenHallussa(){
        return null;
    }
    
    public Maasto getMaasto() {
        return maasto;
    }

    public void setMaasto(Maasto maasto) {
        this.maasto = maasto;
    }

    public Vektori getSijainti() {
        return sijainti;
    }

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }
    
    
}
