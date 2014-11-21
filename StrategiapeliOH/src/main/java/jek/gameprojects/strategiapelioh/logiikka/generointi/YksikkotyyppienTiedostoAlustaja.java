package jek.gameprojects.strategiapelioh.logiikka.generointi;

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

public class YksikkotyyppienTiedostoAlustaja extends TiedostoAlustaja implements YksikkotyyppienAlustaja {

    public YksikkotyyppienTiedostoAlustaja(String tiedostonNimi)throws Exception{
        
        super(tiedostonNimi);
        
    }
    
    @Override
    public Map<String, Yksikkotyyppi> alustaYksikkotyypit() throws Exception{
        Map<String, Yksikkotyyppi> yksikkotyypit = new HashMap<>();
        
        while(true){
            
            if(nykyinen().equals("-")){
                break;
            }
            
            tarkistaLukukohta();
            
            Yksikkotyyppi yksikkotyyppi = alustaYksikkotyyppi();
            
            yksikkotyypit.put(yksikkotyyppi.getNimi(), yksikkotyyppi);
            
        }
        
        return yksikkotyypit;
    }
    
    private Yksikkotyyppi alustaYksikkotyyppi() throws Exception{
        
        String nimi = annaString();
        
        Liikkuvuus liikkuvuus = alustaLiikkuvuus();
        Hyokkays hyokkays = alustaHyokkays();
        
        return new Yksikkotyyppi(nimi, liikkuvuus, hyokkays);
        
    }
    
    private Liikkuvuus alustaLiikkuvuus() throws Exception{
        int liikuntamaara = super.tulkitseKokonaisluku();
        
        Map<Aluetyyppi, Boolean> mihinVoiLiikkua = alustaMihinYksikkotyyppiVoiLiikkua();
        Map<Maastotyyppi, Double> paljonkoLiikkuminenMaksaa = alustaLiikkumisenMaksut();
        
        return new Liikkuvuus(mihinVoiLiikkua, paljonkoLiikkuminenMaksaa, liikuntamaara);
    }
    
    private Map<Aluetyyppi, Boolean> alustaMihinYksikkotyyppiVoiLiikkua() throws Exception{
        
        Map<Aluetyyppi, Boolean> missaVoiLiikkua = new HashMap<>();
        
        for(int i=0; i<2;i++){
            Aluetyyppi aluetyyppi = Aluetyyppi.valueOf(nykyinen());
            
            kasvata(1);
            
            boolean voikoLiikkua = super.tulkitseTotuusarvo();
            
            missaVoiLiikkua.put(aluetyyppi, voikoLiikkua);
        }
        
        return missaVoiLiikkua;
    }
    
    private Map<Maastotyyppi, Double> alustaLiikkumisenMaksut()throws Exception{
        
        Map<Maastotyyppi, Double> liikkumisenMaksut = new HashMap<>();
        
        for(int i=0;i<2;i++){
            Maastotyyppi maastotyyppi = Maastotyyppi.valueOf(nykyinen());
            kasvata(1);
            
            double kuluvaMatka = super.tulkitseLiukuluku();
            
            liikkumisenMaksut.put(maastotyyppi, kuluvaMatka);
        }
        
        return liikkumisenMaksut;
    }
    
    private Hyokkays alustaHyokkays() throws Exception{
        if(nykyinen().equals("-")){
            return new Hyokkays();
        }
        
        int kantama = super.tulkitseKokonaisluku();
        boolean onkoKaukotaistelu = super.tulkitseTotuusarvo();
        int elamat = super.tulkitseKokonaisluku();
        
        List<Ase> aseet = alustaAseet();
        List<Panssari> panssarit = alustaPanssarit();
        
        return new Hyokkays(elamat, kantama, onkoKaukotaistelu, aseet, panssarit);
        
    }
    
    private List<Ase> alustaAseet() throws Exception{
        List<Ase> aseet = new ArrayList<>();
        
        while(true){
            if(nykyinen().equals("-")){
                break;
            }
            
            tarkistaLukukohta();
            
            int aseenIsku = super.tulkitseKokonaisluku();
            double tarkkuus = super.tulkitseLiukuluku();
            
            Asetyyppi asetyyppi = Asetyyppi.valueOf(nykyinen());
            kasvata(1);
            
            Ase ase = new Ase(aseenIsku, asetyyppi, tarkkuus);
            aseet.add(ase);
             
        }
        
        return aseet;
        
    }
    
    private List<Panssari> alustaPanssarit()throws Exception{
        List<Panssari> panssarit = new ArrayList<>();
        
        while(true){
            if(nykyinen().equals("-")){
                break;
            }
            
            tarkistaLukukohta();
            
            double panssarinKestavyys = super.tulkitseLiukuluku();
            
            Panssarityyppi panssarityyppi = Panssarityyppi.valueOf(nykyinen());
            kasvata(1);
            
            Panssari panssari = new Panssari(panssarinKestavyys, panssarityyppi);
            panssarit.add(panssari);
             
        }
        
        return panssarit;
    }
    
}
