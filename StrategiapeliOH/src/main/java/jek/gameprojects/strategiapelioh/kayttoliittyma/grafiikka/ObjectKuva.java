package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Image;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Paivittyva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class ObjectKuva<T> extends Kuva implements Paivittyva{

    private T t;
    
    public ObjectKuva(Image image, Vektori sijainti, Vektori koko, int taso, boolean nakyva, T t) {
        super(image, sijainti, koko, taso, nakyva);
        
        this.t = t;
    }

    @Override
    public void paivita() {
        if(!KuvaSailio.getKuva(t.toString()).equals(getImage())){
            setImage(KuvaSailio.getKuva(t.toString()));
        }
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    
}
