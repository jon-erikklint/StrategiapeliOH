package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat;

import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Tila;
import jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen.Hyokkayshallinnoija;

public class Hyokkaysavustaja {
    
    private Hyokkayshallinnoija logiikka;
    
    private Tila<Joukko> valitutYksikot;
    
    public Hyokkaysavustaja(Hyokkayshallinnoija hyokkayshallinnoija, Tila<Joukko> valitutYksikot){
        logiikka = hyokkayshallinnoija;
        
        this.valitutYksikot = valitutYksikot;
    }
    
    public Set<Koordinaatti> asetaJoukonHyokattavatRuudut(){
        return logiikka.alustaJoukonHyokattavatRuudut(valitutYksikot.getMuuttuja());
    }
    
    public boolean onkoHyokattavaRuutu(Koordinaatti koordinaatti){
        return logiikka.getJoukonHyokattavatRuudut(valitutYksikot.getMuuttuja()).contains(koordinaatti);
    }
    
    public void hyokkaaHyokkaavilla(Ruutu ruutu){
        logiikka.hyokkaaJoukollaRuutuun(valitutYksikot.getMuuttuja(), ruutu.getSijainti());
    }
    
}
