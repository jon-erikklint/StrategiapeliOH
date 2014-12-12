package jek.gameprojects.strategiapelioh.domain.kartta;

import java.util.ArrayList;
import java.util.List;

/**
*
* Luokka tallettaa kyseisen pelikerran ruututaulukon, eli kartan, ja mahdollistaa ruutujen hakemisen siitä
* 
*/
public class Kartta {
    
    private Ruutu[][] ruudut;
    
    private int leveys;
    private int korkeus;
    
    public Kartta(Ruutu[][] ruudut, int leveys, int korkeus){
        this.ruudut=ruudut;
        
        this.leveys=leveys;
        this.korkeus=korkeus;
    }
    
    /**
     * Metodi antaa jonkin koordinaatin vieressä olevat ruudut. Kartalla voi liikkua vain pysty tai vaakasuunnassa, 
     * joten metodi palauttaa vain ne, eikä sivuttain vierustavia.
     * 
     * @param sijainti haluttu sijainti
     * 
     * @return lista sijaintia vierustavista ruuduista
     */
    public List<Ruutu> getViereisetRuudut(Koordinaatti sijainti){
        List<Ruutu> viereisetRuudut=new ArrayList<>();
        
        if(onkoKartalla( sijainti.summaVektori( Ilmansuunta.LANSI.suuntakoordinaatti() ) )){
            viereisetRuudut.add(ruudut[sijainti.getX()-1][sijainti.getY()]);
        }
        
        if(onkoKartalla( sijainti.summaVektori( Ilmansuunta.ITA.suuntakoordinaatti() ) )){
            viereisetRuudut.add(ruudut[sijainti.getX()+1][sijainti.getY()]);
        }
        
        if(onkoKartalla( sijainti.summaVektori( Ilmansuunta.POHJOINEN.suuntakoordinaatti() ) )){
            viereisetRuudut.add(ruudut[sijainti.getX()][sijainti.getY()-1]);
        }
        
        if(onkoKartalla( sijainti.summaVektori( Ilmansuunta.ETELA.suuntakoordinaatti() ) )){
            viereisetRuudut.add(ruudut[sijainti.getX()][sijainti.getY()+1]);
        }
        
        return viereisetRuudut;
    }
    
    
    /**
     * Metodi palauttaa annettua koordinaattia vastaavan ruudun
     * 
     * @param sijainti halutun ruudun sijainti
     * 
     * @return sijaintia vastaava ruutu
     */
    public Ruutu getRuutu(Koordinaatti sijainti){
        return ruudut[sijainti.getX()][sijainti.getY()];
    }
    
    
    /**
     * Kertoo onko annettu koordinaatti kartalla
     * 
     * @param koordinaatti Koordinaatti jota tutkitaan
     * @return onko kartalla
     */
    public boolean onkoKartalla(Koordinaatti koordinaatti){
        if(koordinaatti.getX()<0 || koordinaatti.getX()>=leveys){
            return false;
        }
        
        if(koordinaatti.getY()<0 || koordinaatti.getY()>=korkeus){
            return false;
        }
        
        return true;
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
