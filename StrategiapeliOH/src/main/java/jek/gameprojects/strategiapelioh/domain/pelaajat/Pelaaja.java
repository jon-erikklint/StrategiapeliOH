package jek.gameprojects.strategiapelioh.domain.pelaajat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * Yhden pelaajan tiedot pakattuna yhteen paikkaan. Toimii myös eri peliobjektien omistajuustunnisteena
 * 
 */

public class Pelaaja {
    
    private final int id;
    private String nimi;
    
    private List<Joukko> joukot;
    
    public Pelaaja(int id, String nimi) {
        this.id = id;
        this.nimi = nimi;
        
        joukot=new ArrayList<>();
    }
    
    /**
     * Lisää pelaajalle uuden joukon
     * 
     * @param joukko lisättävä
     */
    public void lisaaJoukko(Joukko joukko){
        joukot.add(joukko);
    }
    
    /**
     * Poistaa pelaajalta joukon
     * 
     * @param joukko poistettava
     */
    public void poistaJoukko(Joukko joukko){
        joukot.remove(joukko);
    }

    public List<Joukko> getJoukot() {
        return joukot;
    }
    
    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        
        if(o.getClass() != this.getClass()){
            return false;
        }
        
        Pelaaja pelaaja = (Pelaaja) o;
        
        return pelaaja.id == this.id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.nimi);
        return hash;
    }
    
    @Override
    public String toString(){
        return nimi;
    }
    
}
