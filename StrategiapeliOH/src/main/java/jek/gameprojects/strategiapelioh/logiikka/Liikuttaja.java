package jek.gameprojects.strategiapelioh.logiikka;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;

public class Liikuttaja {
    
    private Map<Liikkuva,Map<Vektori,Integer>> yksikoidenMahdollisetLiikkeet;
    private Map<Joukko,Set<Vektori>> joukkojenMahdollisetLiikkeet;
    
    private Reitinhakija liikkuvuusTarkastelija;
    
    public Liikuttaja(Kartta kartta){
        yksikoidenMahdollisetLiikkeet=new HashMap<>();
        joukkojenMahdollisetLiikkeet=new HashMap<>();
        
        liikkuvuusTarkastelija=new Reitinhakija(kartta);
    }
    
    public Map<Vektori, Integer> alustaLiikkuvanMahdollisetLiikkeet(Liikkuva liikkuva){
        Map<Vektori,Integer> mahdollisetLiikkeet=liikkuvuusTarkastelija.ruudutJoihinVoiLiikkua(liikkuva);
        
        yksikoidenMahdollisetLiikkeet.put(liikkuva, mahdollisetLiikkeet);
        
        return mahdollisetLiikkeet;
    }
    
    public void alustaJoukonMahdollisetLiikkeet(Joukko joukko){
        Map<Vektori, Integer> kuinkaMontaYksikkoaVoiLiikkuaRuutuun=new HashMap<>();
        
        for(Yksikko yksikko:joukko.getYksikot()){
            Map<Vektori,Integer> yksikonMahdollisetLiikkeet=alustaLiikkuvanMahdollisetLiikkeet(yksikko);
            
            for(Vektori sijainti:yksikonMahdollisetLiikkeet.keySet()){
                try{
                    int maara=kuinkaMontaYksikkoaVoiLiikkuaRuutuun.get(sijainti);
                    kuinkaMontaYksikkoaVoiLiikkuaRuutuun.put(sijainti, maara+1);
                }catch(Exception e){
                    kuinkaMontaYksikkoaVoiLiikkuaRuutuun.put(sijainti, 1);
                }
            }
        }
        
        lisaaJoukonLiikkeet(joukko, kuinkaMontaYksikkoaVoiLiikkuaRuutuun);
    }
    
    private void lisaaJoukonLiikkeet(Joukko joukko, Map<Vektori,Integer> kuinkaMontaYksikkoaVoiLiikkuaRuutuun){
        Set<Vektori> joukonLiikkeet=new HashSet<>();
        
        int joukonKoko=joukko.getYksikot().size();
        
        for(Vektori sijainti:kuinkaMontaYksikkoaVoiLiikkuaRuutuun.keySet()){
            if(kuinkaMontaYksikkoaVoiLiikkuaRuutuun.get(sijainti)==joukonKoko){
                joukonLiikkeet.add(sijainti);
            }
        }
        
        joukkojenMahdollisetLiikkeet.put(joukko, joukonLiikkeet);
    }
    
    public void liikutaLiikkuva(Liikkuva liikkuva, Vektori sijainti){
        liikkuva.liiku( yksikoidenMahdollisetLiikkeet.get(liikkuva).get(sijainti),sijainti);
    }
    
    public void liikutaJoukko(Joukko joukko, Vektori sijainti){
        for(Yksikko yksikko:joukko.getYksikot()){
            liikutaLiikkuva(yksikko, sijainti);
        }
    }
    
    public void nollaa(){
        yksikoidenMahdollisetLiikkeet.clear();
        joukkojenMahdollisetLiikkeet.clear();
        
        liikkuvuusTarkastelija.nollaa();
    }
    
    public Set<Vektori> annaYksikonMahdollisetLiikkeet(Liikkuva liikkuva){
        return yksikoidenMahdollisetLiikkeet.get(liikkuva).keySet();
    }
    
    public Set<Vektori> annaJoukonMahdollisetLiikkeet(Joukko joukko){
        return joukkojenMahdollisetLiikkeet.get(joukko);
    }
}
