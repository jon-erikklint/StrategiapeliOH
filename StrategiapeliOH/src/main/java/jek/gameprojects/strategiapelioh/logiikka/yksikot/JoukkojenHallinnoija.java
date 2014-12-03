package jek.gameprojects.strategiapelioh.logiikka.yksikot;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;

/**
 * 
 * JoukkojenHallinnoijan tehtävänä on hoitaa joukkojen rakenteisiin liittyvät tehtävät kuten joukkojen yhdistäminen
 * 
 */

public class JoukkojenHallinnoija {
    
    public void siirraYksikkoJoukkoon(Yksikko yksikko, Joukko joukko){
        Joukko vanhaJoukko = yksikko.getJoukko();
        
        if(joukko.lisaaYksikko(yksikko)){
            
            vanhaJoukko.poistaYksikko(yksikko);
        } 
    }
    
    private void poistaYksikkoJoukosta(Yksikko yksikko, Joukko joukko){
        joukko.poistaYksikko(yksikko);
    }
    
    public Joukko siirraJoukkoJoukkoon(Joukko kohde, Joukko lahde){
        
        for(Yksikko yksikko:lahde.getYksikot()){
            kohde.lisaaYksikko(yksikko);
        }
        
        for(Yksikko yksikko:lahde.getYksikot()){
            poistaYksikkoJoukosta(yksikko, lahde);
        }
        
        return kohde;
    }
    
    public void luoYksikolleOmaJoukko(Yksikko yksikko){
        Joukko uusiJoukko = new Joukko();
        
        siirraYksikkoJoukkoon(yksikko, uusiJoukko);
    }
    
    public List<Joukko> hajoitaJoukkoYksittaisenYksikonJoukoiksi(Joukko joukko){
        List<Joukko> uudetJoukot=new ArrayList<>();
        
        if(joukko.getYksikot().isEmpty()){
            uudetJoukot.add(joukko);
            return uudetJoukot;
        }
        
        for(Yksikko yksikko:joukko.getYksikot()){
            luoYksikolleOmaJoukko(yksikko);
            
            uudetJoukot.add(yksikko.getJoukko());
        }
        
        return uudetJoukot;
    }
    
    public Joukko yhdistaJuokotYhdeksiJoukoksi(List<Joukko> joukot){
        Joukko uusiJoukko = joukot.get(0);
        
        for(int i=1; i<joukot.size();i++){
            siirraJoukkoJoukkoon(uusiJoukko, joukot.get(i));
        }
        
        return uusiJoukko;
    }
    
    public void paivitaJoukonSijaintiVastaamaanYksikoita(Joukko joukko){
        joukko.setSijainti( joukko.getYksikot().get(0).getSijainti() );
    }
    
    public void alustaUudenYksikonJoukko(Yksikko yksikko){
        yksikko.getJoukko().lisaaYksikko(yksikko);
    }
    
    public void poistayksikkoJoukostaan(Yksikko yksikko){
        yksikko.getJoukko().poistaYksikko(yksikko);
    }
    
}
