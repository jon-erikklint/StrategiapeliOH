package jek.gameprojects.strategiapelioh.domain.kartta;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public class Ruutu {
    
    private Vektori sijainti;
    private Maasto maasto;
    
    private List<Joukko> joukot;

    public Ruutu(Vektori sijainti, Maasto maasto) {
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
        return joukot.get(0).getOmistaja();
    }
    
    public Maasto getMaasto() {
        return maasto;
    }

    public void setMaasto(Maasto maasto) {
        this.maasto = maasto;
    }

    public Vektori getSijainti() {
        return sijainti;
    }

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    public List<Joukko> getJoukot() {
        return joukot;
    }
    
}
