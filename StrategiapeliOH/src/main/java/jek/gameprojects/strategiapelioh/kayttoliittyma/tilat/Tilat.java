package jek.gameprojects.strategiapelioh.kayttoliittyma.tilat;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.peli.Kierros;
import jek.gameprojects.strategiapelioh.domain.peli.Vuoro;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.RuudunKuva;

/**
 * 
 * Luokka joka sisältää tämänhetkiset valintatilat ja tiedon vuorosta ja kierroksesta
 * 
 */
public class Tilat {
    
    private int pelitila;
    private RuudunKuva valittuRuutu;
    private Joukko valitutYksikot;
    
    private Tila<Vuoro> vuoro;
    private Tila<Kierros> kierros;

    public Tilat(int pelitila, RuudunKuva valittuRuutu, Joukko valitutYksikot, Tila<Vuoro> vuoro, Tila<Kierros> kierros) {
        this.pelitila = pelitila;
        this.valittuRuutu = valittuRuutu;
        this.valitutYksikot = valitutYksikot;
        
        this.vuoro = vuoro;
        this.kierros = kierros;
    }
    
    /**
     * 
     * Asettaa valintatilat oletustiloihinsa. Pelitila nollaksi ja valittu ruutu sekä valitut yksiköt nulleiksi
     * 
     */
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

    public RuudunKuva getValittuRuutu() {
        return valittuRuutu;
    }

    public void setValittuRuutu(RuudunKuva valittuRuutu) {
        this.valittuRuutu = valittuRuutu;
    }

    public Joukko getValitutYksikot() {
        return valitutYksikot;
    }

    public void setValitutYksikot(Joukko valitutYksikot) {
        this.valitutYksikot = valitutYksikot;
    }

    public Tila<Vuoro> getVuoro() {
        return vuoro;
    }

    public void setVuoro(Tila<Vuoro> vuoro) {
        this.vuoro = vuoro;
    }

    public Tila<Kierros> getKierros() {
        return kierros;
    }

    public void setKierros(Tila<Kierros> kierros) {
        this.kierros = kierros;
    }
    
}
