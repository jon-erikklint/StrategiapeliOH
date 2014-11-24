package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedostonPurkajaTest {
    
    TiedostonPurkaja purkaja = new TiedostonPurkaja();
    String path = "/TestFiles/test.txt";
    
    public TiedostonPurkajaTest() {
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
    public void purkajaLoytaaTiedoston(){
        try{
            purkaja.lueTiedosto(path);
        }catch(Exception e){
            assertEquals("",e.getMessage());
        }
    }
    
    @Test
    public void purkajaLukeeRivinOikein(){
        try{
            List<String> sisalto = purkaja.lueTiedosto(path);
            assertEquals("sd", sisalto.get(0));
        }catch(Exception e){assertEquals("",e.getMessage());}
    }
    
    @Test
    public void purkajaLukeeRivitOikein(){
        List<String> sisalto=null;
        
        try{
            sisalto = purkaja.lueTiedosto(path);
            
        }catch(Exception e){assertEquals("",e.getMessage());}
        
        assertEquals("sd", sisalto.get(0));
        assertEquals("asd", sisalto.get(1));
    }
}
