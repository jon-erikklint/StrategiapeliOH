package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.image.BufferedImage;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Painike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class RiippumatonPainikeKuva extends PainikeKuva{

    public RiippumatonPainikeKuva(BufferedImage image, Vektori sijainti, Vektori koko, double kulma, Painike painike, int taso) {
        super(image, sijainti, koko, kulma, painike, taso);
    }

    @Override
    public boolean onkoPaalla(Vektori vektori) {
        return getPainike().onkoPaalla(vektori);
    }
    
}
