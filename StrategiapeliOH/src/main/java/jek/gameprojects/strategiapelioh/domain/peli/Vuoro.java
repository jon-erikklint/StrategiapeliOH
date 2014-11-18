package jek.gameprojects.strategiapelioh.domain.peli;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public class Vuoro {
    
    private Pelaaja pelaaja;
    
    public Vuoro(Pelaaja pelaaja){
        this.pelaaja=pelaaja;
    }
    
    public Pelaaja getPelaaja(){
        return pelaaja;
    }
}
