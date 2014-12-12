package jek.gameprojects.strategiapelioh.domain.kartta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;

/**
 * 
 * Kartan perusyksikkö, jolla on sijainti, maasto ja mahdollisesti joukkoja
 * 
 */

public class Ruutu {
    
    private Koordinaatti sijainti;
    private Maasto maasto;
    
    private List<Joukko> joukot;

    public Ruutu(Koordinaatti sijainti, Maasto maasto) {
        this.sijainti = sijainti;
        this.maasto = maasto;
        
        joukot=new ArrayList<>();
    }
    
    /**
     * Antaa ruudussa olevan ensimmäisen joukon. Tällä hetkellä joukkolistan ensimmäisen jäsenen. Jos sitä ei ole, palauttaa nullin.
     * 
     * @return joukkolistan ensimmäinen jäsen
     */
    public Joukko annaEnsimmainenJoukko(){
        if(joukot.isEmpty()){
            return null;
        }
        
        return joukot.get(0);
    }
    
    
    /**
     * Kertoo kuinka monta yksikköä ruudussa on yhteensä.
     * 
     * @return yksiköiden määrä
     */
    public int yksikoidenMaara(){
        int maara = 0;
        
        for(Joukko joukko : joukot){
            maara+=joukko.getYksikot().size();
        }
        
        return maara;
    }
    
    /**
     * Palauttaa kaikki ruudussa olevat yksiköt jokaisesta siinä olevasta joukosta
     * 
     * @return ruudussa olevat yksiköt
     */
    public List<Yksikko> getYksikot(){
        List<Yksikko> yksikot = new ArrayList<>();
        
        for(Joukko joukko : joukot){
            yksikot.addAll(joukko.getYksikot());
        }
        
        return yksikot;
    }
    
    /**
     * Lisää joukon ruutuun. Palauttaa totuusarvon sen mukaan onko siirto mahdollinen ja tapahtuiko se.
     * 
     * @param joukko siirrettävä joukko
     * @return onnistuiko siirto
     */
    public boolean lisaaJoukko(Joukko joukko){
        if(joukot.isEmpty()){
            joukot.add(joukko);
            return true;
        }
        
        if(joukot.get(0).getOmistaja().equals(joukko.getOmistaja())){
            joukot.add(joukko);
            return true;
        }
        
        return false;
    }
    
    /**
     * Poistaa annetun joukon ruudusta
     * 
     * @param joukko poistettava
     * @return onnistuiko poistaminen
     */
    public boolean poistaJoukko(Joukko joukko){
        if(joukot.contains(joukko)){
            joukot.remove(joukko);
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Kertoo minkä pelaajan hallussa ruutu on siinä sijaitsevien joukkojen perusteella.
     * 
     * @return kenen hallussa ruutu on
     */
    public Pelaaja kenenHallussa(){
        if(joukot.isEmpty()){
            return null;
        }
        
        return joukot.get(0).getOmistaja();
    }
    
    public Maasto getMaasto() {
        return maasto;
    }

    public void setMaasto(Maasto maasto) {
        this.maasto = maasto;
    }

    public Koordinaatti getSijainti() {
        return sijainti;
    }

    public void setSijainti(Koordinaatti sijainti) {
        this.sijainti = sijainti;
    }

    public List<Joukko> getJoukot() {
        return joukot;
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        
        if(o.getClass()!=this.getClass()){
            return false;
        }
        
        Ruutu ruutu = (Ruutu) o;
        
        return this.sijainti.equals(ruutu.sijainti);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.sijainti);
        hash = 71 * hash + Objects.hashCode(this.maasto);
        return hash;
    }
    
    @Override
    public String toString(){
        return "["+maasto.getAluetyyppi()+","+maasto.getMaastotyyppi()+"]";
    }
    
}
