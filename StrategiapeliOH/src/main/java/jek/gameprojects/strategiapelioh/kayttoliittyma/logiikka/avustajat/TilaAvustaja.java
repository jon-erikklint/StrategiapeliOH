package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Tila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;

public class TilaAvustaja {
    
    private Tila<Integer> pelitila;
    private Tila<Ruutu> valittuRuutu;
    private Tila<Joukko> valitutYksikot;
    
    private GrafiikkaSailio ruudut;

    public TilaAvustaja(Tila<Integer> pelitila, Tila<Ruutu> valittuRuutu, Tila<Joukko> valitutYksikot, GrafiikkaSailio ruudut) {
        this.pelitila = pelitila;
        this.valittuRuutu = valittuRuutu;
        this.valitutYksikot = valitutYksikot;
        
        this.ruudut = ruudut;
    }
    
    public void nollaaTilanne(){
        ruudut.paivita();
        
        pelitila.setMuuttuja(0);
        valittuRuutu.setMuuttuja(null);
        valitutYksikot.setMuuttuja(null);
    }

    public Tila<Integer> getPelitila() {
        return pelitila;
    }

    public void setPelitila(Tila<Integer> pelitila) {
        this.pelitila = pelitila;
    }

    public Tila<Ruutu> getValittuRuutu() {
        return valittuRuutu;
    }

    public void setValittuRuutu(Tila<Ruutu> valittuRuutu) {
        this.valittuRuutu = valittuRuutu;
    }

    public Tila<Joukko> getValitutYksikot() {
        return valitutYksikot;
    }

    public void setValitutYksikot(Tila<Joukko> valitutYksikot) {
        this.valitutYksikot = valitutYksikot;
    }
    
    
    
}
