package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaKartta;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.PerusNappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.logiikka.Peli;

public class Pelitila {
    
    private Peli peli;
    
    private Tilat tilat;
    
    private Kamera vakiokamera;
    private Kamera pelikamera;
    
    private GrafiikkaSailio ikkunat;
    private GrafiikkaSailio kayttoliittyma;
    private GrafiikkaKartta kartta;
    
    private PainikkeidenKuuntelija painikkeidenKuuntelija;
    private PerusNappaimistonToiminnot nappaimistonToiminnot;

    public Pelitila(Peli peli, Tilat tilat, Kamera vakiokamera, Kamera pelikamera, GrafiikkaSailio ikkunat, GrafiikkaSailio kayttoliittyma, GrafiikkaKartta kartta, PainikkeidenKuuntelija painikkeidenKuuntelija, PerusNappaimistonToiminnot nappaimistonToiminnot) {
        this.peli = peli;
        this.tilat = tilat;
        this.vakiokamera = vakiokamera;
        this.pelikamera = pelikamera;
        this.ikkunat = ikkunat;
        this.kayttoliittyma = kayttoliittyma;
        this.painikkeidenKuuntelija = painikkeidenKuuntelija;
        this.nappaimistonToiminnot = nappaimistonToiminnot;
    }
    
    public Pelitila(){}
    
    public void paivita(){
        tilat.nollaaTilanne();
        
        kartta.paivita();
        ikkunat.paivita();
        kayttoliittyma.paivita();
    }
    
    public Peli getPeli() {
        return peli;
    }

    public void setPeli(Peli peli) {
        this.peli = peli;
    }

    public Tilat getTilat() {
        return tilat;
    }

    public void setTilat(Tilat tilat) {
        this.tilat = tilat;
    }

    public Kamera getVakiokamera() {
        return vakiokamera;
    }

    public void setVakiokamera(Kamera vakiokamera) {
        this.vakiokamera = vakiokamera;
    }

    public Kamera getPelikamera() {
        return pelikamera;
    }

    public void setPelikamera(Kamera pelikamera) {
        this.pelikamera = pelikamera;
    }

    public GrafiikkaSailio getIkkunat() {
        return ikkunat;
    }

    public void setIkkunat(GrafiikkaSailio ikkunat) {
        this.ikkunat = ikkunat;
    }

    public GrafiikkaSailio getKayttoliittyma() {
        return kayttoliittyma;
    }

    public void setKayttoliittyma(GrafiikkaSailio kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
    }

    public PainikkeidenKuuntelija getPainikkeidenKuuntelija() {
        return painikkeidenKuuntelija;
    }

    public void setPainikkeidenKuuntelija(PainikkeidenKuuntelija painikkeidenKuuntelija) {
        this.painikkeidenKuuntelija = painikkeidenKuuntelija;
    }

    public PerusNappaimistonToiminnot getNappaimistonToiminnot() {
        return nappaimistonToiminnot;
    }

    public void setNappaimistonToiminnot(PerusNappaimistonToiminnot nappaimistonToiminnot) {
        this.nappaimistonToiminnot = nappaimistonToiminnot;
    }

    public GrafiikkaKartta getKartta() {
        return kartta;
    }

    public void setKartta(GrafiikkaKartta kartta) {
        this.kartta = kartta;
    }
    
    
}
