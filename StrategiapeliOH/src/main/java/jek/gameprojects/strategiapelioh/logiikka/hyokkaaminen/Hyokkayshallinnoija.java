package jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkaava;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Sotilas;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.JoukkojenHallinnoija;

/**
 * 
 * Kokoonpaneva luokka, joka käyttää hyäksi taistelulaskuria ja kantaman laskijaa ja niiden avulal hoitaa hyökkäykseen liittyvät toimet
 * 
 */

public class Hyokkayshallinnoija {
    
    private Kartta kartta;
    
    private KantamanLaskija kantamanLaskija;
    private Taistelulaskuri taistelulaskuri;
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    private Map<Joukko,Set<Koordinaatti>> joukonHyokattavatRuudut;
    private Map<Hyokkaava,Set<Koordinaatti>> hyokkaavanHyokattavatRuudut;
    
    public Hyokkayshallinnoija(Kartta kartta, Map<Asetyyppi, Map<Panssarityyppi,Double>> panssarienVahvuudet){
        this.kartta = kartta;
        
        this.kantamanLaskija = new KantamanLaskija(kartta);
        this.taistelulaskuri = new Taistelulaskuri(panssarienVahvuudet);
        
        joukkojenHallinnoija = new JoukkojenHallinnoija();
        
        joukonHyokattavatRuudut = new HashMap<>();
        hyokkaavanHyokattavatRuudut = new HashMap<>();
    }
    
    //
    ///Alustukset
    public Set<Koordinaatti> alustaHyokkaavanHyokattavatRuudut(Hyokkaava hyokkaava){
        Set<Koordinaatti> hyokattavat = kantamanLaskija.laskeHyokattavatRuudut(hyokkaava);
        
        hyokkaavanHyokattavatRuudut.put(hyokkaava, hyokattavat);
        
        return hyokattavat;
    }
    
    public Set<Koordinaatti> alustaJoukonHyokattavatRuudut(Joukko joukko){
        if(!onkoJoukkoHyokkaava(joukko)){
            return new HashSet<>();
        }
        
        Set<Koordinaatti> yhteiset = alustaHyokkaavanHyokattavatRuudut(yksikkoHyokkaavaksi(joukko.getYksikot().get(0)));
        
        for(int i=1; i<joukko.getYksikot().size() ; i++){
            Hyokkaava hyokkaava = yksikkoHyokkaavaksi(joukko.getYksikot().get(i));
            
            Set<Koordinaatti> liikuttavat = alustaHyokkaavanHyokattavatRuudut(hyokkaava);
            
            poistaSetistaYlimaaraiset(yhteiset, liikuttavat);
        }
        
        joukonHyokattavatRuudut.put(joukko, yhteiset);
        
        return yhteiset;
    }
    
    private void poistaSetistaYlimaaraiset(Set<Koordinaatti> mista, Set<Koordinaatti> tarkistus){
        Set<Koordinaatti> poistettavat = new HashSet<>();
        
        for(Koordinaatti koordinaatti:mista){
            if(!tarkistus.contains(koordinaatti)){
                poistettavat.add(koordinaatti);
            }
        }
        
        for(Koordinaatti poistettava:poistettavat){
            mista.remove(poistettava);
        }
    }
    ///
    //
    
    //
    ///Hyokkaaminen
    public void hyokkaaHyokkaavallaRuutuun(Hyokkaava hyokkaava, Koordinaatti koordinaatti){
        if(!hyokkaavanHyokattavatRuudut.containsKey(hyokkaava)){
            return;
        }
        if(!hyokkaavanHyokattavatRuudut.get(hyokkaava).contains(koordinaatti)){
            return;
        }
        
        List<Hyokkaava> hyokkaavat = new ArrayList<>();
        hyokkaavat.add(hyokkaava);
        
        List<Hyokkaava> puolustajat = annaHyokkaavatRuudusta(kartta.getRuutu(koordinaatti));
        
        asetaTaistelulaskuri(hyokkaavat, puolustajat);
        
        taistelulaskuri.taistele();
    }
    
    public void hyokkaaJoukollaRuutuun(Joukko joukko, Koordinaatti koordinaatti){
        if(!joukonHyokattavatRuudut.containsKey(joukko)){
            return;
        }
        if(!joukonHyokattavatRuudut.get(joukko).contains(koordinaatti)){
            return;
        }
        
        asetaTaistelulaskuri(joukkoHyokkaavaksi(joukko), annaHyokkaavatRuudusta(kartta.getRuutu(koordinaatti)));
        taistelulaskuri.taistele();
    }
    
    public void asetaTaistelulaskuri(List<Hyokkaava> hyokkaavat, List<Hyokkaava> puolustajat){
        taistelulaskuri.setHyokkaajat(hyokkaavat);
        taistelulaskuri.setPuolustajat(puolustajat);
    }
    ///
    //
    
    private List<Hyokkaava> annaHyokkaavatRuudusta(Ruutu ruutu){
        List<Hyokkaava> hyokkaavat = new ArrayList<>();
        
        for(Joukko joukko:ruutu.getJoukot()){
            for(Yksikko yksikko:joukko.getYksikot()){
                if(yksikko.getClass()==Sotilas.class){
                    hyokkaavat.add((Sotilas) yksikko);
                }
            }
        }
        
        return hyokkaavat;
    }
    
    private Hyokkaava yksikkoHyokkaavaksi(Yksikko yksikko){
        Hyokkaava hyokkaava = (Hyokkaava) yksikko;
        
        return hyokkaava;
    }
    
    private List<Hyokkaava> joukkoHyokkaavaksi(Joukko joukko){
        List<Hyokkaava> palautettava = new ArrayList<>();
        
        for(Yksikko yksikko:joukko.getYksikot()){
            palautettava.add((Sotilas) yksikko);
        }
        
        return palautettava;
    }
    
    public boolean onkoJoukkoHyokkaava(Joukko joukko){
        for(Yksikko yksikko:joukko.getYksikot()){
            if(yksikko.getClass()!=Sotilas.class){
                return false;
            }
        }
        
        return true;
    }
    
    public Set<Koordinaatti> getJoukonHyokattavatRuudut(Joukko joukko){
        return joukonHyokattavatRuudut.get(joukko);
    }
    
    public void nollaa(){
        joukonHyokattavatRuudut.clear();
        hyokkaavanHyokattavatRuudut.clear();
    }
    
}
