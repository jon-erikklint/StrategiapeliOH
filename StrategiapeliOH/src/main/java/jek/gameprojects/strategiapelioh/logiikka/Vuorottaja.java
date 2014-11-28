package jek.gameprojects.strategiapelioh.logiikka;

import java.util.List;
import jek.gameprojects.strategiapelioh.logiikka.laskurit.KiertavaLaskuri;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.peli.Vuoro;

/**
 * 
 *Logiikkaluokak jonka vastuulla on kertoa kenen vuoro on seuraavaksi
 * 
 */

public class Vuorottaja {
    
    private List<Pelaaja> pelaajat;
    private KiertavaLaskuri vuorokierto;
    
    public Vuorottaja(List<Pelaaja> pelaajat){
        this.pelaajat=pelaajat;
        
        vuorokierto = new KiertavaLaskuri(pelaajat.size(), 0, 0);
    }
    
    public boolean onkoSeuraavaKierros(){
        return vuorokierto.getArvo() == 0;
    }
    
    public Vuoro annaSeuraavaVuoro(){
        Pelaaja vuorossaOlija = pelaajat.get(vuorokierto.getArvo());
        vuorokierto.lisaaArvoa(1);
        
        return new Vuoro(vuorossaOlija);
    }
    
}
