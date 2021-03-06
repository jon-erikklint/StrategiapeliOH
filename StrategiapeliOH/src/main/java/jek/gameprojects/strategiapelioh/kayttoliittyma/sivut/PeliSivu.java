package jek.gameprojects.strategiapelioh.kayttoliittyma.sivut;

import java.awt.Color;
import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.peli.Kierros;
import jek.gameprojects.strategiapelioh.domain.peli.Vuoro;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AktivoiRuutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AlustaHyokattavatRuudut;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AlustaLiikuttavatRuudut;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.HyokkaaRuutuun;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.LiikuRuutuun;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.LiikutaKameraa;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.MuutaKameranKokoa;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.RuudunValintaEfekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.VuoronLopetus;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.EhdollinenGrafiikkapainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaKartta;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkapainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kayttoliittyma;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectTeksti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.RuudunKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ToStringObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.YksikoidenKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.MonitasoinenPainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.SivujenHallinnoija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Tila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Tilat;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.EfektiNappaimenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.PerusNappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.NelioPainike;
import jek.gameprojects.strategiapelioh.logiikka.Peli;

public class PeliSivu implements Sivu{

    private Pelitila pelitila;
    
    private GrafiikkaSailio ikkunat;
    private Kayttoliittyma kayttoliittyma;
    private GrafiikkaKartta pelikartta;
    
    private MonitasoinenPainikkeidenKuuntelija painikkeidenKuuntelijat;
    
    private PerusNappaimistonToiminnot nappaimistonToiminnot;
    
    private Kamera karttakamera;
    private Kamera vakiokamera;
    
    public PeliSivu(Peli peli, SivujenHallinnoija sivujenHallinnoija){
        pelitila = new Pelitila();
        
        pelitila.setSivujenHallinnoija(sivujenHallinnoija);
        pelitila.setPeli(peli);
        pelitila.setRuudunKoko(new Vektori((peli.getKartta().getLeveys()*100), (peli.getKartta().getKorkeus())*100));
        
        kayttoliittyma = new Kayttoliittyma();
        pelikartta = new GrafiikkaKartta();
        ikkunat = new GrafiikkaSailio();
        
        karttakamera = new Kamera(new Vektori(peli.getKartta().getLeveys()*100, peli.getKartta().getKorkeus()*100), new Vektori(0,0), new Vektori(300,300));
        vakiokamera = new Kamera(new Vektori(1000,1000), new Vektori(0,0), new Vektori(1000,1000));
        
        init();
    }
    
    private void init(){
        alustaTilat();
        alustaPainikkeidenKuuntelijat();
        alustaRuudut();
        alustaPainikkeet();
        alustaMuutGrafiikkaobjektit();
        alustaNappaimistonToiminnot();
        alustaPelitila();
    }
    
    private void alustaTilat(){
        Tila<Vuoro> vuoro = new Tila<>(pelitila.getPeli().getVuoro());
        Tila<Kierros> kierros = new Tila<>(pelitila.getPeli().getKierros());
        
        Tilat pelinTilat = new Tilat(0, null, null, vuoro, kierros);
        pelitila.setTilat(pelinTilat);
    }
    
    private void alustaPainikkeidenKuuntelijat(){
        painikkeidenKuuntelijat = new MonitasoinenPainikkeidenKuuntelija();
        painikkeidenKuuntelijat.lisaaPainikkeienKuuntelija(new PainikkeidenKuuntelija(vakiokamera));
        painikkeidenKuuntelijat.lisaaPainikkeienKuuntelija(new PainikkeidenKuuntelija(karttakamera));
    }
    
    private void alustaRuudut(){
        Kartta kartta = pelitila.getPeli().getKartta();
        
        for(int i=0;i<kartta.getKorkeus();i++){
            for(int j=0;j<kartta.getLeveys();j++){
                
                RuudunKuva ruutu = luoRuutu( new Koordinaatti(j,i), kartta.getRuutu(new Koordinaatti(j,i)) );
                
                pelikartta.addRuutu(ruutu);
                
            }
        }
    }
    
