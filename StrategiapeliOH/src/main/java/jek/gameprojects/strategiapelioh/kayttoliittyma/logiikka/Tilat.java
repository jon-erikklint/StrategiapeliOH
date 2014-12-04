package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;

public class Tilat {
    
    private int pelitila;
    private Ruutu valittuRuutu;
    private Joukko valitutYksikot;

    public Tilat(int pelitila, Ruutu valittuRuutu, Joukko valitutYksikot) {
        this.pelitila = pelitila;
        this.valittuRuutu = valittuRuutu;
        this.valitutYksikot = valitutYksikot;
    }
    
    public void nollaaTilanne(){
        pelitila = 0;
        valittuRuutu = null;
        valitutYksikot = null;
    }

    public int getPelitila() {
        return pelitila;
    }

    public void setPelitila(int pelitila) {
        this.pelitila = pelitila;
    }

    public Ruutu getValittuRuutu() {
        return valittuRuutu;
    }

    public void setValittuRuutu(Ruutu valittuRuutu) {
        this.valittuRuutu = valittuRuutu;
    }

    public Joukko getValitutYksikot() {
        return valitutYksikot;
    }

    public void setValitutYksikot(Joukko valitutYksikot) {
        this.valitutYksikot = valitutYksikot;
    }
    
    
    
}
