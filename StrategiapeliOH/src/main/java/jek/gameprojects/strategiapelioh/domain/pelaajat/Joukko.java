package jek.gameprojects.strategiapelioh.domain.pelaajat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;

public class Joukko implements Omistettava{

    private List<Yksikko> yksikot;
    
    private Koordinaatti sijainti;
    
    public Joukko(){
        yksikot=new ArrayList<>();
    }
    
    @Override
    public Pelaaja getOmistaja(){
        return yksikot.get(0).getOmistaja();
    }
    
    public boolean lisaaYksikko(Yksikko yksikko){
        if(yksikot.isEmpty()){
            yksikot.add(yksikko);
            
            sijainti=yksikko.getSijainti();
            
            return true;
        }
        
        if(yksikko.getOmistaja().equals(getOmistaja())){
            yksikot.add(yksikko);
            
            return true;
        }
        
        return false;
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
