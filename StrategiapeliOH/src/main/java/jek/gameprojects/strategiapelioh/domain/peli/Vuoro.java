package jek.gameprojects.strategiapelioh.domain.peli;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

/**
 *
 * Lyhyin pelin ajallinen yksikkö, yhden pelaajan yhdet toimet tapahtuvat tämän aikana
 * 
 */

public class Vuoro {
    
    private Pelaaja pelaaja;
    
    public Vuoro(Pelaaja pelaaja){
        this.pelaaja=pelaaja;
    }
    
    public Pelaaja getPelaaja(){
        return pelaaja;
    }
}
