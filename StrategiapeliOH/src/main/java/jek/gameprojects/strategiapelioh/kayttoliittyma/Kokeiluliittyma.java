package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.maasto.Maasto;
import jek.gameprojects.strategiapelioh.domain.maasto.Maastotyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import jek.gameprojects.strategiapelioh.logiikka.JoukkojenHallinnoija;
import jek.gameprojects.strategiapelioh.logiikka.liikkuminen.Liikuttaja;
import jek.gameprojects.strategiapelioh.logiikka.liikkuminen.Reitinhakija;


public class Kokeiluliittyma { //debuggerointia yms. varten väliaikainen!
    
    public static void main(String[] args) {
        Ruutu[][] ruudut = new Ruutu[4][4];
        
        Maasto perusmaasto = new Maasto(Aluetyyppi.MAA, Maastotyyppi.AVOMAA, 0);
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                ruudut[i][j] = new Ruutu(new Koordinaatti(i,j), perusmaasto);
            }
        }
        
        Kartta kartta = new Kartta(ruudut, 4, 4);
        
        Liikuttaja liikuttaja = new Liikuttaja(kartta);
        Reitinhakija testiReitinhakija = new Reitinhakija(kartta);
        
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
        
        Yksikkotyyppi yksikkotyyppi1 = new Yksikkotyyppi(liikkuvuus1);
        Yksikkotyyppi yksikkotyyppi2 = new Yksikkotyyppi(liikkuvuus2);
        
        Joukko joukko1 = new Joukko();
        Joukko joukko2 = new Joukko();
        
        Yksikko yksikko1 = new Yksikko(yksikkotyyppi1, new Koordinaatti(), pelaaja, joukko1, 0);
        Yksikko yksikko2 = new Yksikko(yksikkotyyppi1, new Koordinaatti(), pelaaja, joukko1, 1);
        Yksikko yksikko3 = new Yksikko(yksikkotyyppi2, new Koordinaatti(), pelaaja, joukko1, 2);
        Yksikko yksikko4 = new Yksikko(yksikkotyyppi1, new Koordinaatti(), pelaaja, joukko2, 3);
        
        // ----------------------------------
        
        liikuttaja.alustaJoukonMahdollisetLiikkeet(joukko1);
        
    }
}
