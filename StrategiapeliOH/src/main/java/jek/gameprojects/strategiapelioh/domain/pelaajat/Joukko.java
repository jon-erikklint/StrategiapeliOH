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
    
    public void palautaYksikoidenToiminnot(){
        for(Yksikko yksikko : yksikot){
            yksikko.palaututaToiminnot();
        }
    }
    
    @Override
    public Pelaaja getOmistaja(){
        return omistaja;
    }
    
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
    
    public void poistaYksikko(Yksikko yksikko){
        yksikot.remove(yksikko);
    }
    
    public List<Yksikko> getYksikot(){
        return yksikot;
    }
    
    public int liikkuvuus() {
        int liikkuvuus=yksikot.get(0).liikkuvuus();
        
        for(Yksikko yksikko:yksikot){
            if(yksikko.liikkuvuus()<liikkuvuus){
                liikkuvuus=yksikko.liikkuvuus();
            }
        }
        
        return liikkuvuus;
    }

    public Koordinaatti getSijainti() {
        return sijainti;
    }
    
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
