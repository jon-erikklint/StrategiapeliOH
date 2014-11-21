package jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maastotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Ase;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkays;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssari;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Sotilas;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen.KantamanLaskija;
import jek.gameprojects.strategiapelioh.logiikka.liikkuminen.Reitinhakija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KantamanLaskijaTest {
    
    private KantamanLaskija kantamanLaskija;
    
    Sotilas sotilas1;
    Sotilas sotilas2;
    
    public KantamanLaskijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Ruutu[][] ruudut=new Ruutu[4][4];
        
        Maasto perusmaasto=new Maasto(Aluetyyppi.MAA,Maastotyyppi.AVOMAA,0);
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                Ruutu ruutu=new Ruutu(new Koordinaatti(i,j), perusmaasto);
                ruudut[i][j]=ruutu;
            }
        }
        
        Kartta kartta = new Kartta(ruudut,4,4);
        kantamanLaskija = new KantamanLaskija(kartta);
        
        //---
        
        Liikkuvuus liikkuvuus = new Liikkuvuus(new HashMap<Aluetyyppi, Boolean>(), new HashMap<Maastotyyppi, Double>(), 0);
        
        List<Ase> aseet = new ArrayList<>();
        aseet.add(new Ase(0, Asetyyppi.LASER, 0));
        
        Hyokkays hyokkays1 = new Hyokkays(1, 2, true, aseet, new ArrayList<Panssari>());
        Hyokkays hyokkays2 = new Hyokkays(1, 6, true, aseet, new ArrayList<Panssari>());
        
        Yksikkotyyppi yksikkotyyppi1 = new Yksikkotyyppi("", liikkuvuus, hyokkays1);
        Yksikkotyyppi yksikkotyyppi2 = new Yksikkotyyppi("", liikkuvuus, hyokkays2);
        
        //---
        
        Pelaaja pelaaja1 = new Pelaaja(0,"");
        Pelaaja pelaaja2 = new Pelaaja(1,"");
        
        Joukko joukko1 = new Joukko();
        Joukko joukko2 = new Joukko();
        
        this.sotilas1 = new Sotilas(yksikkotyyppi1, new Koordinaatti(0,0), pelaaja1, joukko1, 0);
        this.sotilas2 = new Sotilas(yksikkotyyppi2, new Koordinaatti(3,3), pelaaja2, joukko2, 1);
        
        joukko1.lisaaYksikko(sotilas1);
        joukko2.lisaaYksikko(sotilas2);
        
        ruudut[0][0].getJoukot().add(joukko1);
        ruudut[3][3].getJoukot().add(joukko2);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void yksikkoJokaEiYletaHyokkaamaanEiLoydaHyokattavia(){
        assertEquals(0, kantamanLaskija.laskeHyokattavatRuudut(sotilas1).size());
    }
    
    @Test
    public void yksikkoJokaYlettyyHyokkaamaanLoytaaHyokattavan(){
        assertEquals(1, kantamanLaskija.laskeHyokattavatRuudut(sotilas2).size());
    }
}
