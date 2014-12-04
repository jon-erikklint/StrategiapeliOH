package jek.gameprojects.strategiapelioh.kayttoliittyma.sivut;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AktivoiRuutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AlustaHyokattavatRuudut;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AlustaLiikuttavatRuudut;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.HyokkaaRuutuun;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.LiikuRuutuun;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.RuudunValintaEfekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaKartta;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkapainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Tilat;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.EhdollinenNelioPainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.NelioPainike;
import jek.gameprojects.strategiapelioh.logiikka.Peli;

public class PeliSivu implements Sivu{

    private Pelitila pelitila;
    
    private GrafiikkaSailio kayttoliittyma;
    private GrafiikkaSailio ikkunat;
    private GrafiikkaKartta pelikartta;
    
    private PainikkeidenKuuntelija hiirenToiminnot;
    private NappaimistonToiminnot nappaimistonToiminnot;
    
    private Kamera karttakamera;
    private Kamera vakiokamera;
    
    public PeliSivu(Peli peli){
        pelitila = new Pelitila();
        
        pelitila.setPeli(peli);
        
        kayttoliittyma = new GrafiikkaSailio();
        pelikartta = new GrafiikkaKartta();
        ikkunat = new GrafiikkaSailio();
        
        karttakamera = new Kamera(new Vektori(peli.getKartta().getLeveys()*100, peli.getKartta().getKorkeus()*100), new Vektori(0,0), new Vektori(100,100));
        vakiokamera = new Kamera(new Vektori(1000,1000), new Vektori(0,0), new Vektori(1000,1000));
        
        alustaSivu();
    }
    
    public final void alustaSivu(){
        alustaTilat();
        luoRuudut();
        luoPainikkeet();
        alustaPelitila();
    }
    
    private void alustaTilat(){
        Tilat pelinTilat = new Tilat(0, null, null);
        pelitila.setTilat(pelinTilat);
    }
    
    private void luoRuudut(){
        Kartta kartta = pelitila.getPeli().getKartta();
        
        for(int i=0;i<kartta.getKorkeus();i++){
            for(int j=0;j<kartta.getLeveys();i++){
                
                pelikartta.addRuutu(luoRuutu( new Koordinaatti(j,i) , kartta.getRuutu(new Koordinaatti(j,i)) ));
                
            }
        }
    }
    
    private ObjectKuva<Ruutu> luoRuutu(Koordinaatti sijainti, Ruutu ruutu){
        Vektori ruudunSijainti = new Vektori(sijainti.getX()*100,sijainti.getY()*100);
        Vektori ruudunKoko = new Vektori(100,100);
        
        ObjectKuva<Ruutu> ruudunKuva = new ObjectKuva<>(KuvaSailio.getKuva(ruutu.toString()), ruudunSijainti, ruudunKoko, 1, true, ruutu);
        
        lisaaRuudunPainike(sijainti,ruudunKuva);
        
        return ruudunKuva;
    }
    
    
    private void lisaaRuudunPainike(Koordinaatti sijainti, ObjectKuva<Ruutu> ruutu){
        
        AktivoiRuutu aktivoiRuutu = new AktivoiRuutu(pelitila, ruutu);
        HyokkaaRuutuun hyokkaaRuutuun = new HyokkaaRuutuun(pelitila, ruutu.getT());
        LiikuRuutuun liikuRuutuun = new LiikuRuutuun(pelitila, ruutu.getT());
        
        RuudunValintaEfekti efekti = new RuudunValintaEfekti(pelitila, aktivoiRuutu, hyokkaaRuutuun, liikuRuutuun);
        
        NelioPainike painike = new NelioPainike(efekti, new Vektori(sijainti.getX()*100, sijainti.getY()*100), new Vektori(100,100), 1);
        
        hiirenToiminnot.lisaaPainike(painike);
    }
    
    public void luoPainikkeet(){
        Kuva hyokkaysKuva = new Kuva(KuvaSailio.getKuva("hyokkayspainike"), new Vektori(100, 800), new Vektori(100,100), 0, false);
        Kuva liikutusKuva = new Kuva(KuvaSailio.getKuva("liikutuspainike"), new Vektori(800,800), new Vektori(100,100), 0, false);
        
        AlustaHyokattavatRuudut alustaHyokattavatRuudut = new AlustaHyokattavatRuudut(pelitila);
        EhdollinenNelioPainike hyokkayspainike = new EhdollinenNelioPainike(alustaHyokattavatRuudut, new Vektori(100, 800), new Vektori(100,100), 0, hyokkaysKuva, pelitila);
        
        AlustaLiikuttavatRuudut alustaLiikuttavatRuudut = new AlustaLiikuttavatRuudut(pelitila);
        EhdollinenNelioPainike liikutuspainike = new EhdollinenNelioPainike(alustaLiikuttavatRuudut, new Vektori(800, 800), new Vektori(100,100), 0, liikutusKuva, pelitila);
        
        Grafiikkapainike hyokkays = new Grafiikkapainike(hyokkayspainike, hyokkaysKuva);
        Grafiikkapainike liikutus = new Grafiikkapainike(liikutuspainike, liikutusKuva);
        
        kayttoliittyma.lisaaGrafiikkaobjekti(hyokkays);
        kayttoliittyma.lisaaGrafiikkaobjekti(liikutus);
    }
    
    public void alustaPelitila(){
        
    }
    
    @Override
    public void paivita() {
        kayttoliittyma.paivita();
        ikkunat.paivita();
    }

    @Override
    public void paint(Graphics2D g) {
        pelikartta.paint(g, karttakamera);
        ikkunat.paint(g, vakiokamera);
        kayttoliittyma.paint(g, vakiokamera);
    }

    public GrafiikkaSailio getKayttoliittyma() {
        return kayttoliittyma;
    }

    public void setKayttoliittyma(GrafiikkaSailio kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
    }

    public GrafiikkaKartta getPelikartta() {
        return pelikartta;
    }

    public void setPelikartta(GrafiikkaKartta pelikartta) {
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