    private RuudunKuva luoRuutu(Koordinaatti sijainti, Ruutu ruutu){
        Vektori ruudunSijainti = new Vektori(sijainti.getX()*100,sijainti.getY()*100);
        Vektori ruudunKoko = new Vektori(100,100);
        
        ToStringObjectKuva<Ruutu> ruutuKuva = new ToStringObjectKuva<>(KuvaSailio.getKuva(ruutu.toString()), ruudunSijainti, ruudunKoko, 1, true, ruutu);
        
        int alkuMaara = ruutu.yksikoidenMaara();
        if(alkuMaara>3){
            alkuMaara=3;
        }
        
        YksikoidenKuva yksikoidenKuva = new YksikoidenKuva(KuvaSailio.getKuva("Yksikoita:"+alkuMaara), ruudunSijainti, ruudunKoko, 1, true, ruutu);
        
        RuudunKuva ruudunKuva = new RuudunKuva(ruutuKuva, yksikoidenKuva);
        
        lisaaRuudunPainike(sijainti, ruudunKuva, ruutu);
        
        return ruudunKuva;
    }
    
    private void lisaaRuudunPainike(Koordinaatti sijainti, RuudunKuva ruutuKuva, Ruutu ruutu){
        
        AktivoiRuutu aktivoiRuutu = new AktivoiRuutu(pelitila, ruutuKuva);
        HyokkaaRuutuun hyokkaaRuutuun = new HyokkaaRuutuun(pelitila, ruutu);
        LiikuRuutuun liikuRuutuun = new LiikuRuutuun(pelitila, ruutu);
        
        RuudunValintaEfekti efekti = new RuudunValintaEfekti(pelitila, aktivoiRuutu, hyokkaaRuutuun, liikuRuutuun);
        
        NelioPainike painike = new NelioPainike(efekti, new Vektori(sijainti.getX()*100, sijainti.getY()*100), new Vektori(100,100), 1);
        
        painikkeidenKuuntelijat.getPainikkeidenKuuntelija(1).lisaaPainike(painike);
    }
    
    public void alustaPainikkeet(){
        
        Kuva hyokkaysKuva = new Kuva(KuvaSailio.getKuva("hyokkayspainike"), new Vektori(100, 800), new Vektori(100,100), 0, false);
        Kuva liikutusKuva = new Kuva(KuvaSailio.getKuva("liikutuspainike"), new Vektori(800,800), new Vektori(100,100), 0, false);
        Kuva vuoronLopetusKuva = new Kuva(KuvaSailio.getKuva("vuoronvaihtopainike"), new Vektori(450,0), new Vektori(100,30), 0, true);
        
        AlustaHyokattavatRuudut alustaHyokattavatRuudut = new AlustaHyokattavatRuudut(pelitila);
        NelioPainike hyokkayspainike = new NelioPainike(alustaHyokattavatRuudut, new Vektori(100, 800), new Vektori(100,100), 0);
        
        AlustaLiikuttavatRuudut alustaLiikuttavatRuudut = new AlustaLiikuttavatRuudut(pelitila);
        NelioPainike liikutuspainike = new NelioPainike(alustaLiikuttavatRuudut, new Vektori(800, 800), new Vektori(100,100), 0);
        
        VuoronLopetus vuoronLopetus = new VuoronLopetus(pelitila);
        NelioPainike lopetuspainike = new NelioPainike(vuoronLopetus, new Vektori(450, 0), new Vektori(100,30), 0);
        
        EhdollinenGrafiikkapainike hyokkays = new EhdollinenGrafiikkapainike(hyokkayspainike, hyokkaysKuva, pelitila);
        EhdollinenGrafiikkapainike liikutus = new EhdollinenGrafiikkapainike(liikutuspainike, liikutusKuva, pelitila);
        
        hyokkays.setNakyvyys(false);
        liikutus.setNakyvyys(false);
        
        Grafiikkapainike vuoronLopettaminen = new Grafiikkapainike(lopetuspainike, vuoronLopetusKuva);
        
        PainikkeidenKuuntelija vakiokuuntelija = painikkeidenKuuntelijat.getPainikkeidenKuuntelija(0);
        
        vakiokuuntelija.lisaaPainike(liikutus);
        vakiokuuntelija.lisaaPainike(hyokkays);
        vakiokuuntelija.lisaaPainike(vuoronLopettaminen);
        
        kayttoliittyma.setHyokkayspainike(hyokkays);
        kayttoliittyma.setLiikkumispainike(liikutus);
        kayttoliittyma.setVuoronLopetuspainike(vuoronLopettaminen);
    }
    
