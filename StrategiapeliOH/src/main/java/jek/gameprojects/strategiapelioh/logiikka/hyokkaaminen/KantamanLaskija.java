package jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkaava;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;

public class KantamanLaskija {
    
    private List<Koordinaatti> hyokattavat;
    
    private Hyokkaava hyokkaava;
    private Kartta kartta;
    
    public KantamanLaskija(Hyokkaava hyokkaava, Kartta kartta){
        this.kartta=kartta;
        this.hyokkaava=hyokkaava;
        
        hyokattavat=new ArrayList<>();
    }
    
    public void katsoHyokattavat(){
        katsoViereisetHyokattavat(hyokkaava.hyokkays().getKantama(), kartta.getRuutu(hyokkaava.getSijainti()));
    }
    
    private void katsoViereisetHyokattavat(double kantama, Ruutu nykyinenRuutu){
        List<Ruutu> viereisetRuudut = kartta.getViereisetRuudut( nykyinenRuutu.getSijainti() );
        
        for(Ruutu ruutu:viereisetRuudut){
            if(voikoAmpua(ruutu)){
                
                if(!hyokattavat.contains(ruutu.getSijainti())){
                    hyokattavat.add(ruutu.getSijainti());
                }
                
                double mennytKantama=kuluvaKantama(ruutu.getMaasto(), nykyinenRuutu.getMaasto());
                
                if(kantama-mennytKantama>0){
                    
                    katsoViereisetHyokattavat(kantama-mennytKantama,ruutu);
                    
                }
            }
        }
        
    }
    
    private boolean voikoAmpua(Ruutu kohderuutu){
        return true;
    }
    
    private boolean onkoVihollisia(Ruutu kohderuutu){
        return kohderuutu.kenenHallussa().equals(hyokkaava.getOmistaja());
    }
    
    private double kuluvaKantama(Maasto kohdemaasto, Maasto nykyinenMaasto){
        return 1;
    }
}
