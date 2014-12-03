package jek.gameprojects.strategiapelioh.kayttoliittyma.sivut;

import java.awt.Graphics2D;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AktivoiRuutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AlustaHyokattavatRuudut;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.AlustaLiikuttavatRuudut;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.HyokkaaRuutuun;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.LiikuRuutuun;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.RuudunValintaEfekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Tila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.GrafiikkaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkapainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kamera;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.PainikkeidenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.Hyokkaysavustaja;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.Liikkumisavustaja;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.TilaAvustaja;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.EhdollinenNelioPainike;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.NelioPainike;
import jek.gameprojects.strategiapelioh.logiikka.Peli;

public class PeliSivu implements Sivu{

    private final Peli peli;
    
    private GrafiikkaSailio kayttoliittyma;
    private GrafiikkaSailio pelikartta;
    private GrafiikkaSailio ikkunat;
    
    private PainikkeidenKuuntelija hiirenToiminnot;
    private NappaimistonToiminnot nappaimistonToiminnot;
    
    private Kamera karttakamera;
    private Kamera vakiokamera;
    
    private Hyokkaysavustaja hyokkaysavustaja;
    private Liikkumisavustaja liikkumisavustaja;
    private TilaAvustaja tilaAvustaja;
    
    public PeliSivu(Peli peli){
        this.peli = peli;
        
        kayttoliittyma = new GrafiikkaSailio();
        pelikartta = new GrafiikkaSailio();
        ikkunat = new GrafiikkaSailio();
        
        karttakamera = new Kamera(new Vektori(peli.getKartta().getLeveys()*100, peli.getKartta().getKorkeus()*100), new Vektori(0,0), new Vektori(100,100));
        vakiokamera = new Kamera(new Vektori(1000,1000), new Vektori(0,0), new Vektori(1000,1000));
        
        alustaSivu();
    }
    
    public final void alustaSivu(){
        alustaAvustajat();
        luoRuudut();
        luoPainikkeet();
    }
    
    private void alustaAvustajat(){
        Tila<Integer> pelitila = new Tila<>(0);
        Tila<Ruutu> valittuRuutu = new Tila<>(null);
        Tila<Joukko> valitutYksikot = new Tila<>(null);
        
        hyokkaysavustaja = new Hyokkaysavustaja(peli.getHyokkayshallinnoija(), valitutYksikot);
        liikkumisavustaja = new Liikkumisavustaja(peli.getLiikuttaja(), valitutYksikot);
        tilaAvustaja = new TilaAvustaja(pelitila, valittuRuutu, valitutYksikot, pelikartta);
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
        
        AktivoiRuutu aktivoiRuutu = new AktivoiRuutu(ruudunKuva, tilaAvustaja);
        HyokkaaRuutuun hyokkaaRuutuun = new HyokkaaRuutuun(hyokkaysavustaja, tilaAvustaja, ruutu);
        LiikuRuutuun liikuRuutuun = new LiikuRuutuun(liikkumisavustaja, tilaAvustaja, ruutu);
        
        RuudunValintaEfekti efekti = new RuudunValintaEfekti(tilaAvustaja.getPelitila(), aktivoiRuutu, hyokkaaRuutuun, liikuRuutuun);
        
        NelioPainike painike = new NelioPainike(efekti, ruudunSijainti, ruudunKoko, 1);
        
        return new Grafiikkapainike(painike, ruudunKuva);
    }
    
    public void luoPainikkeet(){
        Kuva hyokkaysKuva = new Kuva(KuvaSailio.getKuva("hyokkayspainike"), new Vektori(100, 800), new Vektori(100,100), 0, false);
        Kuva liikutusKuva = new Kuva(KuvaSailio.getKuva("liikutuspainike"), new Vektori(800,800), new Vektori(100,100), 0, false);
        
        AlustaHyokattavatRuudut alustaHyokattavatRuudut = new AlustaHyokattavatRuudut(hyokkaysavustaja, pelikartta.getGrafiikkaobjektit());
        EhdollinenNelioPainike hyokkayspainike = new EhdollinenNelioPainike(alustaHyokattavatRuudut, new Vektori(100, 800), new Vektori(100,100), 0, tilaAvustaja.getValittuRuutu(), hyokkaysKuva);
        
        AlustaLiikuttavatRuudut alustaLiikuttavatRuudut = new AlustaLiikuttavatRuudut(liikkumisavustaja, pelikartta.getGrafiikkaobjektit());
        EhdollinenNelioPainike liikutuspainike = new EhdollinenNelioPainike(alustaLiikuttavatRuudut, new Vektori(800, 800), new Vektori(100,100), 0, tilaAvustaja.getValittuRuutu(), liikutusKuva);
        
        Grafiikkapainike hyokkays = new Grafiikkapainike(hyokkayspainike, hyokkaysKuva);
        Grafiikkapainike liikutus = new Grafiikkapainike(liikutuspainike, liikutusKuva);
        
        kayttoliittyma.lisaaGrafiikkaobjekti(hyokkays);
        kayttoliittyma.lisaaGrafiikkaobjekti(liikutus);
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
