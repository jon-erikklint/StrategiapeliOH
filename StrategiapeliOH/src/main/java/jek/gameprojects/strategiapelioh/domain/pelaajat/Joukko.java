package jek.gameprojects.strategiapelioh.domain.pelaajat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;

/**
 * 
 * Monien yksiköiden muodostama joukko, yksiköidenhallinnan peruspalikka
 * 
 */

public class Joukko implements Omistettava{

    private List<Yksikko> yksikot;
    
    private Koordinaatti sijainti;
    private Pelaaja omistaja;
    
    public Joukko(){
        yksikot=new ArrayList<>();
    }
    
    /**
     * 
     * Palauttaa joukossa olevat yksiköt täyteen toimintavalmiuteen vuoron vaihtuessa
     * 
     */
    public void palautaYksikoidenToiminnot(){
        for(Yksikko yksikko : yksikot){
            yksikko.palaututaToiminnot();
        }
    }
    
    
    /**
     * Lisää yksikön joukkoon. Jos yksikkö on ensimmäinen joukon yksikkö, asettaa metodi alkuarvot joukon sijainnille ja omistajalle.
     * 
     * @param yksikko lisättävä yksikkö
     * @return onnistuiko lisäys
     */
    public boolean lisaaYksikko(Yksikko yksikko){
        if(yksikot.isEmpty()){
            lisaaUusiYksikko(yksikko);
            
            sijainti = yksikko.getSijainti();
            omistaja = yksikko.getOmistaja();
            
            return true;
        }
        
        if(yksikko.getOmistaja().equals(omistaja)){
            lisaaUusiYksikko(yksikko);
            
            return true;
        }
        
        return false;
    }
    
    private void lisaaUusiYksikko(Yksikko yksikko){
        yksikot.add(yksikko);
        yksikko.setJoukko(this);
    }
    
    /**
     * Poistaa yksikön joukosta
     * 
     * @param yksikko poistettava
     */
    public void poistaYksikko(Yksikko yksikko){
        yksikot.remove(yksikko);
    }
    
    public List<Yksikko> getYksikot(){
        return yksikot;
    }
    
    @Override
    public Pelaaja getOmistaja(){
        return omistaja;
    }

    public Koordinaatti getSijainti() {
        return sijainti;
    }
    
    /**
     * Asettaa joukon ja kaikki sen sisällä olevat yksiköt annettuun sijaintiin
     * 
     * @param sijainti 
     */
    public void setSijainti(Koordinaatti sijainti){
        for(Yksikko yksikko:yksikot){
            yksikko.setSijainti(sijainti);
        }
        
        this.sijainti=sijainti;
    }
    
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        
        if(o.getClass()!=this.getClass()){
            return false;
        }
        
        Joukko toinenJoukko=(Joukko) o;
        
        if(this.yksikot.isEmpty()){
            
            return toinenJoukko.getYksikot().isEmpty() && toinenJoukko.sijainti == this.sijainti;
            
        }
        
        if(toinenJoukko.yksikot.isEmpty()){
            return this.getYksikot().isEmpty() && toinenJoukko.sijainti == this.sijainti;
        }
        
        return toinenJoukko.getYksikot().get(0).equals(yksikot.get(0));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.yksikot);
        hash = 13 * hash + Objects.hashCode(this.sijainti);
        return hash;
    }
    
}
