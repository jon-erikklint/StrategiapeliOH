package jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maastotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Ase;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkaava;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkays;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssari;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Sotilas;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import jek.gameprojects.strategiapelioh.logiikka.generointi.aseet.PanssarivahvuuksienVakioAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.JoukkojenHallinnoija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TaistelulaskuriTest {
    
    Sotilas sotilas1;
    Sotilas sotilas2;
    Sotilas sotilas3;
    Sotilas sotilas4;
    
    Taistelulaskuri taistelulaskuri;
    
    public TaistelulaskuriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Liikkuvuus liikkuvuus = new Liikkuvuus(new HashMap<Aluetyyppi, Boolean>(), new HashMap<Maastotyyppi, Double>(), 0);
        
        List<Ase> aseet = new ArrayList<>();
        aseet.add(new Ase(1, Asetyyppi.LASER, 0, 1, false));
        List<Panssari> panssarit = new ArrayList<>();
        
        Hyokkays hyokkays1 = new Hyokkays(5, 1, aseet, panssarit);
        
        aseet = new ArrayList<>();
        aseet.add(new Ase(10, Asetyyppi.LASER, 0, 1, true));
        panssarit = new ArrayList<>();
        panssarit.add(new Panssari(0.9, Panssarityyppi.TERAS));
        
        Hyokkays hyokkays2 = new Hyokkays(10, 1, aseet, panssarit);
        
        aseet = new ArrayList<>();
        aseet.add(new Ase(10, Asetyyppi.LASER, 0, 1, true));
        panssarit = new ArrayList<>();
        panssarit.add(new Panssari(0.9, Panssarityyppi.TERAS));
        panssarit.add(new Panssari(0.5, Panssarityyppi.TERAS));
        
        Hyokkays hyokkays3 = new Hyokkays(15, 1, aseet, panssarit);
        
        Yksikkotyyppi yksikkotyyppi1 = new Yksikkotyyppi("", liikkuvuus, hyokkays1);
        Yksikkotyyppi yksikkotyyppi2 = new Yksikkotyyppi("", liikkuvuus, hyokkays2);
        Yksikkotyyppi yksikkotyyppi3 = new Yksikkotyyppi("", liikkuvuus, hyokkays3);
        
        Pelaaja pelaaja1 = new Pelaaja(0,"");
        Pelaaja pelaaja2 = new Pelaaja(1,"");
        
        Joukko joukko1 = new Joukko();
        Joukko joukko2 = new Joukko();
        
        this.sotilas1 = new Sotilas(yksikkotyyppi1, new Koordinaatti(0,0), pelaaja1, joukko1, 0);
        this.sotilas2 = new Sotilas(yksikkotyyppi2, new Koordinaatti(0,0), pelaaja1, joukko1, 1);
        this.sotilas3 = new Sotilas(yksikkotyyppi2, new Koordinaatti(0,0), pelaaja2, joukko2, 2);
        this.sotilas4 = new Sotilas(yksikkotyyppi3, new Koordinaatti(0,0), pelaaja2, joukko2, 3);
        
        PanssarivahvuuksienVakioAlustaja apu = new PanssarivahvuuksienVakioAlustaja();
        
        JoukkojenHallinnoija joukkojenHallinnoija = new JoukkojenHallinnoija(Arrays.asList(pelaaja1,pelaaja2), new Kartta(null, 0, 0));
        
        taistelulaskuri = new Taistelulaskuri(apu.panssarityyppienVahvuudet(), joukkojenHallinnoija);
     
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void antaakoPanssarinVahvuudenOikeinTyhjalle(){
        assertEquals(1.0, taistelulaskuri.haeVahvinPanssari( Asetyyppi.RAJAHDE, sotilas1.hyokkays().getPanssarit() ) , 0.01);
    }
    
    @Test
    public void antaakoPanssarinVahvuudenOikeinYhdelle(){
        assertEquals(0.9, taistelulaskuri.haeVahvinPanssari(Asetyyppi.RAJAHDE, sotilas2.hyokkays().getPanssarit() ), 0.01);
    }
    
    @Test
    public void antaakoPanssarinVahvuudenOikeinMonelle(){
        assertEquals(0.5, taistelulaskuri.haeVahvinPanssari(Asetyyppi.RAJAHDE, sotilas4.hyokkays().getPanssarit() ), 0.01);
    }
    
    @Test
    public void loytaakoParhaanPuolustajan(){
        List<Hyokkaava> puolustajat = new ArrayList<>();
        
        puolustajat.add(sotilas2);
        puolustajat.add(sotilas3);
        puolustajat.add(sotilas4);
        
        taistelulaskuri.setPuolustajat(puolustajat);
        
        assertEquals(sotilas4, taistelulaskuri.haePahinPuolustaja(sotilas1));
        
        puolustajat = new ArrayList<>();
        
        puolustajat.add(sotilas1);
        puolustajat.add(sotilas3);
        
        taistelulaskuri.setPuolustajat(puolustajat);
        
        assertEquals(sotilas3, taistelulaskuri.haePahinPuolustaja(sotilas2));
        
        puolustajat = new ArrayList<>();
        
        puolustajat.add(sotilas1);
        puolustajat.add(sotilas4);
        
        taistelulaskuri.setPuolustajat(puolustajat);
        
        assertEquals(sotilas4, taistelulaskuri.haePahinPuolustaja(sotilas2));
    }
    
    @Test
    public void antaakoPuolustusmahdollisuudenOikein(){
        assertEquals(true, taistelulaskuri.puolustajaVoiTehdaVastaiskun(sotilas1, sotilas1));
        
        assertEquals(false, taistelulaskuri.puolustajaVoiTehdaVastaiskun(sotilas2, sotilas2));
    }
    
    @Test
    public void onkoSatunnaisluvutOikein(){
        for(int i=0;i<10;i++){
            assertEquals(true, taistelulaskuri.annaSatunnaisuuskerroin(-0.500001)==0);
        }
        
        for(int i=0;i<10;i++){
            assertEquals(true,taistelulaskuri.annaSatunnaisuuskerroin(0.5)>0);
        }
        
        for (int i = 0; i < 10; i++) {
            assertEquals(true,taistelulaskuri.annaSatunnaisuuskerroin(1)==1);
        }
    }
    
    @Test
    public void nollausToimii(){
        List<Hyokkaava> hyokkaavat = new ArrayList<>();
        hyokkaavat.add(sotilas1);
        
        List<Hyokkaava> puolustavat = new ArrayList<>();
        puolustavat.add(sotilas2);
        
        taistelulaskuri.setHyokkaajat(hyokkaavat);
        taistelulaskuri.setPuolustajat(puolustavat);
        
        taistelulaskuri.nollaa();
        
        assertEquals(true, taistelulaskuri.getHyokkaajat().isEmpty());
        assertEquals(true, taistelulaskuri.getPuolustajat().isEmpty());
    }
    
    @Test
    public void tarkistaTehtyVahinko(){
        Ase apuase = new Ase(10, Asetyyppi.LASER, 1, 1, true);
        
        int vastaus = taistelulaskuri.vahinko(1, apuase);
        assertEquals(10, vastaus);
        
        vastaus = taistelulaskuri.vahinko(0.5, apuase);
        
        assertEquals(5, vastaus);
        
        taistelulaskuri.setRandomSeed(1);
        
        vastaus = taistelulaskuri.vahinko(1, new Ase(10, Asetyyppi.LASER, 0, 1, true));
        
        assertEquals(7, vastaus);
    }
    
    @Test
    public void toimiikoKuolemanHallinnointi(){
        sotilas1.menetaElamaa(5);
        
        List<Hyokkaava> sotilaat = new ArrayList<>();
        sotilaat.add(sotilas1);
        
        taistelulaskuri.setHyokkaajat(sotilaat);
        
        taistelulaskuri.hallinnoiKuolema(sotilas1, true);
        
        assertEquals(true, taistelulaskuri.getHyokkaajat().isEmpty());
        assertEquals(true, sotilas1.onkoKuollut());
        assertEquals(false, sotilas1.getJoukko().getYksikot().contains(sotilas1));
    }
    
    @Test
    public void taistelutestiYksittaisilleYksikoille(){
        List<Hyokkaava> puolustajat = new ArrayList<>();
        
        puolustajat.add(sotilas3);
        puolustajat.add(sotilas4);
        
        taistelulaskuri.setPuolustajat(puolustajat);
        taistelulaskuri.setRandomSeed(0);
        
        taistelulaskuri.sotilasTaistelee(sotilas2);
        
        assertEquals(10,sotilas2.getElamat());
        assertEquals(12,sotilas4.getElamat());
    }
    
    @Test
    public void taistelutestiKokoRyhmille(){
        List<Hyokkaava> hyokkaajat = new ArrayList<>();
        List<Hyokkaava> puolustajat = new ArrayList<>();
        
        hyokkaajat.add(sotilas1);
        hyokkaajat.add(sotilas2);
        
        puolustajat.add(sotilas3);
        puolustajat.add(sotilas4);
        
        taistelulaskuri.setHyokkaajat(hyokkaajat);
        taistelulaskuri.setPuolustajat(puolustajat);
        
        taistelulaskuri.setRandomSeed(0);
        
        taistelulaskuri.taistele();
        
        assertEquals(5, sotilas1.getElamat());
        assertEquals(10, sotilas2.getElamat());
        assertEquals(10, sotilas3.getElamat());
        assertEquals(12, sotilas4.getElamat());
        
    }
}
