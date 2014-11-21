package jek.gameprojects.strategiapelioh.logiikka.laskurit;

import jek.gameprojects.strategiapelioh.logiikka.laskurit.KiertavaLaskuri;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KiertavaLaskuriTest {
    
    private KiertavaLaskuri laskuri;
    
    public KiertavaLaskuriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        laskuri = new KiertavaLaskuri(10, 0, 0);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alustusToimiiOikeinOikeillaArvoilla(){
        assertEquals(0, laskuri.getArvo());
        
        laskuri = new KiertavaLaskuri(10,0,5);
        
        assertEquals(5, laskuri.getArvo());
    }
    
    @Test
    public void alustusToimiiOikeinVaarilalArvoilla(){
        laskuri = new KiertavaLaskuri(10,0,-3);
        
        assertEquals(0,laskuri.getArvo());
        
        laskuri = new KiertavaLaskuri(10,0,15);
        
        assertEquals(0, laskuri.getArvo());
    }
    
    @Test
    public void arvoAsetetaanJosSeOnOikein(){
        laskuri.setArvo(5);
        
        assertEquals(5, laskuri.getArvo());
        
        laskuri.setArvo(9);
        
        assertEquals(9, laskuri.getArvo());
    }
    
    @Test
    public void arvoaEiAsetetaJosAsetettavaArvoEpakelpo(){
        laskuri.setArvo(124125135);
        
        assertEquals(0, laskuri.getArvo());
        
        laskuri.setArvo(-6);
        
        assertEquals(0, laskuri.getArvo());
    }
    
    @Test
    public void arvonLisaysToimiiKunEiYlitetaYlarajaa(){
        laskuri.lisaaArvoa(2);
        
        assertEquals(2, laskuri.getArvo());
        
        laskuri.lisaaArvoa(3);
        
        assertEquals(5, laskuri.getArvo());
    }
    
    @Test
    public void arvonLisaysToimiiKunYlitetaanYlaraja(){
        laskuri.lisaaArvoa(12);
        
        assertEquals(2, laskuri.getArvo());
        
        laskuri.lisaaArvoa(8);
        
        assertEquals(0, laskuri.getArvo());
    }
    
    @Test
    public void negatiivisenArvonLisaysToimii(){
        laskuri.lisaaArvoa(-1);
        
        assertEquals(9,laskuri.getArvo());
        
        laskuri.lisaaArvoa(-10);
        
        assertEquals(9, laskuri.getArvo());
    }
    
}
