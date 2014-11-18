package jek.gameprojects.strategiapelioh.logiikka.liikkuminen;

import jek.gameprojects.strategiapelioh.logiikka.liikkuminen.Reitinhakija;
import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maastotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuva;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReitinhakijaTest {
    
    public Reitinhakija reitinhakija;
    public Kartta kartta;
    
    public Liikkuva yksikko1;
    public Liikkuva yksikko2;
    
    public ReitinhakijaTest() {
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
        
        this.kartta = new Kartta(ruudut,4,4);
        reitinhakija = new Reitinhakija(kartta);
        
        Map<Aluetyyppi,Boolean> aluetyyppikartta1 = new HashMap<>();
        Map<Aluetyyppi,Boolean> aluetyyppikartta2 = new HashMap<>();
        
        aluetyyppikartta1.put(Aluetyyppi.MAA, Boolean.TRUE);
        aluetyyppikartta1.put(Aluetyyppi.VESI, Boolean.TRUE);
        
        aluetyyppikartta2.put(Aluetyyppi.MAA, Boolean.TRUE);
        aluetyyppikartta2.put(Aluetyyppi.VESI, Boolean.FALSE);
        
        Map<Maastotyyppi,Double> maastotyyppikartta1 = new HashMap<>();
        Map<Maastotyyppi,Double> maastotyyppikartta2 = new HashMap<>();
        
        maastotyyppikartta1.put(Maastotyyppi.METSA, 1.0);
        maastotyyppikartta1.put(Maastotyyppi.AVOMAA, 0.0);
        
        maastotyyppikartta2.put(Maastotyyppi.METSA, 0.0);
        maastotyyppikartta2.put(Maastotyyppi.AVOMAA, 0.0);
        
        
        Liikkuvuus liikkuvuus1 = new Liikkuvuus(aluetyyppikartta1, maastotyyppikartta1, 2);
        Liikkuvuus liikkuvuus2 = new Liikkuvuus(aluetyyppikartta2, maastotyyppikartta2, 7);
        
        Yksikkotyyppi yksikkotyyppi1 = new Yksikkotyyppi("", liikkuvuus1);
        Yksikkotyyppi yksikkotyyppi2 = new Yksikkotyyppi("", liikkuvuus2);
        
        
        Pelaaja pelaaja=new Pelaaja(0,"");
        
        Joukko joukko1 = new Joukko();
        Joukko joukko2 = new Joukko();
        
        this.yksikko1 = new Yksikko(yksikkotyyppi1, new Koordinaatti(0,0), pelaaja, joukko1, 0);
        this.yksikko2 = new Yksikko(yksikkotyyppi2, new Koordinaatti(3,3), pelaaja, joukko2, 1);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void reitinhakijaLoytaaAloitusruudunLiikuttavista(){
        yksikko1.liiku(2, yksikko1.getSijainti());
        
        Map<Koordinaatti, Integer> liikuttavatRuudut = reitinhakija.ruudutJoihinVoiLiikkua(yksikko1);
        
        assertEquals(1, liikuttavatRuudut.keySet().size());
    }
    
    @Test
    public void reitinhakijaLoytaaKaikkiMentavatRuudutVakiomaastossa1(){
        Map<Koordinaatti, Integer> liikuttavatRuudut = reitinhakija.ruudutJoihinVoiLiikkua(yksikko2);
        
        assertEquals(16, liikuttavatRuudut.keySet().size());
    }
    
    @Test
    public void reitinhakijaLoytaaKaikkiMentavatRuudutVakiomaastossa2(){
        Map<Koordinaatti, Integer> liikuttavatRuudut = reitinhakija.ruudutJoihinVoiLiikkua(yksikko1);
        
        assertEquals(6, liikuttavatRuudut.keySet().size());
    }
    
    @Test
    public void reitinhakijaLoytaaLyhyimmanReitinVakiomaastossa(){
        Map<Koordinaatti, Integer> liikuttavatRuudut = reitinhakija.ruudutJoihinVoiLiikkua(yksikko1);
        
        int luku=liikuttavatRuudut.get(new Koordinaatti(1,1));
        int luku2=liikuttavatRuudut.get(new Koordinaatti(0,0));
        
        assertEquals(2,luku);
        assertEquals(0,luku2);
    }
    
    @Test
    public void reitinhakijaOttaaHuomioonKorkeuserotTarkastaessaanVoikoJohonkinLiikkua(){
        Ruutu[][] ruudut=kartta.getRuudut();
        ruudut[1][1] = new Ruutu(new Koordinaatti(1,1), new Maasto(Aluetyyppi.MAA, Maastotyyppi.AVOMAA, 10));
        
        kartta.setRuudut(ruudut);
        
        Map<Koordinaatti, Integer> liikuttavatRuudut = reitinhakija.ruudutJoihinVoiLiikkua(yksikko2);
        
        assertEquals(15, liikuttavatRuudut.keySet().size());
    }
    
    @Test
    public void reitinhakijaLoytaaTienVuorelleJohonEiPaaseSuoraan(){
        Ruutu[][] ruudut = kartta.getRuudut();
        ruudut[2][2] = new Ruutu(new Koordinaatti(2,2), new Maasto(Aluetyyppi.MAA, Maastotyyppi.AVOMAA, 5));
        ruudut[3][2] = new Ruutu(new Koordinaatti(3,2), new Maasto(Aluetyyppi.MAA, Maastotyyppi.AVOMAA, 1));
        
        kartta.setRuudut(ruudut);
        
        Map<Koordinaatti, Integer> liikuttavatRuudut = reitinhakija.ruudutJoihinVoiLiikkua(yksikko2);
        
        assertEquals(16, liikuttavatRuudut.keySet().size());
    }

    
}
