package jek.gameprojects.strategiapelioh.logiikka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;

public class Reitinhakija {
    
    private Map<Vektori, Integer> liikuttavat;
    
    private final Kartta kartta;
    private Liikkuva liikkuva;
    private Liikkuvuus liikuntakyky;
    
    public Reitinhakija(Kartta kartta){
        liikuttavat=new HashMap<>();
        
        this.kartta=kartta;
    }
    
    public void alustaRuudutJoihinVoiLiikkua(){
        laskeMatkaViereisiinRuutuihin(liikkuva.liikkuvuus(), kartta.getRuutu(liikkuva.getSijainti()));
    }
    
    public Map<Vektori, Integer> ruudutJoihinVoiLiikkua(Liikkuva liikkuva){
        liikuttavat.clear();
        
        this.liikkuva=liikkuva;
        this.liikuntakyky=liikkuva.liikuntakyky();
        
        alustaRuudutJoihinVoiLiikkua();
        
        return liikuttavat;
    }
    
    private void laskeMatkaViereisiinRuutuihin(double liikuntamaara, Ruutu nykyinenRuutu){
        List<Ruutu> viereisetRuudut=kartta.getViereisetRuudut(nykyinenRuutu.getSijainti());
        
        for(Ruutu ruutu : viereisetRuudut){
            if(voikoLiikkuaRuutuun(nykyinenRuutu, ruutu)){
                
                double kuluvaLiikkuvuus = kuluvaLiikkuntamaara( nykyinenRuutu.getMaasto(), ruutu.getMaasto() );
                
                yhdistaLiikkuminenLiikuttaviin((int)kuluvaLiikkuvuus, ruutu.getSijainti());
                
                if(!(liikuntamaara-kuluvaLiikkuvuus<0)){
                    laskeMatkaViereisiinRuutuihin(liikuntamaara-kuluvaLiikkuvuus, ruutu);
                } 
                
            }
        }
    }
    
    private boolean voikoLiikkuaRuutuun(Ruutu nykyinenRuutu, Ruutu kohdeRuutu){
        
        if(!liikuntakyky.getMihinVoiLiikkua().get( kohdeRuutu.getMaasto().getAluetyyppi() )){ //Voiko yksikkö liikkua kohdealuetyyppiin: esim. laiva ei voi liikkua maalle
            return false;
        }
        
        if(!(Math.abs( nykyinenRuutu.getMaasto().getKorkeus()-kohdeRuutu.getMaasto().getKorkeus())<5)){//Tarkistetaan onko korkeusero tarpeeksi pieni
            return false;
        }
        
        return this.liikkuva.getOmistaja().equals(kohdeRuutu.kenenHallussa()); //Tarksitetaan onko ruutu vihollisen hallussa
    }
    
    private int kuluvaLiikkuntamaara(Maasto nykyinenMaasto, Maasto kohdeMaasto){
        
        double kuluvaLiikkuvuus=1+liikuntakyky.getHitauskertoimetMaastossa().get(kohdeMaasto.getMaastotyyppi()); //Otetaan huomioon liikkuvan hitauskerroin kohdemaastossa
        kuluvaLiikkuvuus*=0.5*Math.abs(nykyinenMaasto.getKorkeus()-kohdeMaasto.getKorkeus()); //Otetaan huomioon korkeuseroista johtuva hitaus
        
        return (int) kuluvaLiikkuvuus;
    }
    
    private void yhdistaLiikkuminenLiikuttaviin(int kuluvaLiikkuvuus, Vektori sijainti){
        try{
            int matka=liikuttavat.get(sijainti);
            if(matka>kuluvaLiikkuvuus){
                liikuttavat.put(sijainti, kuluvaLiikkuvuus);
            }
        }catch(Exception e){
            liikuttavat.put(sijainti, kuluvaLiikkuvuus);
        }
    }
    
    public void nollaa(){
        liikuttavat.clear();
    }
    
    public Map<Vektori, Integer> getLiikuttavatRuudut(){
        return liikuttavat;
    }
    
}
