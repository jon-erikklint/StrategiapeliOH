package jek.gameprojects.strategiapelioh.domain.pelaajat;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;

public class Joukko implements Omistettava{

    private List<Yksikko> yksikot;
    
    private Vektori sijainti;
    
    public Joukko(Vektori sijainti, Yksikko yksikko){
        yksikot=new ArrayList<>();
        
        yksikot.add(yksikko);
        
        this.sijainti=sijainti;
    }
    
    @Override
    public Pelaaja getOmistaja(){
        return yksikot.get(0).getOmistaja();
    }
    
    public boolean lisaaYksikko(Yksikko yksikko){
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

    public Vektori getSijainti() {
        return sijainti;
    }
    
    public void setSijainti(Vektori sijainti){
        for(Yksikko yksikko:yksikot){
            yksikko.setSijainti(sijainti);
        }
    }
    
}
