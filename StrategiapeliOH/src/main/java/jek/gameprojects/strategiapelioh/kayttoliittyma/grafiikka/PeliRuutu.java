package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics;
import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.logiikka.Peli;

public class PeliRuutu implements Ruutu{

    private final Peli peli;
    
    private GrafiikkaSailio kayttoliittyma;
    private GrafiikkaSailio pelikartta;
    private GrafiikkaSailio ikkunat;
    
    private HiirenToiminnot hiirenToiminnot;
    private NappaimistonToiminnot nappaimistonToiminnot;
    
    public PeliRuutu(Peli peli){
        this.peli = peli;
        
        kayttoliittyma = new GrafiikkaSailio();
        pelikartta = new GrafiikkaSailio();
        ikkunat = new GrafiikkaSailio();
    }
    
    @Override
    public void paivita() {
        
    }

    @Override
    public void paint(Graphics2D g) {
        pelikartta.paint(g);
        
    }

    public GrafiikkaSailio getKayttoliittyma() {
        return kayttoliittyma;
    }

    public void setKayttoliittyma(GrafiikkaSailio kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
    }

    public GrafiikkaSailio getPelikartta() {
        return pelikartta;
    }

    public void setPelikartta(GrafiikkaSailio pelikartta) {
        this.pelikartta = pelikartta;
    }

    public GrafiikkaSailio getIkkunat() {
        return ikkunat;
    }

    public void setIkkunat(GrafiikkaSailio ikkunat) {
        this.ikkunat = ikkunat;
    }

    @Override
    public HiirenToiminnot hiirenToiminnot() {
        return hiirenToiminnot;
    }

    @Override
    public NappaimistonToiminnot nappaimistonToiminnot() {
        return nappaimistonToiminnot;
    }
    
    
    
}
