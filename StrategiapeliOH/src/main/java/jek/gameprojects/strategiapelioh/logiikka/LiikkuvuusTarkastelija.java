package jek.gameprojects.strategiapelioh.logiikka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Liikkuvuus;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;

public class LiikkuvuusTarkastelija {
    
    private Map<Vektori, Integer> liikuttavat;
    
    private final Kartta kartta;
    private Liikkuva liikkuva;
    private Liikkuvuus liikuntakyky;
    
    public LiikkuvuusTarkastelija(Kartta kartta){
        liikuttavat=new HashMap<>();
        
        this.kartta=kartta;
    }
    
    public void laskeLiikkumismatkat(){
        laskeMatkaViereisiinRuutuihin(liikkuva.liikkuvuus(), kartta.getRuutu(liikkuva.getSijainti()));
    }
    
    public Map<Vektori, Integer> getLiikuttavatRuudut(){
        return liikuttavat;
    }
    
    public Map<Vektori, Integer> laskeLiikkuva(Liikkuva liikkuva){
        liikuttavat.clear();
        
        this.liikkuva=liikkuva;
        this.liikuntakyky=liikkuva.liikuntakyky();
        
        laskeLiikkumismatkat();
        
        return liikuttavat;
    }
    
    public void nollaa(){
        liikuttavat.clear();
    }
    
    private void laskeMatkaViereisiinRuutuihin(int liikkuvuus, Ruutu nykyinenRuutu){
        List<Ruutu> viereisetRuudut=kartta.getViereisetRuudut(nykyinenRuutu.getSijainti());
        
        for(Ruutu ruutu : viereisetRuudut){
            if(voikoLiikkuaRuutuun(nykyinenRuutu, ruutu)){
                
                int kuluvaLiikkuvuus = laskeMatkaViereiseenRuutuun( nykyinenRuutu.getMaasto(), ruutu.getMaasto() );
                
                lisaaLiikuttavaRuutu(kuluvaLiikkuvuus, ruutu.getSijainti());
                
                if(!(liikkuvuus-kuluvaLiikkuvuus<0)){
                    laskeMatkaViereisiinRuutuihin(liikkuvuus-kuluvaLiikkuvuus, ruutu);
                } 
                
            }
        }
    }
    
    private void lisaaLiikuttavaRuutu(int kuluvaLiikkuvuus, Vektori sijainti){
        try{
            int matka=liikuttavat.get(sijainti);
            if(matka>kuluvaLiikkuvuus){
                liikuttavat.put(sijainti, kuluvaLiikkuvuus);
            }
        }catch(Exception e){
            liikuttavat.put(sijainti, kuluvaLiikkuvuus);
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
