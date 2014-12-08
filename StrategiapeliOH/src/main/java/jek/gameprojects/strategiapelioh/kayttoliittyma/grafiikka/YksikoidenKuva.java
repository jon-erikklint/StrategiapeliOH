package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Image;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class YksikoidenKuva extends ObjectKuva<Ruutu>{

    public YksikoidenKuva(Image image, Vektori sijainti, Vektori koko, int taso, boolean nakyva, Ruutu t) {
        super(image, sijainti, koko, taso, nakyva, t);
    }

    @Override
    public void paivitaKuva() {
        Ruutu ruutu = super.getT();
        
        super.setImage(KuvaSailio.getKuva("Yksikkoja:"+ruutu.yksikoidenMaara()));
    }
    
}
