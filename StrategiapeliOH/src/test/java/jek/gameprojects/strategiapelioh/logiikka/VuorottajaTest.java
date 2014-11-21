/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jek.gameprojects.strategiapelioh.logiikka;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VuorottajaTest {
    
    Vuorottaja vuorottaja;
    
    private List<Pelaaja> pelaajat;
    
    public VuorottajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaajat = new ArrayList<>();
        
        for(int i=0;i<3;i++){
            pelaajat.add(new Pelaaja(i, ""));
        }
        
        vuorottaja = new Vuorottaja(pelaajat);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void onkoEnsimmainenVuoroOikein(){
        assertEquals(pelaajat.get(0).getId(), vuorottaja.annaSeuraavaVuoro().getPelaaja().getId());
    }
    
    @Test
    public void onkoKaikkiOikein(){
        for(int i=0;i<3;i++){
            assertEquals(pelaajat.get(i).getId(), vuorottaja.annaSeuraavaVuoro().getPelaaja().getId());
        }
    }
    
    @Test
    public void alkaakoVuorotAlusta(){
        for(int i=0;i<3;i++){
            vuorottaja.annaSeuraavaVuoro();
        }
        
        assertEquals(pelaajat.get(0).getId(), vuorottaja.annaSeuraavaVuoro().getPelaaja().getId());
    }
    
    @Test
    public void antaakoKierroksenvaihdonOikeinAlussa(){
        assertEquals(true, vuorottaja.onkoSeuraavaKierros());
        
        vuorottaja.annaSeuraavaVuoro();
        
        assertEquals(false, vuorottaja.onkoSeuraavaKierros());
        
        vuorottaja.annaSeuraavaVuoro();
        vuorottaja.annaSeuraavaVuoro();
        
        assertEquals(true, vuorottaja.onkoSeuraavaKierros());
    }
    
}
