package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Image;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class YksikonKuva extends ObjectKuva<Yksikko>{

    public YksikonKuva(Image image, Vektori sijainti, Vektori koko, int taso, boolean nakyva, Yksikko t) {
        super(image, sijainti, koko, taso, nakyva, t);
    }

    @Override
    public void paivitaKuva() {
        super.setImage(KuvaSailio.getKuva(super.getT().getYksikkotyyppi().toString()));
    }
    
}
