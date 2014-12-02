package jek.gameprojects.strategiapelioh.logiikka.generointi.yksikkotyypit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.kartta.maasto.Maastotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Ase;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkays;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssari;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;

public class YksikkotyyppienVakioAlustaja implements YksikkotyyppienAlustaja{

    Ase lahitykki = new Ase(15, Asetyyppi.RAJAHDE, 0.2, 1, false);
    Ase kaukotykki = new Ase(8, Asetyyppi.RAJAHDE, 0, 4, true);
    Ase machineGun = new Ase(8, Asetyyppi.LUOTI, 0.3, 2, true);
    Ase tarkkuuskivaari = new Ase(5, Asetyyppi.LASER, 0.2, 6, true);
    Ase kivaari = new Ase(5, Asetyyppi.LUOTI, 0.1, 2, true);

    Panssari kevytPanssari = new Panssari(0.9, Panssarityyppi.TERAS);
    Panssari raskasPanssari = new Panssari(0.5, Panssarityyppi.TERAS);
    
    Map<Maastotyyppi, Double> normaali;
    Map<Maastotyyppi, Double> nopea;
    
    Map<Aluetyyppi, Boolean> voikoLiikkua;
    
    private Map<String, Yksikkotyyppi> yksikkotyypit;
    
    public YksikkotyyppienVakioAlustaja(){
        normaali = alustaLiikemaaranKulumiset(0,1);
        nopea = alustaLiikemaaranKulumiset(0,0);
        voikoLiikkua = alustaMahdollisetLiikkuvuudet(true, true);
        
        yksikkotyypit = new HashMap<>();
    }
    
    @Override
    public Map<String, Yksikkotyyppi> alustaYksikkotyypit() throws Exception {
        List<Ase> aseet1 = new ArrayList<>();
        List<Panssari> panssarit1 = new ArrayList<>();
        
        aseet1.add(lahitykki);
        panssarit1.add(raskasPanssari);
        
        Hyokkays hyokkays1 = new Hyokkays(30, aseet1, panssarit1);
        Liikkuvuus liikkuvuus1 = new Liikkuvuus(voikoLiikkua, normaali, 3);
        luoYksikkotyyppi("Tuhoaja", liikkuvuus1, hyokkays1);
        
        List<Ase> aseet2 = new ArrayList<>();
        List<Panssari> panssarit2 = new ArrayList<>();
        
        aseet2.add(kaukotykki);
        
        Hyokkays hyokkays2 = new Hyokkays(20, aseet2, panssarit2);
        Liikkuvuus liikkuvuus2 = new Liikkuvuus(voikoLiikkua, normaali, 2);
        luoYksikkotyyppi("Tykki", liikkuvuus2, hyokkays2);
        
        List<Ase> aseet3 = new ArrayList<>();
        List<Panssari> panssarit3 = new ArrayList<>();
        
        aseet3.add(machineGun);
        panssarit3.add(raskasPanssari);
        
        Hyokkays hyokkays3 = new Hyokkays(50, aseet3, panssarit3);
        Liikkuvuus liikkuvuus3 = new Liikkuvuus(voikoLiikkua, normaali, 1);
        luoYksikkotyyppi("Puolustuslinnoitus", liikkuvuus3, hyokkays3);
        
        List<Ase> aseet4 = new ArrayList<>();
        List<Panssari> panssarit4 = new ArrayList<>();
        
        aseet4.add(tarkkuuskivaari);
        
        Hyokkays hyokkays4 = new Hyokkays(10, aseet4,panssarit4);
        Liikkuvuus liikkuvuus4 = new Liikkuvuus(voikoLiikkua, nopea, 2);
        luoYksikkotyyppi("Tarkka-ampuja", liikkuvuus4, hyokkays4);
        
        List<Ase> aseet5 = new ArrayList<>();
        List<Panssari> panssarit5 = new ArrayList<>();
        
        aseet5.add(kivaari);
        panssarit5.add(kevytPanssari);
        
        Hyokkays hyokkays5 = new Hyokkays(20, aseet5, panssarit5);
        Liikkuvuus liikkuvuus5 = new Liikkuvuus(voikoLiikkua, nopea, 4);
        luoYksikkotyyppi("Tiedustelija", liikkuvuus5, hyokkays5);
        
        return yksikkotyypit;
    }
    
    public Map<Aluetyyppi, Boolean> alustaMahdollisetLiikkuvuudet(boolean... arvot){
        Map<Aluetyyppi,Boolean> mahdollisetLiikkeet = new HashMap<>();
        
        mahdollisetLiikkeet.put(Aluetyyppi.MAA, arvot[0]);
        mahdollisetLiikkeet.put(Aluetyyppi.VESI, arvot[1]);
        
        return mahdollisetLiikkeet;
    }
    
    public Map<Maastotyyppi, Double> alustaLiikemaaranKulumiset(double... arvot){
        Map<Maastotyyppi, Double> liikemaaranKuluminen = new HashMap<>();
        
        liikemaaranKuluminen.put(Maastotyyppi.AVOMAA, arvot[0]);
        liikemaaranKuluminen.put(Maastotyyppi.METSA, arvot[1]);
        
        return liikemaaranKuluminen;
    }
    
    public void luoYksikkotyyppi(String nimi, Liikkuvuus liikkuvuus, Hyokkays hyokkays){
        Yksikkotyyppi yksikkotyyppi = new Yksikkotyyppi(nimi, liikkuvuus, hyokkays);
        yksikkotyypit.put(nimi, yksikkotyyppi);
    }
    
}
