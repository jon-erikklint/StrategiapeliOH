package jek.gameprojects.strategiapelioh.kayttoliittyma.tilat;

import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaKartta;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kayttoliittyma;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.MonitasoinenPainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.PerusNappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.Painike;
import jek.gameprojects.strategiapelioh.logiikka.Peli;

public class Pelitila {
    
    private SivujenHallinnoija sivujenHallinnoija;
    
    private Peli peli;
    
    private Vektori ruudunKoko;
    
    private Tilat tilat;
    
    private Kamera vakiokamera;
    private Kamera pelikamera;
    
    private GrafiikkaSailio ikkunat;
    private Kayttoliittyma kayttoliittyma;
    private GrafiikkaKartta kartta;
    
    private MonitasoinenPainikkeidenKuuntelija painikkeidenKuuntelija;
    private PerusNappaimistonToiminnot nappaimistonToiminnot;

    public Pelitila(SivujenHallinnoija sivujenHallinnoija, Peli peli, Tilat tilat, Kamera vakiokamera, Kamera pelikamera, GrafiikkaSailio ikkunat, Kayttoliittyma kayttoliittyma, GrafiikkaKartta kartta, MonitasoinenPainikkeidenKuuntelija painikkeidenKuuntelija, PerusNappaimistonToiminnot nappaimistonToiminnot) {
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
        tyhjennaValinnat();
        peli.nollaaLogiikka();
        
        Pelaaja voittaja = peli.tarkistaVoittaja();
        if(voittaja != null){
            
        }
        
        tilat.getKierros().setT(peli.getKierros());
        tilat.getVuoro().setT(peli.getVuoro());
        
        ikkunat.paivita();
        kayttoliittyma.paivita();
    }
    
    public void tyhjennaValinnat(){
        kartta.paivita();
        
        tilat.nollaaTilanne();
        
        if(kayttoliittyma.getYksikoidenKuvakkeet() != null){
            PainikkeidenKuuntelija kuuntelija = painikkeidenKuuntelija.getPainikkeidenKuuntelija(0);
            
            for(Painike painike :kayttoliittyma.getYksikoidenKuvakkeet().getPainikkeet()){
                kuuntelija.poistaPainike(painike);
            }
            
            kayttoliittyma.setYksikoidenKuvakkeet(null);
        }
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

    public Kayttoliittyma getKayttoliittyma() {
        return kayttoliittyma;
    }

    public void setKayttoliittyma(Kayttoliittyma kayttoliittyma) {
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
