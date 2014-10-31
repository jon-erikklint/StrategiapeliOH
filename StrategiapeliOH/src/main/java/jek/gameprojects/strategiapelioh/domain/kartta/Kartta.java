package jek.gameprojects.strategiapelioh.domain.kartta;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import java.util.ArrayList;
import java.util.List;

public class Kartta {
    
    private Ruutu[][] ruudut;
    
    private int leveys;
    private int korkeus;
    
    public Kartta(Ruutu[][] ruudut, int leveys, int korkeus){
        this.ruudut=ruudut;
        
        this.leveys=leveys;
        this.korkeus=korkeus;
    }
    
    public List<Ruutu> getViereisetRuudut(Vektori sijainti){
        List<Ruutu> viereisetRuudut=new ArrayList<>();
        
        if(sijainti.getX()-1>=0){
            viereisetRuudut.add(ruudut[sijainti.getX()-1][sijainti.getY()]);
        }
        
        if(sijainti.getX()+1<leveys){
            viereisetRuudut.add(ruudut[sijainti.getX()+1][sijainti.getY()]);
        }
        
        if(sijainti.getY()-1>=0){
            viereisetRuudut.add(ruudut[sijainti.getX()][sijainti.getY()-1]);
        }
        
        if(sijainti.getY()+1<korkeus){
            viereisetRuudut.add(ruudut[sijainti.getX()][sijainti.getY()+1]);
        }
        
        return viereisetRuudut;
    }
    
    public Ruutu getRuutu(Vektori sijainti){
        return ruudut[sijainti.getX()][sijainti.getY()];
    }

    public Ruutu[][] getRuudut() {
        return ruudut;
    }

    public void setRuudut(Ruutu[][] ruudut) {
        this.ruudut = ruudut;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }
    
    
}
