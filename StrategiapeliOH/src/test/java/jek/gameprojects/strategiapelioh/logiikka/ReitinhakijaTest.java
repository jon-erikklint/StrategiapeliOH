package jek.gameprojects.strategiapelioh.logiikka;

import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Vektori;
import jek.gameprojects.strategiapelioh.domain.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.maasto.Maastotyyppi;
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
                Ruutu ruutu=new Ruutu(new Vektori(i,j), perusmaasto);
                ruudut[i][j]=ruutu;
            }
        }
        
        Kartta kartta = new Kartta(ruudut,4,4);
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
        
        
        Liikkuvuus liikkuvuus1 = new Liikkuvuus(aluetyyppikartta1, maastotyyppikartta1);
        Liikkuvuus liikkuvuus2 = new Liikkuvuus(aluetyyppikartta2, maastotyyppikartta2);
        
        Yksikkotyyppi yksikkotyyppi1 = new Yksikkotyyppi(2, liikkuvuus1);
        Yksikkotyyppi yksikkotyyppi2 = new Yksikkotyyppi(7, liikkuvuus2);
        
        
        Pelaaja pelaaja=new Pelaaja(0,"");
        
        this.yksikko1 = new Yksikko(yksikkotyyppi1, new Vektori(0,0), pelaaja, 0);
        this.yksikko2 = new Yksikko(yksikkotyyppi2, new Vektori(3,3), pelaaja, 1);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void reitinhakijaLoytaaAloitusruudunLiikuttavista(){
        yksikko1.liiku(2, yksikko1.getSijainti());
        
        Map<Vektori, Integer> liikuttavatRuudut = reitinhakija.ruudutJoihinVoiLiikkua(yksikko1);
        
        assertEquals(1, liikuttavatRuudut.keySet().size());
    }
    
    @Test
    public void reitinhakijaLoytaaKaikkiMentavatRuudutVakiomaastossa(){
        Map<Vektori, Integer> liikuttavatRuudut = reitinhakija.ruudutJoihinVoiLiikkua(yksikko1);
        
        assertEquals(6, liikuttavatRuudut.keySet().size());
    }

    
}
