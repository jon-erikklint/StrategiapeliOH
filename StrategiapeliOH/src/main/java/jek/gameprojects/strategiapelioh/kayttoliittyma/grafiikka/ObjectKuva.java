package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Image;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class ObjectKuva<T> extends Kuva{

    private T t;
    
    public ObjectKuva(Image image, Vektori sijainti, Vektori koko, int taso, boolean nakyva, T t) {
        super(image, sijainti, koko, taso, nakyva);
        
        this.t = t;
    }

    @Override
    public void paivita() {
        setImage(KuvaSailio.getKuva(t.toString()));
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
}
