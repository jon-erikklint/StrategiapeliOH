package jek.gameprojects.strategiapelioh.logiikka.liikkuminen;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.JoukkojenHallinnoija;

/**
 * 
 * Logiikkaluokka jonka tehtävänä on hoitaa yksiköiden ja joukkojen liikkuminen
 * 
 */

public class Liikuttaja {
    
    private Map<Liikkuva,Map<Koordinaatti,Integer>> yksikoidenMahdollisetLiikkeet;
    private Map<Joukko,Set<Koordinaatti>> joukkojenMahdollisetLiikkeet;
    
    private Reitinhakija reitinhakija;
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    private Kartta kartta;
    
    public Liikuttaja(Kartta kartta, JoukkojenHallinnoija joukkojenHallinnoija){
        yksikoidenMahdollisetLiikkeet=new HashMap<>();
        joukkojenMahdollisetLiikkeet=new HashMap<>();
        
        reitinhakija=new Reitinhakija(kartta);
        this.joukkojenHallinnoija=joukkojenHallinnoija;
        
        this.kartta = kartta;
        
    }
    
    //
    //Alustukset/Reitinhakijan laskut
    
    /**
     * Alustaa annetun yksikön mahdolliset liikunnat reitinhakijan avulla ja tallentaa ne
     * 
     * @param liikkuva
     * @return liikkuvan mahdolliset liikkeet
     */
    public Map<Koordinaatti, Integer> alustaLiikkuvanMahdollisetLiikkeet(Liikkuva liikkuva){
        Map<Koordinaatti,Integer> mahdollisetLiikkeet=reitinhakija.ruudutJoihinVoiLiikkua(liikkuva);
        
        yksikoidenMahdollisetLiikkeet.put(liikkuva, mahdollisetLiikkeet);
        
        return mahdollisetLiikkeet;
    }
    
    /**
     * Alustaa joukon mahdolliset liikkeet
     * 
     * @param joukko
     * @return ruudut joihin joukko pystyy liikkumaan
     */
    public Set<Koordinaatti> alustaJoukonMahdollisetLiikkeet(Joukko joukko){
        Map<Koordinaatti, Integer> kuinkaMontaYksikkoaVoiLiikkuaRuutuun=new HashMap<>();
        
        for(Yksikko yksikko:joukko.getYksikot()){
            
            alustaYksikkoJoukosta(yksikko, kuinkaMontaYksikkoaVoiLiikkuaRuutuun);
            
        }
        
        return lisaaJoukonLiikkeet(joukko, kuinkaMontaYksikkoaVoiLiikkuaRuutuun);
    }
    
    private void alustaYksikkoJoukosta(Yksikko yksikko, Map<Koordinaatti, Integer> mihinYksikotVoivatLiikkua){
        Map<Koordinaatti,Integer> yksikonMahdollisetLiikkeet = alustaLiikkuvanMahdollisetLiikkeet(yksikko);
            
        for(Koordinaatti sijainti:yksikonMahdollisetLiikkeet.keySet()){

            try{
                int maara = mihinYksikotVoivatLiikkua.get(sijainti);
                mihinYksikotVoivatLiikkua.put(sijainti, maara+1);
            }catch(Exception e){
                mihinYksikotVoivatLiikkua.put(sijainti, 1);
            }

        }
    }
    
    private Set<Koordinaatti> lisaaJoukonLiikkeet(Joukko joukko, Map<Koordinaatti,Integer> kuinkaMontaYksikkoaVoiLiikkuaRuutuun){
        Set<Koordinaatti> joukonLiikkeet=new HashSet<>();
        
        int joukonKoko=joukko.getYksikot().size();
        
        for(Koordinaatti sijainti : kuinkaMontaYksikkoaVoiLiikkuaRuutuun.keySet()){
            if( kuinkaMontaYksikkoaVoiLiikkuaRuutuun.get(sijainti) == joukonKoko ){
                joukonLiikkeet.add(sijainti);
            }
        }
        
        joukkojenMahdollisetLiikkeet.put(joukko, joukonLiikkeet);
        
        return joukonLiikkeet;
    }
    //
    //
    
    
    //
    //Liikuttaminen
    
    /**
     * Liikuttaa annetun liikkuvan annettuun sijaintiin
     * 
     * @param liikkuva
     * @param sijainti 
     */
    public void liikutaLiikkuva(Liikkuva liikkuva, Koordinaatti sijainti){
        liikkuva.liiku( yksikoidenMahdollisetLiikkeet.get(liikkuva).get(sijainti),sijainti);
    }
    
    /**
     * 
     * Liikuttaa joukon ja kaikki sen sisältämät yksiköt annettuun sijaintiin
     * 
     * @param joukko
     * @param sijainti 
     */
    public void liikutaJoukko(Joukko joukko, Koordinaatti sijainti){
        for(Yksikko yksikko:joukko.getYksikot()){
            liikutaLiikkuva(yksikko, sijainti);
        }
        
        siirronJalkeinenHallinnointi(joukko, kartta.getRuutu(sijainti));
    }
    
    private void siirronJalkeinenHallinnointi(Joukko joukko, Ruutu ruutu){
        kartta.getRuutu(joukko.getSijainti()).poistaJoukko(joukko);
        
        joukko.setSijainti(ruutu.getSijainti());
        
        ruutu.lisaaJoukko(joukko);
    }
    //
    //
    
    /**
     * 
     * Nollaa tallennetut tiedot
     * 
     */
    public void nollaa(){
        yksikoidenMahdollisetLiikkeet.clear();
        joukkojenMahdollisetLiikkeet.clear();
        
        reitinhakija.nollaa();
    }
    
    
    public Set<Koordinaatti> annaYksikonMahdollisetLiikkeet(Liikkuva liikkuva){
        return yksikoidenMahdollisetLiikkeet.get(liikkuva).keySet();
    }
    
    public Set<Koordinaatti> annaJoukonMahdollisetLiikkeet(Joukko joukko){
        return joukkojenMahdollisetLiikkeet.get(joukko);
    }

    public Map<Liikkuva, Map<Koordinaatti, Integer>> getYksikoidenMahdollisetLiikkeet() {
        return yksikoidenMahdollisetLiikkeet;
    }

    public Map<Joukko, Set<Koordinaatti>> getJoukkojenMahdollisetLiikkeet() {
        return joukkojenMahdollisetLiikkeet;
    }
    
    
}
