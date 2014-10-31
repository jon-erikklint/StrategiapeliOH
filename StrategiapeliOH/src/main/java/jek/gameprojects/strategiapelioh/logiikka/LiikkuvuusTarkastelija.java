package jek.gameprojects.strategiapelioh.logiikka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.Liikuntakyky;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;

public class LiikkuvuusTarkastelija {
    
    private Map<Ruutu, Integer> liikuttavat;
    
    private Kartta kartta;
    private Liikkuva liikkuva;
    private Liikuntakyky liikuntakyky;
    
    public LiikkuvuusTarkastelija(Liikkuva liikkuva, Kartta kartta){
        this.liikkuva=liikkuva;
        this.liikuntakyky=liikkuva.liikuntakyky();
        
        liikuttavat=new HashMap<>();
    }
    
    public void laskeLiikkumismatkat(){
        laskeMatkaViereisiinRuutuihin(liikkuva.liikkuvuus(), kartta.getRuutu(liikkuva.getSijainti()));
    }
    
    public Map<Ruutu, Integer> getLiikuttavatRuudut(){
        return liikuttavat;
    }
    
    private void laskeMatkaViereisiinRuutuihin(int liikkuvuus, Ruutu nykyinenRuutu){
        List<Ruutu> viereisetRuudut=kartta.getViereisetRuudut(nykyinenRuutu.getSijainti());
        
        for(Ruutu ruutu : viereisetRuudut){
            if(voikoLiikkuaRuutuun(nykyinenRuutu, ruutu)){
                
                int kuluvaLiikkuvuus=laskeMatkaViereiseenRuutuun(nykyinenRuutu.getMaasto(), ruutu.getMaasto());
                
                try{
                    int matka=liikuttavat.get(ruutu);
                    if(matka>kuluvaLiikkuvuus){
                        liikuttavat.put(ruutu, kuluvaLiikkuvuus);
                    }
                }catch(Exception e){
                    liikuttavat.put(ruutu, kuluvaLiikkuvuus);
                }
                
                if(!(liikkuvuus-kuluvaLiikkuvuus<0)){
                    laskeMatkaViereisiinRuutuihin(liikkuvuus-kuluvaLiikkuvuus, ruutu);
                } 
            }
        }
    }
    
    private boolean voikoLiikkuaRuutuun(Ruutu nykyinenRuutu, Ruutu kohdeRuutu){
        
        if(!liikuntakyky.getMihinVoiLiikkua().get( kohdeRuutu.getMaasto().getAluetyyppi() )){ //Voiko yksikkö liikkua kohdealuetyyppiin: esim. laiva ei voi liikkua maalle
            return false;
        }
        
        return Math.abs( nykyinenRuutu.getMaasto().getKorkeus()-kohdeRuutu.getMaasto().getKorkeus())<5; //Tarkistetaan onko korkeusero tarpeeksi pieni
    }
    
    private int laskeMatkaViereiseenRuutuun(Maasto nykyinenMaasto, Maasto kohdeMaasto){
        
        double kuluvaLiikkuvuus=1+liikuntakyky.getHitauskertoimetMaastossa().get(kohdeMaasto.getMaastotyyppi()); //Otetaan huomioon liikkuvan hitauskerroin kohdemaastossa
        kuluvaLiikkuvuus*=0.5*Math.abs(nykyinenMaasto.getKorkeus()-kohdeMaasto.getKorkeus()); //Otetaan huomioon korkeuseroista johtuva hitaus
        
        return (int) kuluvaLiikkuvuus;
    }
}
