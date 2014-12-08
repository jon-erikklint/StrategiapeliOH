package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Image;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class ToStringObjectKuva<T> extends ObjectKuva{

    public ToStringObjectKuva(Image image, Vektori sijainti, Vektori koko, int taso, boolean nakyva, Object t) {
        super(image, sijainti, koko, taso, nakyva, t);
    }

    @Override
    public void paivitaKuva() {
        super.setImage(KuvaSailio.getKuva(super.getT().toString()));
    }
    
}
