package jek.gameprojects.strategiapelioh.logiikka.liikkuminen;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LiikuttajaTest {
    
    private Liikuttaja liikuttaja;
    private Reitinhakija testiReitinhakija;
    
    private Yksikko yksikko1;
    private Yksikko yksikko2;
    private Yksikko yksikko3;
    private Yksikko yksikko4;
    
    private Joukko joukko1;
    private Joukko joukko2;
    
    public LiikuttajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Ruutu[][] ruudut = new Ruutu[4][4];
        
        Maasto perusmaasto = new Maasto(Aluetyyppi.MAA, Maastotyyppi.AVOMAA, 0);
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                ruudut[i][j] = new Ruutu(new Koordinaatti(i,j), perusmaasto);
            }
        }
        
        Kartta kartta = new Kartta(ruudut, 4, 4);
        
        liikuttaja = new Liikuttaja(kartta);
        testiReitinhakija = new Reitinhakija(kartta);
        
        // ------------------------------------------------
        
        Pelaaja pelaaja = new Pelaaja(0, "S");
        
        Map<Aluetyyppi, Boolean> aluetyypit1 = new HashMap<>();
        Map<Aluetyyppi, Boolean> aluetyypit2 = new HashMap<>();
        
        aluetyypit1.put(Aluetyyppi.MAA, Boolean.TRUE);
        aluetyypit1.put(Aluetyyppi.VESI, Boolean.TRUE);
        
        aluetyypit2.put(Aluetyyppi.MAA, Boolean.TRUE);
        aluetyypit2.put(Aluetyyppi.VESI, Boolean.FALSE);
        
        Map<Maastotyyppi, Double> maastotyypit1 = new HashMap<>();
        Map<Maastotyyppi, Double> maastotyypit2 = new HashMap<>();
        
        maastotyypit1.put(Maastotyyppi.METSA, 1.0);
        maastotyypit1.put(Maastotyyppi.AVOMAA, 0.0);
        
        maastotyypit2.put(Maastotyyppi.METSA, 0.0);
        maastotyypit2.put(Maastotyyppi.AVOMAA, 0.0);
        
        Liikkuvuus liikkuvuus1 = new Liikkuvuus(aluetyypit1, maastotyypit1, 2);
        Liikkuvuus liikkuvuus2 = new Liikkuvuus(aluetyypit2, maastotyypit2, 3);
        
        Yksikkotyyppi yksikkotyyppi1 = new Yksikkotyyppi("", liikkuvuus1);
        Yksikkotyyppi yksikkotyyppi2 = new Yksikkotyyppi("", liikkuvuus2);
        
        joukko1 = new Joukko();
        joukko2 = new Joukko();
        
        yksikko1 = new Yksikko(yksikkotyyppi1, new Koordinaatti(), pelaaja, joukko1, 0);
        yksikko2 = new Yksikko(yksikkotyyppi1, new Koordinaatti(), pelaaja, joukko1, 1);
        yksikko3 = new Yksikko(yksikkotyyppi2, new Koordinaatti(), pelaaja, joukko1, 2);
        yksikko4 = new Yksikko(yksikkotyyppi1, new Koordinaatti(), pelaaja, joukko2, 3);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void liikuttajanMahdollisetLiikkeetVastaavatReitinhakijanMahdollisia(){
        Map<Koordinaatti, Integer> liikuttavatLiikuttaja = liikuttaja.alustaLiikkuvanMahdollisetLiikkeet(yksikko1);
        Map<Koordinaatti, Integer> liikuttavatReitinhakija = testiReitinhakija.ruudutJoihinVoiLiikkua(yksikko1);
        
        assertEquals(liikuttavatLiikuttaja.size(), liikuttavatReitinhakija.size());
    }

    @Test
    public void joukonLiikkeidenAlustaminenAlustaaSenSisaltamineYksikoidenLiikkeet(){
        liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko1);
        
        assertEquals(true, (liikuttaja.annaYksikonMahdollisetLiikkeet(yksikko1).size()>0));
        assertEquals(true, (liikuttaja.annaYksikonMahdollisetLiikkeet(yksikko2).size()>0));
        assertEquals(true, (liikuttaja.annaYksikonMahdollisetLiikkeet(yksikko3).size()>0));
    }
    
    @Test
    public void joukonLiikkeidenAlustaaJoukonOmatLiikkeet(){
        liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko1);
        
        assertEquals(true, (liikuttaja.annaJoukonMahdollisetLiikkeet(joukko1).size()>0));
    }
    
    @Test
    public void joukonMahdollisetLiikkeetOvatOikein(){
        liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko1);
        
        assertEquals(6, liikuttaja.annaJoukonMahdollisetLiikkeet(joukko1).size());
    }
    
    @Test
    public void joukonMahdollisetLiikkeetToimivatOikeinMonellaJoukolla(){
        liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko1);
        
        assertEquals(6, liikuttaja.annaJoukonMahdollisetLiikkeet(joukko1).size());
        
        liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko2);
        
        assertEquals(6, liikuttaja.annaJoukonMahdollisetLiikkeet(joukko2).size());
    }
    
    @Test
    public void yksittaisenLiikkuvanLiikuttaminenToimii(){
        Map<Koordinaatti, Integer> liikuttavat = liikuttaja.alustaLiikkuvanMahdollisetLiikkeet(yksikko4);
        
        for(Koordinaatti koordinaatti:liikuttavat.keySet()){
            int odotettuLiikkuvuus = yksikko4.liikkuvuus();
            odotettuLiikkuvuus-=liikuttavat.get(koordinaatti);
            
            liikuttaja.liikutaLiikkuva(yksikko4, koordinaatti);
            
            assertEquals(odotettuLiikkuvuus, yksikko4.liikkuvuus());
            
            break; 
        }   
    }
    
    @Test
    public void joukonLiikuttaminenToimii(){
        Set<Koordinaatti> liikuttavat = liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko1);
        
        for(Koordinaatti koordinaatti : liikuttavat){
            liikuttaja.liikutaJoukko(joukko1, koordinaatti);
            
            for(Yksikko yksikko : joukko1.getYksikot()){
                assertEquals(koordinaatti, yksikko.getSijainti());
            }
            
            break;
        }
        
    }
    
    @Test
    public void joukkoSiirtyyYksikoidenMukana(){
        Set<Koordinaatti> liikuttavat = liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko1);
        
        for(Koordinaatti koordinaatti : liikuttavat){
            liikuttaja.liikutaJoukko(joukko1, koordinaatti);
            
            assertEquals(koordinaatti, joukko1.getSijainti());
            break;
        }
    }
    
    @Test
    public void nollausTyhjentaaTiedot(){
        liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko1);
        liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko2);
        
        liikuttaja.nollaa();
        
        assertEquals(0, liikuttaja.getJoukkojenMahdollisetLiikkeet().keySet().size());
        assertEquals(0, liikuttaja.getYksikoidenMahdollisetLiikkeet().keySet().size());
    }
        
}
