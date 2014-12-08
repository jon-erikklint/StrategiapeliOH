package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Color;
import java.awt.Font;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class ObjectTeksti<T> extends Teksti{

    private T t;
    
    public ObjectTeksti(Vektori sijainti, Vektori koko, int taso, String teksti, Color color, Font font, boolean nakyva,T t) {
        super(sijainti, koko, taso, teksti, color, font, nakyva);
        
        this.t = t;
    }

    @Override
    public void paivita() {
        setTeksti(t.toString());
    }
    
}
