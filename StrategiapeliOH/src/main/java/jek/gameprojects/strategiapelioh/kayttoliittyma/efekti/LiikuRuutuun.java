package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;
import jek.gameprojects.strategiapelioh.logiikka.liikkuminen.Liikuttaja;

public class LiikuRuutuun extends PelitilaEfekti{

    private Ruutu ruutu;

    public LiikuRuutuun(Pelitila pelitila, Ruutu ruutu) {
        super(pelitila);
        this.ruutu = ruutu;
    }
    
    @Override
    public void toimi() {
        Liikuttaja liikuttaja = pelitila.getPeli().getLiikuttaja();
        Joukko liikutettava = pelitila.getTilat().getValitutYksikot();
        
        if(liikuttaja.annaJoukonMahdollisetLiikkeet(liikutettava).contains(ruutu.getSijainti())){
            
            liikuttaja.liikutaJoukko(liikutettava, ruutu.getSijainti());
            
        }
        
        pelitila.paivita();
        
    }
    
}
