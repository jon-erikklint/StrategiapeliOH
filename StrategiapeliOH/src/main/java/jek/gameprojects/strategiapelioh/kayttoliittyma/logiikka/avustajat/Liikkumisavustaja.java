package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat;

import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Tila;
import jek.gameprojects.strategiapelioh.logiikka.liikkuminen.Liikuttaja;

public class Liikkumisavustaja {
    
    private Tila<Joukko> valitutYksikot;
    private Liikuttaja liikuttaja;

    public Liikkumisavustaja(Liikuttaja liikuttaja, Tila<Joukko> valitutYksikot) {
        this.valitutYksikot = valitutYksikot;
        this.liikuttaja = liikuttaja;
    }
    
    public Set<Koordinaatti> alustaLiikuttavatRuudut(){
        return liikuttaja.alustaJoukonMahdollisetLiikkeet(valitutYksikot.getMuuttuja());
    }
    
    public boolean onkoLiikuttavaRuutu(Ruutu ruutu){
        return liikuttaja.annaJoukonMahdollisetLiikkeet(valitutYksikot.getMuuttuja()).contains(ruutu.getSijainti());
    }
    
    public void liikutaJoukkoRuutuun(Ruutu ruutu){
        liikuttaja.liikutaJoukko(valitutYksikot.getMuuttuja(), ruutu.getSijainti());
    }
    
}