    public void alustaMuutGrafiikkaobjektit(){
        ObjectTeksti<Tila<Vuoro>> kenenVuoro = new ObjectTeksti<>(new Vektori(10,10), new Vektori(), 0, "", Color.WHITE, null, true, pelitila.getTilat().getVuoro());
        ObjectTeksti<Tila<Kierros>> moneskoKierros = new ObjectTeksti<>(new Vektori(10,20), new Vektori(), 0, "", Color.WHITE, null, true, pelitila.getTilat().getKierros());
        
        kayttoliittyma.lisaaGrafiikkaobjekti(kenenVuoro);
        kayttoliittyma.lisaaGrafiikkaobjekti(moneskoKierros);
    }
    
    public void alustaNappaimistonToiminnot(){
        
        nappaimistonToiminnot = new PerusNappaimistonToiminnot();
        
        LiikutaKameraa oikealle = new LiikutaKameraa(pelitila, karttakamera, new Vektori(5,0));
        LiikutaKameraa vasemmalle = new LiikutaKameraa(pelitila, karttakamera, new Vektori(-5,0));
        LiikutaKameraa ylos = new LiikutaKameraa(pelitila, karttakamera, new Vektori(0,-5));
        LiikutaKameraa alas = new LiikutaKameraa(pelitila, karttakamera, new Vektori(0,5));
        
        MuutaKameranKokoa pienemmaksi = new MuutaKameranKokoa(pelitila, karttakamera, new Vektori(-10,-10));
        MuutaKameranKokoa isommaksi = new MuutaKameranKokoa(pelitila, karttakamera, new Vektori(10,10));
        
        VuoronLopetus lopetaVuoro = new VuoronLopetus(pelitila);
        
        EfektiNappaimenKuuntelija oikealleKuuntelija = new EfektiNappaimenKuuntelija(68, oikealle);
        EfektiNappaimenKuuntelija vasemmalleKuuntelija = new EfektiNappaimenKuuntelija(65, vasemmalle);
        EfektiNappaimenKuuntelija ylosKuuntelija = new EfektiNappaimenKuuntelija(87, ylos);
        EfektiNappaimenKuuntelija alasKuuntelija = new EfektiNappaimenKuuntelija(83, alas);
        
        EfektiNappaimenKuuntelija pienemmaksiKuuntelija = new EfektiNappaimenKuuntelija(40, pienemmaksi);
        EfektiNappaimenKuuntelija isommaksiKuuntelija = new EfektiNappaimenKuuntelija(38, isommaksi);
        
        EfektiNappaimenKuuntelija vuoronLopetusKuuntelija = new EfektiNappaimenKuuntelija(10, lopetaVuoro);
        
        nappaimistonToiminnot.lisaaNappaimenKuuntelija(oikealleKuuntelija);
        nappaimistonToiminnot.lisaaNappaimenKuuntelija(vasemmalleKuuntelija);
        nappaimistonToiminnot.lisaaNappaimenKuuntelija(alasKuuntelija);
        nappaimistonToiminnot.lisaaNappaimenKuuntelija(ylosKuuntelija);
        
        nappaimistonToiminnot.lisaaNappaimenKuuntelija(pienemmaksiKuuntelija);
        nappaimistonToiminnot.lisaaNappaimenKuuntelija(isommaksiKuuntelija);
        
        nappaimistonToiminnot.lisaaNappaimenKuuntelija(vuoronLopetusKuuntelija);
        
    }
    
    public void alustaPelitila(){
        pelitila.setIkkunat(ikkunat);
        pelitila.setKartta(pelikartta);
        pelitila.setKayttoliittyma(kayttoliittyma);
        
        pelitila.setPelikamera(karttakamera);
        pelitila.setVakiokamera(vakiokamera);
        
        pelitila.setNappaimistonToiminnot(nappaimistonToiminnot);
        pelitila.setPainikkeidenKuuntelija(painikkeidenKuuntelijat);
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

    public Kayttoliittyma getKayttoliittyma() {
        return kayttoliittyma;
    }

    public void setKayttoliittyma(Kayttoliittyma kayttoliittyma) {
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
        return painikkeidenKuuntelijat;
    }

    @Override
    public NappaimistonToiminnot nappaimistonToiminnot() {
        return nappaimistonToiminnot;
    }
    
}
