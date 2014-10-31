package jek.gameprojects.strategiapelioh.domain.pelaajat;

import java.util.ArrayList;
import java.util.List;

public class Pelaaja {
    
    private final int id;
    private String nimi;
    
    private List<Yksikko> yksikot;
    
    public Pelaaja(int id, String nimi) {
        this.id = id;
        this.nimi = nimi;
        
        yksikot=new ArrayList<>();
    }
    
    public void lisaaYksikko(Yksikko yksikko){
        yksikot.add(yksikko);
    }

    public List<Yksikko> getYksikot() {
        return yksikot;
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
