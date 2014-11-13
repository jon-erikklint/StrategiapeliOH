package jek.gameprojects.strategiapelioh.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IndeksoijaTest {
    
    public IndeksoijaTest() {
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
    public void indeksoijanAlkuarvoOnOikein(){
        Indeksoija indeksoija=new Indeksoija(0);
        
        assertEquals(0, indeksoija.nextIndex());
        
        indeksoija=new Indeksoija(352);
        
        assertEquals(352, indeksoija.nextIndex());
    }
    
    @Test
    public void indeksoijanKasvaminenToimii(){
        Indeksoija indeksoija=new Indeksoija(0);
        
        indeksoija.nextIndex();
        
        assertEquals(1,indeksoija.nextIndex());
        
        for(int i=0;i<21;i++){
        
            indeksoija.nextIndex();
            
        }
        
        assertEquals(23, indeksoija.nextIndex());
    }
}
