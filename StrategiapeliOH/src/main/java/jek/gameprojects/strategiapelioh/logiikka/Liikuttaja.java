package jek.gameprojects.strategiapelioh.logiikka;

import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.Liike;
import jek.gameprojects.strategiapelioh.domain.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;

public class Liikuttaja {
    
    private Map<Liikkuva,Map<Vektori,Integer>> yksikoidenMahdollisetLiikkeet;
    
    private LiikkuvuusTarkastelija liikkuvuusTarkastelija;
    
    public Liikuttaja(Kartta kartta){
        yksikoidenMahdollisetLiikkeet=new HashMap<>();
        
        liikkuvuusTarkastelija=new LiikkuvuusTarkastelija(kartta);
    }
    
    public void alustaJoukonMahdollisetLiikkeet(Joukko joukko){
        for(Yksikko yksikko:joukko.getYksikot()){
            alustaLiikkuvanMahdollisetLiikkeet(yksikko);
        }
    }
    
    public void alustaLiikkuvanMahdollisetLiikkeet(Liikkuva liikkuva){
        yksikoidenMahdollisetLiikkeet.put(liikkuva, liikkuvuusTarkastelija.laskeLiikkuva(liikkuva));
        
    }
    
    public void liikutaJoukko(Joukko joukko, Vektori sijainti){
        for(Yksikko yksikko:joukko.getYksikot()){
            liikutaLiikkuva(yksikko, sijainti);
        }
    }
    
    public void liikutaLiikkuva(Liikkuva liikkuva, Vektori sijainti){
        liikkuva.liiku( new Liike( sijainti, yksikoidenMahdollisetLiikkeet.get(liikkuva).get(sijainti) ) );
    }
    
    public void nollaa(){
        yksikoidenMahdollisetLiikkeet.clear();
        
        liikkuvuusTarkastelija.nollaa();
    }
}
