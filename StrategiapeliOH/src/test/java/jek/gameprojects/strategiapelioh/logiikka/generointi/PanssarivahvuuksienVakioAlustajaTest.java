package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PanssarivahvuuksienVakioAlustajaTest {
    
    private PanssarivahvuuksienVakioAlustaja alustaja;
    
    public PanssarivahvuuksienVakioAlustajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        alustaja = new PanssarivahvuuksienVakioAlustaja();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void antaakoKaikilleAseilleVahvuudet(){
        assertEquals(Asetyyppi.values().length, alustaja.panssarityyppienVahvuudet().size());
    }
    
    @Test
    public void antaakoAseelleKaikkiPanssarit(){
        Map<Asetyyppi, Map<Panssarityyppi,Double>> p = alustaja.panssarityyppienVahvuudet();
        
        for(Asetyyppi asetyyppi:p.keySet()){
            assertEquals(Panssarityyppi.values().length, p.get(asetyyppi).size());
        }
    }
}
