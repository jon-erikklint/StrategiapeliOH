package jek.gameprojects.strategiapelioh.logiikka.laskurit;

import jek.gameprojects.strategiapelioh.logiikka.laskurit.RajoitettuLaskuri;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RajoitettuLaskuriTest {
    
    public RajoitettuLaskuriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void asetetaankoAlarajajaYlarajaOikein(){
        RajoitettuLaskuri laskuri=new RajoitettuLaskuri(10,0,10);
        
        assertEquals(10,laskuri.getYlaraja());
        assertEquals(0,laskuri.getAlaraja());
    }
    
    @Test
    public void asetetaankoAlkuarvoOikeinOikeallaSyotteella(){
        RajoitettuLaskuri laskuri=new RajoitettuLaskuri(10,0,10);
        
        assertEquals(10, laskuri.getArvo());
    }
    
    @Test
    public void asetetaankoAlkuarvoOikeinVaarallaSyotteella(){
        RajoitettuLaskuri laskuri=new RajoitettuLaskuri(10,0,-2);
        
        assertEquals(10,laskuri.getArvo());
    }
    
    @Test
    public void mahdollisenUudenArvonLaittaminenOnnistuu(){
        RajoitettuLaskuri laskuri=new RajoitettuLaskuri(10,0,10);
        
        laskuri.setArvo(2);
        
        assertEquals(2,laskuri.getArvo());
    }
    
    @Test
    public void mahdottomanUudenArvonLaittaminenToimii(){
        RajoitettuLaskuri laskuri=new RajoitettuLaskuri(10,0);
        
        laskuri.setArvo(-2);
        
        assertEquals(10,laskuri.getArvo());
    }
    
    @Test
    public void toimiikoLisaysEiYlimenevallaSyotteella(){
        RajoitettuLaskuri laskuri=new RajoitettuLaskuri(10,0);
        
        laskuri.lisaaArvoa(-2);
        
        assertEquals(8, laskuri.getArvo());
        
        laskuri.lisaaArvoa(1);
        
        assertEquals(9, laskuri.getArvo());
    }
    
    @Test
    public void toimiikoLisaysYlimenevallaSyotteella(){
        RajoitettuLaskuri laskuri=new RajoitettuLaskuri(10,0);
        
        laskuri.lisaaArvoa(10000);
        
        assertEquals(10, laskuri.getArvo());
        
        laskuri.lisaaArvoa(-100000);
        
        assertEquals(0, laskuri.getArvo());
    }
}
