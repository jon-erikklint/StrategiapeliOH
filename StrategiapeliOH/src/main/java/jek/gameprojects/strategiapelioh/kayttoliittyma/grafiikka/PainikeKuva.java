/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.image.BufferedImage;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Painike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public abstract class PainikeKuva extends Kuva implements  Painike{

    private Painike painike;
    
    public PainikeKuva(BufferedImage image, Vektori sijainti, Vektori koko, double kulma, Painike painike, int taso) {
        super(image, sijainti, koko, kulma, taso);
        
        this.painike = painike;
    }

    @Override
    public void toimi(){
        painike.toimi();
    }

    public Painike getPainike() {
        return painike;
    }

    public void setPainike(Painike painike) {
        this.painike = painike;
    }
    
}
