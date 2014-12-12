package jek.gameprojects.strategiapelioh.logiikka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
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
    
    private List<Pelaaja> pelaajat;
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
        this.pelaajat = new ArrayList<>(pelaajat.values());
        
        this.joukkojenHallinnoija = new JoukkojenHallinnoija(this.pelaajat, kartta);
        
        this.yksikoidenLuoja = new YksikoidenLuoja(kartta, pelaajat, yksikkotyypit, yksikoidenIndeksoija, joukkojenHallinnoija);
        this.yksikoidenPoistaja = new YksikoidenPoistaja(joukkojenHallinnoija);
        
        this.liikuttaja = new Liikuttaja(kartta, joukkojenHallinnoija);
        this.hyokkayshallinnoija = new Hyokkayshallinnoija(joukkojenHallinnoija, kartta, panssarityyppienVahvuudet);
    }
    
    /**
     * Tarkistaa onko joku voittanut pelin. Jos vain yksi pelaaja on jäljellä, 
     * palauttaa kyseisen pelaajan, jos monta henkilöä on jäljellä, palauttaa nullin
     * ja jos ketään ei ole jäljellä, palauttaa uuden pelaajan nimellä "Ei voittajaa" ja indeksillä -1
     * 
     * @return kuka on voittanut
     */
    public Pelaaja tarkistaVoittaja(){
        int elossaOlevat = pelaajat.size();
        Pelaaja viimeisinElossaoleva = null;
        
        for(Pelaaja pelaaja : pelaajat){
            if(onkoPelaajaElossa(pelaaja)){
                viimeisinElossaoleva = pelaaja;
            }else{
                elossaOlevat--;
            }
        }
        
        return annaVoittaja(elossaOlevat, viimeisinElossaoleva);
    }
    
    private boolean onkoPelaajaElossa(Pelaaja pelaaja){
        for(Joukko joukko : pelaaja.getJoukot()){
            if(!joukko.getYksikot().isEmpty()){
                return true;
            }
        }
        
        return false;
    }
    
    private Pelaaja annaVoittaja(int elossaOlevat, Pelaaja viimeisinElossaoleva){
        if(elossaOlevat>1){
            return null;
        }else if(elossaOlevat == 1){
            return viimeisinElossaoleva;
        }else{
            return new Pelaaja(-1, "Ei voittajaa");
        }
    }
    
    /**
     * 
     * Siirtää logiikan vuoron eteenpäin. Päivittää tällöin vuoroa ja mahdollisesti 
     * kierrosta sekä palauttaa pelaajien toiminnot.
     * 
     */
    public void eteneVuoro(){
        kierros.lisaaVuoro(vuoro);
        
        if(vuorottaja.onkoSeuraavaKierros()){   
            kierros = kierros.getSeuraavaKierros();
        }
        
        vuoro = vuorottaja.annaSeuraavaVuoro();
        
        taytaPelaajanToiminnot(vuoro.getPelaaja());
        nollaaLogiikka();
        
    }
    
    /**
     * Palauttaa kaikki pelaajan yksiköt toimintakuntoon
     * 
     * @param pelaaja 
     */
    public void taytaPelaajanToiminnot(Pelaaja pelaaja){
        List<Joukko> pelaajanJoukot = pelaaja.getJoukot();
        
        for(Joukko joukko : pelaajanJoukot){
            joukko.palautaYksikoidenToiminnot();
        }
    }
    
    /**
     * 
     * Tyhjentää logiikkaluokkien tilanteen
     * 
     */
    public void nollaaLogiikka(){
        liikuttaja.nollaa();
        hyokkayshallinnoija.nollaa();
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
