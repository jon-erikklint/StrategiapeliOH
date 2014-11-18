package jek.gameprojects.strategiapelioh.domain.kartta;

import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maastotyyppi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KarttaTest {
    
    public Kartta kartta;
    
    public KarttaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        Ruutu[][] ruudut =new Ruutu[3][3];
        
        Maasto maasto=new Maasto(Aluetyyppi.MAA,Maastotyyppi.AVOMAA,0);
        
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                Ruutu ruutu=new Ruutu(new Koordinaatti(i,j), maasto);
                ruudut[i][j]=ruutu;
            }
        }
        
        kartta=new Kartta(ruudut, 3, 3);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void karttaLoytaaKartallaOlevanRuudun(){
        boolean onkoKartalla=kartta.onkoKartalla(new Koordinaatti(0,0));
        
        assertEquals(true, onkoKartalla);
    }
    
    @Test
    public void karttaEiLoydaNegatiivisiaRuutuja(){
        boolean onkoKartalla = kartta.onkoKartalla(new Koordinaatti(-1, 0));
        boolean onkoKartalla2 = kartta.onkoKartalla(new Koordinaatti(0, -1));
        
        assertEquals(false, onkoKartalla);
        assertEquals(false, onkoKartalla2);
        
    }
    
    @Test
    public void karttaEiLoydaLiianSuuriaRuutuja(){
        boolean onkoKartalla = kartta.onkoKartalla(new Koordinaatti(5,0));
        boolean onkoKartalla2 = kartta.onkoKartalla(new Koordinaatti(0,5));
        
        assertEquals(false, onkoKartalla);
        assertEquals(false, onkoKartalla2);
    }
    
    @Test
    public void karttaAntaaRuudun(){
        Ruutu ruutu=kartta.getRuutu(new Koordinaatti(0,0));
        
        assertEquals("[0,0]",ruutu.getSijainti().toString());
    }
    
    @Test
    public void karttaAntaaViereisetRuudutOikeinJosKaikissaSuunnissaOnRuutu(){
        List<Ruutu> ruudut = kartta.getViereisetRuudut(new Koordinaatti(1,1));
        
        assertEquals(4, ruudut.size());
    }
    
    @Test
    public void karttaAntaaViereisetRuudutOikeinJosKaikissaSuunnissaEiOleRuutua(){
        List<Ruutu> ruudut = kartta.getViereisetRuudut(new Koordinaatti(0,0));
        
        assertEquals(2, ruudut.size());
        
        ruudut = kartta.getViereisetRuudut(new Koordinaatti(2,1));
        
        assertEquals(3, ruudut.size());
    }
    
    @Test
    public void karttaAntaaOikeatRuudut1(){
        List<Ruutu> ruudut = kartta.getViereisetRuudut(new Koordinaatti(0,0));
        
        boolean onko10 = ruudut.contains(kartta.getRuutu(new Koordinaatti(1,0)));
        boolean onko01 = ruudut.contains(kartta.getRuutu(new Koordinaatti(0,1)));
        
        assertEquals(true, onko10);
        assertEquals(true, onko01);
    }
    
    @Test
    public void karttaAntaaOikeatRuudut2(){
        List<Ruutu> ruudut = kartta.getViereisetRuudut(new Koordinaatti (0,2));
        
        boolean onko13 = ruudut.contains(kartta.getRuutu(new Koordinaatti(1,2)));
        boolean onko02 = ruudut.contains(kartta.getRuutu(new Koordinaatti(0,1)));
        
        assertEquals(true, onko13);
        assertEquals(true, onko02);
    }

    
}
