package jek.gameprojects.strategiapelioh.logiikka;

import java.util.ArrayList;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.domain.peli.Kierros;
import jek.gameprojects.strategiapelioh.domain.peli.Vuoro;
import jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen.Hyokkayshallinnoija;
import jek.gameprojects.strategiapelioh.logiikka.liikkuminen.Liikuttaja;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.JoukkojenHallinnoija;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.YksikoidenLuoja;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.YksikoidenPoistaja;

/**
 * 
 * Pelin peruslogiikkapakkaus, joka sisältää kaikki muut logiikan komponentit ja tiedot vuorosta
 * 
 */
public class Peli {
    
    private Kierros kierros;
    private Vuoro vuoro;
    private Vuorottaja vuorottaja;
    
    private Kartta kartta;
    
    private YksikoidenLuoja yksikoidenLuoja;
    private YksikoidenPoistaja yksikoidenPoistaja;
    private Liikuttaja liikuttaja;
    private Hyokkayshallinnoija hyokkayshallinnoija;
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    public Peli(Map<Integer, Pelaaja> pelaajat, Kartta kartta, Map<String, Yksikkotyyppi> yksikkotyypit, Indeksoija yksikoidenIndeksoija, Map<Asetyyppi, Map<Panssarityyppi, Double>> panssarityyppienVahvuudet){
        
        this.kierros = new Kierros(1);
        this.vuorottaja = new Vuorottaja(new ArrayList<>(pelaajat.values()));
        this.vuoro = vuorottaja.annaSeuraavaVuoro();
        
        this.kartta = kartta;
        
        this.yksikoidenLuoja = new YksikoidenLuoja(kartta, pelaajat, yksikkotyypit, yksikoidenIndeksoija);
        this.yksikoidenPoistaja = new YksikoidenPoistaja();
        
        this.liikuttaja = new Liikuttaja(kartta);
        this.hyokkayshallinnoija = new Hyokkayshallinnoija(kartta, panssarityyppienVahvuudet);
        
        this.joukkojenHallinnoija = new JoukkojenHallinnoija();
    }
    
    public void eteneVuoro(){
        kierros.lisaaVuoro(vuoro);
        
        if(vuorottaja.onkoSeuraavaKierros()){   
            kierros = kierros.getSeuraavaKierros();
        }
        
        vuoro = vuorottaja.annaSeuraavaVuoro();
        
    }

    public Kierros getKierros() {
        return kierros;
    }

    public Vuoro getVuoro() {
        return vuoro;
    }

    public Vuorottaja getVuorottaja() {
        return vuorottaja;
    }

    public Kartta getKartta() {
        return kartta;
    }

    public YksikoidenLuoja getYksikoidenLuoja() {
        return yksikoidenLuoja;
    }

    public YksikoidenPoistaja getYksikoidenPoistaja() {
        return yksikoidenPoistaja;
    }

    public Liikuttaja getLiikuttaja() {
        return liikuttaja;
    }

    public Hyokkayshallinnoija getHyokkayshallinnoija() {
        return hyokkayshallinnoija;
    }

    public JoukkojenHallinnoija getJoukkojenHallinnoija() {
        return joukkojenHallinnoija;
    }

    public void setJoukkojenHallinnoija(JoukkojenHallinnoija joukkojenHallinnoija) {
        this.joukkojenHallinnoija = joukkojenHallinnoija;
    }
    
    
    
}
