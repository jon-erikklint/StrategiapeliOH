package jek.gameprojects.strategiapelioh.logiikka.liikkuminen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

/**
 * 
 * Reitinhakija hakee yksikön tietojen perusteella ne ruudut joihin se voi liikkua ja kertoo myös näihin liikkeisiin kuluvan liikemaaran
 * 
 */

public class Reitinhakija {
    
    private Map<Koordinaatti, Integer> liikuttavat;
    
    private final Kartta kartta;
    private Liikkuva liikkuva;
    private Liikkuvuus liikuntakyky;
    
    public Reitinhakija(Kartta kartta){
        liikuttavat=new HashMap<>();
        
        this.kartta=kartta;
    }
    
    /**
     * Palauttaa ruudut joihin liikkuva voi liikkua ja niitä vastaavat liikemaaran kulumiset
     * 
     * @param liikkuva
     * @return mihin voi liikkua ja millä liikemäärillä
     */
    public Map<Koordinaatti, Integer> ruudutJoihinVoiLiikkua(Liikkuva liikkuva){
        nollaa();
        
        this.liikkuva=liikkuva;
        this.liikuntakyky=liikkuva.liikuntakyky();
        
        laskeRuudutJoihinVoiLiikkua();
        
        return liikuttavat;
    }
    
    /**
     * 
     * Laskee reitinhakijaan asetetun yksikön mahdoliiset liikunnat
     * 
     */
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
                
                int kulunutLiikuntamaara = liikkuva.liikkuvuus()-(int) Math.ceil(liikuntamaara-kuluvaLiikuntamaara);
                
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
    
    private boolean yhdistaLiikkuminenLiikuttaviin(Koordinaatti sijainti, int kulunutLiikuntamaara){
        if(onkoNopeinReittiTallaHetkella(sijainti, kulunutLiikuntamaara)){
            liikuttavat.put(sijainti, kulunutLiikuntamaara);
            
            return true;
        }
        
        return false;
    }
    
    private boolean onkoNopeinReittiTallaHetkella(Koordinaatti sijainti, int kulunutLiikkuvuus){
        try{
            int aikaisempiNopein=liikuttavat.get(sijainti);
            return kulunutLiikkuvuus<=aikaisempiNopein;
        }catch(Exception e){
            return true;
        }
    } 
    
    /**
     * 
     * Nollaa reitinhakijan tiedot
     * 
     */
    public void nollaa(){
        liikkuva = null;
        liikuntakyky = null;
        
        liikuttavat = new HashMap<>();
    }
    
    /**
     * Palauttaa aikaisemman reitinhaun tulokset
     * 
     * @return mihin edellinen laskettu yksikkö voi liikkua ja millä liikemäärillä
     */
    public Map<Koordinaatti, Integer> getLiikuttavatRuudut(){
        return liikuttavat;
    }
    
}
