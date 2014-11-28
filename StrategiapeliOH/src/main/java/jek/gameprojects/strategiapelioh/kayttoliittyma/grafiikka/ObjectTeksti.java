package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Color;
import java.awt.Font;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Paivittyva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class ObjectTeksti<T> extends Teksti implements Paivittyva{

    private T t;
    
    public ObjectTeksti(Vektori sijainti, Vektori koko, int taso, String teksti, Color color, Font font, T t) {
        super(sijainti, koko, taso, teksti, color, font);
    }

    @Override
    public void paivita() {
        setTeksti(t.toString());
    }
    
}
