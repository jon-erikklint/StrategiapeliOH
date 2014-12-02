package jek.gameprojects.strategiapelioh.logiikka.generointi.pelaajat;

import jek.gameprojects.strategiapelioh.logiikka.generointi.pelaajat.PelaajienAlustaja;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public class PelaajienVakioAlustaja implements PelaajienAlustaja{
    
    @Override
    public Map<Integer,Pelaaja> alustaPelaajat(List<String> pelaajienNimet) {
        Map<Integer, Pelaaja> pelaajat = new HashMap<>();
        
        int id=0;
        
        for(String nimi : pelaajienNimet){
            Pelaaja pelaaja = new Pelaaja(id, nimi);
            pelaajat.put(id,pelaaja);
            
            id++;
        }
        
        return pelaajat;
    }
    
}
