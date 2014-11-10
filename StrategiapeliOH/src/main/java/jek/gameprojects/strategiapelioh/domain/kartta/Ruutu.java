package jek.gameprojects.strategiapelioh.domain.kartta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public class Ruutu {
    
    private Koordinaatti sijainti;
    private Maasto maasto;
    
    private List<Joukko> joukot;

    public Ruutu(Koordinaatti sijainti, Maasto maasto) {
        this.sijainti = sijainti;
        this.maasto = maasto;
        
        joukot=new ArrayList<>();
    }
    
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
    
    public boolean poistaJoukko(Joukko joukko){
        if(joukot.contains(joukko)){
            joukot.remove(joukko);
            
            return true;
        }
        
        return false;
    }
    
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
    
}
