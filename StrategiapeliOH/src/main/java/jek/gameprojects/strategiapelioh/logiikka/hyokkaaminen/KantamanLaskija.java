package jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkaava;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;

public class KantamanLaskija {
    
    private Set<Koordinaatti> hyokattavat;
    
    private Hyokkaava hyokkaava;
    private Kartta kartta;
    
    public KantamanLaskija(Kartta kartta){
        this.kartta=kartta;
        
        hyokattavat=new HashSet<>();
    }
    
    public Set<Koordinaatti> laskeHyokattavatRuudut(Hyokkaava hyokkaava){
        nollaa();
        this.hyokkaava = hyokkaava;
        
        laskeViereisetHyokattavat(hyokkaava.hyokkays().getKantama(), kartta.getRuutu(hyokkaava.getSijainti()));
        
        return hyokattavat;
    }
    
    private void laskeViereisetHyokattavat(double kantama, Ruutu nykyinenRuutu){
        List<Ruutu> viereisetRuudut = kartta.getViereisetRuudut( nykyinenRuutu.getSijainti() );
        
        for(Ruutu ruutu:viereisetRuudut){
            if(voikoAmpua(ruutu)){
                
                if(onkoVihollisia(ruutu)){
                    hyokattavat.add(ruutu.getSijainti());
                }
                
                double mennytKantama=kuluvaKantama(ruutu.getMaasto(), nykyinenRuutu.getMaasto());
                
                if(kantama-mennytKantama>0){
                    
                    laskeViereisetHyokattavat(kantama-mennytKantama,ruutu);
                    
                }
            }
        }
        
    }
    
    private boolean voikoAmpua(Ruutu kohderuutu){
        return true;
    }
    
    private boolean onkoVihollisia(Ruutu kohderuutu){
        if(kohderuutu.kenenHallussa() == null){
            return false;
        }
        
        return !kohderuutu.kenenHallussa().equals(hyokkaava.getOmistaja());
    }
    
    private double kuluvaKantama(Maasto kohdemaasto, Maasto nykyinenMaasto){
        return 1;
    }
    
    public void nollaa(){
        hyokattavat = new HashSet<>();
    }
}
