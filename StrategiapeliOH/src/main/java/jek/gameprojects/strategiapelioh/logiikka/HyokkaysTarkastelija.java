package jek.gameprojects.strategiapelioh.logiikka;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.Hyokkaava;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;

public class HyokkaysTarkastelija {
    
    private List<Vektori> hyokattavat;
    
    private Hyokkaava hyokkaava;
    private Kartta kartta;
    
    public HyokkaysTarkastelija(Hyokkaava hyokkaava, Kartta kartta){
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