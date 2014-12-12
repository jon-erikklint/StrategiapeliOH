package jek.gameprojects.strategiapelioh.logiikka.yksikot;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;

/**
 * 
 * JoukkojenHallinnoijan tehtävänä on hoitaa joukkojen rakenteisiin liittyvät tehtävät kuten joukkojen yhdistäminen
 * 
 */

public class JoukkojenHallinnoija {
    
    private List<Pelaaja> pelaajat;
    private Kartta kartta;
    
    public JoukkojenHallinnoija(List<Pelaaja> pelaajat, Kartta kartta){
        this.pelaajat = pelaajat;
        this.kartta = kartta;
    }
    
    /**
     * Poistaa kaikki tyhjät joukot kaikilta pelaajilta
     */
    public void poistaTyhjatJoukot(){
        for(Pelaaja pelaaja : pelaajat){
            List<Joukko> poistettavatJoukot = new ArrayList<>();
            
            for(Joukko joukko : pelaaja.getJoukot()){
                if(joukko.getYksikot().isEmpty()){
                    poistettavatJoukot.add(joukko);
                }
            }
            
            poistaJoukot(poistettavatJoukot);
        }
    }
    
    /**
     * Poistaa kaikki tyhjät joukot annetusta ruudusta
     * 
     * @param ruutu ruutu josta joukto poistetaan
     */
    public void poistaTyhjatJoukotRuudusta(Ruutu ruutu){
        List<Joukko> joukot = ruutu.getJoukot();
        List<Joukko> poistettavat = new ArrayList<>();
        
        for(Joukko joukko : joukot){
            
            if(joukko.getYksikot().isEmpty()){
                poistettavat.add(joukko);
            }
            
        }
        
        poistaJoukot(poistettavat);
    }
    
    /**
     * Poistaa annetun joukon sen omistavalta pelaajalta ja ruudusta jossa se sijaitsee
     * 
     * @param joukko poistettava joukko
     */
    public void poistaJoukko(Joukko joukko){
        Ruutu paikka = kartta.getRuutu(joukko.getSijainti());
        
        paikka.poistaJoukko(joukko);
        
        if(joukko.getOmistaja() != null){
            joukko.getOmistaja().poistaJoukko(joukko);
        }
    }
    
    /**
     * Poistaa annetut joukot
     * 
     * @param joukot poistettavat joukot
     */
    public void poistaJoukot(List<Joukko> joukot){
        for(Joukko joukko : joukot){
            poistaJoukko(joukko);
        }
    }
    
    /**
     * Siirtää yksikön aikaisemmasta joukostaan uuteen joukkoon
     * 
     * @param yksikko siirrettävä yksikkö
     * @param joukko kohdejoukko
     */
    public void siirraYksikkoJoukkoon(Yksikko yksikko, Joukko joukko){
        Joukko vanhaJoukko = yksikko.getJoukko();
        
        if(joukko.lisaaYksikko(yksikko)){
            
            vanhaJoukko.poistaYksikko(yksikko);
            
            if(vanhaJoukko.getYksikot().isEmpty()){
                poistaJoukko(vanhaJoukko);
            }
        } 
    }
    
    /**
     * Siirtää toisen annetun joukon kaikki yksiköt toiseen joukkoon
     * 
     * @param kohde joukko johon yksiköt siirretään
     * @param lahde joukko josta yksiköt siirretään
     * @return uusi joukko joka sisältää molemmat joukot
     */
    public Joukko siirraJoukkoJoukkoon(Joukko kohde, Joukko lahde){
        
        for(Yksikko yksikko:lahde.getYksikot()){
            kohde.lisaaYksikko(yksikko);
        }
        
        for(Yksikko yksikko:lahde.getYksikot()){
            lahde.poistaYksikko(yksikko);
        }
        
        poistaJoukko(lahde);
        
        return kohde;
    }
    
    /**
     * Luo yksikölle oman joukkonsa, johon se siirretään
     * 
     * @param yksikko yksikkö jolel tehdään oma joukko
     */
    public void luoYksikolleOmaJoukko(Yksikko yksikko){
        Joukko uusiJoukko = new Joukko();
        
        siirraYksikkoJoukkoon(yksikko, uusiJoukko);
        lisaaJoukkoTarvittaviinPaikkoihin(uusiJoukko);
    }
    
    /**
     * Hajoittaa isomman joukon yhden yksikön joukoiksi
     * 
     * @param joukko hajoitettava joukko
     * @return lista uusista joukoista
     */
    public List<Joukko> hajoitaJoukkoYksittaisenYksikonJoukoiksi(Joukko joukko){
        List<Joukko> uudetJoukot = new ArrayList<>();
        
        if(joukko.getYksikot().isEmpty()){
            uudetJoukot.add(joukko);
            return uudetJoukot;
        }
        
        for(Yksikko yksikko:joukko.getYksikot()){
            luoYksikolleOmaJoukko(yksikko);
            
            uudetJoukot.add(yksikko.getJoukko());
        }
        
        return uudetJoukot;
    }
    
    /**
     * Yhdistää kaikki annetut joukot yhdeksi joukoksi
     * 
     * @param joukot yhdistettävät joukot
     * @return uusi joukko joka sisältää kaikkien annettujen joukkojen yksiköt
     */
    public Joukko yhdistaJuokotYhdeksiJoukoksi(List<Joukko> joukot){
        Joukko uusiJoukko = new Joukko();
        
        for(Joukko joukko : joukot){
            siirraJoukkoJoukkoon(uusiJoukko, joukko);
        }
        
        poistaJoukot(joukot);
        
        return uusiJoukko;
    }
    
    /**
     * Poistaa yksikön omasta joukostaan, jolloin yksikkö käytännössä tuhoutuu
     * 
     * @param yksikko 
     */
    public void poistayksikkoJoukostaan(Yksikko yksikko){
        yksikko.getJoukko().poistaYksikko(yksikko);
    }
    
    /**
     * Lisää annetun joukon sen omistajan joukkoihin ja ruutuun jossa se sijaitsee. Metodia tarvitaan pääasiassa uusien joukkojen luonnissa.
     * 
     * @param joukko 
     */
    public void lisaaJoukkoTarvittaviinPaikkoihin(Joukko joukko){
        Pelaaja joukonOmistaja = joukko.getOmistaja();
        
        if(!joukonOmistaja.getJoukot().contains(joukko)){
            joukonOmistaja.lisaaJoukko(joukko);
        }
        
        Ruutu joukonSijainti = kartta.getRuutu(joukko.getSijainti());
        
        if(!joukonSijainti.getJoukot().contains(joukko)){
            joukonSijainti.lisaaJoukko(joukko);
        }
    }
    
}
