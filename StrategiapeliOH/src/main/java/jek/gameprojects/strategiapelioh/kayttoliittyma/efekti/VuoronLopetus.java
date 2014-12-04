package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Pelitila;

public class VuoronLopetus extends PelitilaEfekti{

    public VuoronLopetus(Pelitila pelitila) {
        super(pelitila);
    }

    @Override
    public void toimi() {
        pelitila.getPeli().eteneVuoro();
        pelitila.paivita();
    }
    
}
