package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Image;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Paivittyva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class ObjectKuva<T> extends Kuva implements Paivittyva{

    private T t;
    private KuvaSailio kuvaSailio;
    
    public ObjectKuva(Image image, Vektori sijainti, Vektori koko, double kulma, int taso, T t, KuvaSailio kuvaSailio) {
        super(image, sijainti, koko, kulma, taso);
    }

    @Override
    public void paivita() {
        if(!kuvaSailio.getKuva(t.toString()).equals(getImage())){
            setImage(kuvaSailio.getKuva(t.toString()));
        }
    }
    
    
    
}
