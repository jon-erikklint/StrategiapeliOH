package jek.gameprojects.strategiapelioh.logiikka;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
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

public class JoukkojenHallinnoijaTest {
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    private Yksikko yksikko1;
    private Yksikko yksikko2;
    private Yksikko yksikko3;
    private Yksikko yksikko4;
    
    private Joukko joukko1;
    private Joukko joukko2;
    
    public JoukkojenHallinnoijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        joukkojenHallinnoija = new JoukkojenHallinnoija();
        
        Liikkuvuus liikkuvuus = new Liikkuvuus(new EnumMap<Aluetyyppi, Boolean>(Aluetyyppi.class), new EnumMap<Maastotyyppi, Double>(Maastotyyppi.class), 0);
        Yksikkotyyppi yksikkotyyppi = new Yksikkotyyppi("",liikkuvuus);
        
        Pelaaja pelaaja = new Pelaaja(0, "");
        joukko1 = new Joukko();
        joukko2 = new Joukko();
        
        yksikko1 = new Yksikko(yksikkotyyppi, new Koordinaatti(), pelaaja, joukko1, 0);
        yksikko2 = new Yksikko(yksikkotyyppi, new Koordinaatti(), pelaaja, joukko1, 1);
        yksikko3 = new Yksikko(yksikkotyyppi, new Koordinaatti(), pelaaja, joukko2, 2);
        yksikko4 = new Yksikko(yksikkotyyppi, new Koordinaatti(), pelaaja, joukko2, 3);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void yksikonSiirtaminenToiseenJoukkoonToimii(){
        joukkojenHallinnoija.siirraYksikkoJoukkoon(yksikko1, joukko2);
        
        assertEquals(true, yksikko1.getJoukko().equals(joukko2));
        assertEquals(true, joukko2.getYksikot().contains(yksikko1));
    }
    
    @Test
    public void yksikonSiirtoJoukkoonAntaaOikeanMaaranYksikoita(){
        joukkojenHallinnoija.siirraYksikkoJoukkoon(yksikko1, joukko2);
        
        assertEquals(3, joukko2.getYksikot().size());
    }
    
    @Test
    public void yksikonSiirtoSenOmaanJoukkoonToimii(){
        joukkojenHallinnoija.siirraYksikkoJoukkoon(yksikko1, joukko1);
        
        assertEquals(2, joukko1.getYksikot().size());
    }
    
    @Test
    public void joukonSiirtoJoukkoonSiirtaaKaikkiJoukonYksikotKohdejoukkoon(){
        joukkojenHallinnoija.siirraJoukkoJoukkoon(joukko1, joukko2);
        
        assertEquals(4, joukko1.getYksikot().size());
    }
    
    @Test
    public void joukonSiirtoJoukkoonSiirtaJokaisenAlkujoukonYksikonToiseenJoukkoon(){
        joukkojenHallinnoija.siirraJoukkoJoukkoon(joukko1, joukko2);
        
        assertEquals(true, joukko1.getYksikot().contains(yksikko3));
        assertEquals(true, joukko1.getYksikot().contains(yksikko4));
    }
    
    @Test
    public void yksikolleOmanJoukonLuontiLuoUudenJoukon(){
        joukkojenHallinnoija.luoYksikolleOmaJoukko(yksikko1);
        
        assertEquals(false, yksikko1.getJoukko().equals(joukko1));
    }
    
    @Test
    public void yksikolleUudenJoukonLuontiPoistaaYksikonVanhastaJoukosta(){
        joukkojenHallinnoija.luoYksikolleOmaJoukko(yksikko1);
        
        assertEquals(false, joukko1.getYksikot().contains(yksikko1));
    }
    
    @Test
    public void yksikonPoistoJoukostaanToimii(){
        joukkojenHallinnoija.poistayksikkoJoukostaan(yksikko1);
        
        assertEquals(false, joukko1.getYksikot().contains(yksikko1));
    }
    
    @Test
    public void joukkojenYhdistaminenYhdeksiJoukoksiYhdistaaKaikkiJoukot(){
        List<Joukko> joukot = new ArrayList<>();
        joukot.add(joukko1);
        joukot.add(joukko2);
        
        Joukko joukko=joukkojenHallinnoija.yhdistaJuokotYhdeksiJoukoksi(joukot);
        
        assertEquals(4, joukko.getYksikot().size());
        assertEquals(true, joukko.getYksikot().contains(yksikko1));
        assertEquals(true, joukko.getYksikot().contains(yksikko2));
        assertEquals(true, joukko.getYksikot().contains(yksikko3));
        assertEquals(true, joukko.getYksikot().contains(yksikko4));
    }
    
    @Test
    public void joukkonHajoittaminenYhdenYksikonJoukoiksiToimii(){
        joukkojenHallinnoija.hajoitaJoukkoYksittaisenYksikonJoukoiksi(joukko1);
        
        assertEquals(1,yksikko1.getJoukko().getYksikot().size());
        assertEquals(1,yksikko1.getJoukko().getYksikot().size());
    }
}
