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
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

public class Reitinhakija {
    
    private Map<Vektori, Integer> liikuttavat;
    
    private final Kartta kartta;
    private Liikkuva liikkuva;
    private Liikkuvuus liikuntakyky;
    
    public Reitinhakija(Kartta kartta){
        liikuttavat=new HashMap<>();
        
        this.kartta=kartta;
    }
    
    public Map<Vektori, Integer> ruudutJoihinVoiLiikkua(Liikkuva liikkuva){
        nollaa();
        
        this.liikkuva=liikkuva;
        this.liikuntakyky=liikkuva.liikuntakyky();
        
        laskeRuudutJoihinVoiLiikkua();
        
        return liikuttavat;
    }
    
    public void laskeRuudutJoihinVoiLiikkua(){
        liikuttavat.put(liikkuva.getSijainti(),0);
        
        if(liikkuva.liikkuvuus()>0){
            laskeMatkaViereisiinRuutuihin(liikkuva.liikkuvuus(), kartta.getRuutu(liikkuva.getSijainti()));
        } 
    }
    
    
    
    private void laskeMatkaViereisiinRuutuihin(double liikuntamaara, Ruutu nykyinenRuutu){
        List<Ruutu> viereisetRuudut=kartta.getViereisetRuudut(nykyinenRuutu.getSijainti());
        
        for(Ruutu ruutu : viereisetRuudut){
            if(voikoLiikkuaRuutuun(nykyinenRuutu, ruutu)){
                
                double kuluvaLiikuntamaara = kuluvaLiikuntamaara( nykyinenRuutu.getMaasto(), ruutu.getMaasto() );
                
                int kulunutLiikuntamaara = liikkuva.liikkuvuus()-(int)(liikuntamaara-kuluvaLiikuntamaara);
                
                yhdistaLiikkuminenLiikuttaviin(ruutu.getSijainti(), kulunutLiikuntamaara);
                
                if(!(liikuntamaara-kuluvaLiikuntamaara<=0) && onkoNopeinReittiTallaHetkella(ruutu.getSijainti(), kulunutLiikuntamaara)){
                    laskeMatkaViereisiinRuutuihin(liikuntamaara-kuluvaLiikuntamaara, ruutu);
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
        
        Pelaaja omistaja=kohdeRuutu.kenenHallussa();
        if(omistaja==null){
            return true;
        }
        
        return omistaja.equals(liikkuva.getOmistaja());//Tarkistetaan onko ruutu vihollisen hallussa
    }
    
    private int kuluvaLiikuntamaara(Maasto nykyinenMaasto, Maasto kohdeMaasto){
        
        double kuluvaLiikuntamaara=1+liikuntakyky.getHitauskertoimetMaastossa().get(kohdeMaasto.getMaastotyyppi()); //Otetaan huomioon liikkuvan hitauskerroin kohdemaastossa
        kuluvaLiikuntamaara+=0.5*Math.abs(nykyinenMaasto.getKorkeus()-kohdeMaasto.getKorkeus()); //Otetaan huomioon korkeuseroista johtuva hitaus
        
        return (int) kuluvaLiikuntamaara;
    }
    
    private boolean yhdistaLiikkuminenLiikuttaviin(Vektori sijainti, int kulunutLiikuntamaara){
        if(onkoNopeinReittiTallaHetkella(sijainti, kulunutLiikuntamaara)){
            liikuttavat.put(sijainti, kulunutLiikuntamaara);
            
            return true;
        }
        
        return false;
    }
    
    public boolean onkoNopeinReittiTallaHetkella(Vektori sijainti, int kulunutLiikkuvuus){
        try{
            int aikaisempiNopein=liikuttavat.get(sijainti);
            return kulunutLiikkuvuus<=aikaisempiNopein;
        }catch(Exception e){
            return true;
        }
    } 
    
    public void nollaa(){
        liikuttavat.clear();
    }
    
    public Map<Vektori, Integer> getLiikuttavatRuudut(){
        return liikuttavat;
    }
    
}
