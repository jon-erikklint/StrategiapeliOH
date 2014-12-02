package jek.gameprojects.strategiapelioh.kayttoliittyma.sivut;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkapainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.RuutuPainike;
import jek.gameprojects.strategiapelioh.logiikka.Peli;

public class PeliSivu implements Sivu{

    private final Peli peli;
    
    private GrafiikkaSailio kayttoliittyma;
    private GrafiikkaSailio pelikartta;
    private GrafiikkaSailio ikkunat;
    
    private HiirenToiminnot hiirenToiminnot;
    private NappaimistonToiminnot nappaimistonToiminnot;
    
    private Kamera karttakamera;
    private Kamera vakiokamera;
    
    public PeliSivu(Peli peli){
        this.peli = peli;
        
        kayttoliittyma = new GrafiikkaSailio();
        pelikartta = new GrafiikkaSailio();
        ikkunat = new GrafiikkaSailio();
        
        karttakamera = new Kamera(new Vektori(peli.getKartta().getLeveys()*100, peli.getKartta().getKorkeus()*100), new Vektori(0,0), new Vektori(100,100));
        vakiokamera = new Kamera(new Vektori(1000,1000), new Vektori(0,0), new Vektori(1000,1000));
        
    }
    
    public void alustaSivu(){
        luoRuudut();
    }
    
    private void luoRuudut(){
        Kartta kartta = peli.getKartta();
        
        for(int i=0;i<kartta.getKorkeus();i++){
            for(int j=0;j<kartta.getLeveys();i++){
                
                pelikartta.lisaaGrafiikkaobjekti(luoRuutu( new Koordinaatti(j,i) , kartta.getRuutu(new Koordinaatti(j,i)) ));
                
            }
        }
    }
    
    private Grafiikkapainike luoRuutu(Koordinaatti sijainti, Ruutu ruutu){
        Vektori ruudunSijainti = new Vektori(sijainti.getX()*100,sijainti.getY()*100);
        Vektori ruudunKoko = new Vektori(100,100);
        
        ObjectKuva<Ruutu> ruudunKuva = new ObjectKuva<>(KuvaSailio.getKuva(ruutu.toString()), ruudunSijainti, ruudunKoko, 1, true, ruutu);
        RuutuPainike painike = new RuutuPainike(ruudunSijainti, ruudunKoko, 1, ruudunKuva);
        
        return new Grafiikkapainike(painike, ruudunKuva);
    }
    
    @Override
    public void paivita() {
        kayttoliittyma.paivita();
        ikkunat.paivita();
    }

    @Override
    public void paint(Graphics2D g) {
        pelikartta.paint(g, karttakamera);
        
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
