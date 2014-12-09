package jek.gameprojects.strategiapelioh.kayttoliittyma.tilat;

import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Tilat;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaKartta;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.RuudunKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.MonitasoinenPainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.PerusNappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.logiikka.Peli;

public class Pelitila {
    
    private SivujenHallinnoija sivujenHallinnoija;
    
    private Peli peli;
    
    private Vektori ruudunKoko;
    
    private Tilat tilat;
    
    private Kamera vakiokamera;
    private Kamera pelikamera;
    
    private GrafiikkaSailio ikkunat;
    private GrafiikkaSailio kayttoliittyma;
    private GrafiikkaKartta kartta;
    
    private MonitasoinenPainikkeidenKuuntelija painikkeidenKuuntelija;
    private PerusNappaimistonToiminnot nappaimistonToiminnot;

    public Pelitila(SivujenHallinnoija sivujenHallinnoija, Peli peli, Tilat tilat, Kamera vakiokamera, Kamera pelikamera, GrafiikkaSailio ikkunat, GrafiikkaSailio kayttoliittyma, GrafiikkaKartta kartta, MonitasoinenPainikkeidenKuuntelija painikkeidenKuuntelija, PerusNappaimistonToiminnot nappaimistonToiminnot) {
        this.sivujenHallinnoija = sivujenHallinnoija;
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
        peli.nollaaLogiikka();
        tilat.nollaaTilanne();
        
        tilat.getKierros().setT(peli.getKierros());
        tilat.getVuoro().setT(peli.getVuoro());
        
        kartta.paivita();
        ikkunat.paivita();
        kayttoliittyma.paivita();
    }
    
    public void tyhjennaValinnat(){
        RuudunKuva ruutu = tilat.getValittuRuutu();
        
        if(ruutu != null){
            ruutu.paivita();
        }
        
        paivitaHyokattavatRuudut();
        paivitaLiikuttavatRuudut();
        
        tilat.nollaaTilanne();
    }
    
    public void paivitaHyokattavatRuudut(){
        Set<Koordinaatti> hyokattavat = peli.getHyokkayshallinnoija().getJoukonHyokattavatRuudut(tilat.getValitutYksikot());
        
        if(hyokattavat != null){
            paivitaRuudut(hyokattavat);
        }
    }
    
    public void paivitaLiikuttavatRuudut(){
        Set<Koordinaatti> liikuttavat = peli.getLiikuttaja().annaJoukonMahdollisetLiikkeet(tilat.getValitutYksikot());
        
        if(liikuttavat != null){
            paivitaRuudut(liikuttavat);
        }
    }
    
    public void paivitaRuudut(Set<Koordinaatti> sijainnit){
        for(Koordinaatti sijainti : sijainnit){
            kartta.getRuutu(sijainti).paivita();
        }
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

    public MonitasoinenPainikkeidenKuuntelija getPainikkeidenKuuntelija() {
        return painikkeidenKuuntelija;
    }

    public void setPainikkeidenKuuntelija(MonitasoinenPainikkeidenKuuntelija painikkeidenKuuntelija) {
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

    public Vektori getRuudunKoko() {
        return ruudunKoko;
    }

    public void setRuudunKoko(Vektori ruudunKoko) {
        this.ruudunKoko = ruudunKoko;
    }

    public SivujenHallinnoija getSivujenHallinnoija() {
        return sivujenHallinnoija;
    }

    public void setSivujenHallinnoija(SivujenHallinnoija sivujenHallinnoija) {
        this.sivujenHallinnoija = sivujenHallinnoija;
    }
}
