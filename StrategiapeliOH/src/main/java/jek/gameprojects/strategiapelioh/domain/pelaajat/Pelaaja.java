package jek.gameprojects.strategiapelioh.domain.pelaajat;

import java.util.ArrayList;
import java.util.List;

public class Pelaaja {
    
    private final int id;
    private String nimi;
    
    private List<Joukko> joukot;
    
    public Pelaaja(int id, String nimi) {
        this.id = id;
        this.nimi = nimi;
        
        joukot=new ArrayList<>();
    }
    
    public void lisaaJoukko(Joukko joukko){
        joukot.add(joukko);
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
    
}
