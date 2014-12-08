package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;

public abstract class PelitilaEfekti implements Efekti{
    
    protected Pelitila pelitila;
    
    public PelitilaEfekti(Pelitila pelitila){
        this.pelitila = pelitila;
    }
}
