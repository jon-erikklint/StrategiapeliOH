package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.maasto.Aluetyyppi;
import jek.gameprojects.strategiapelioh.domain.maasto.Maastotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkays;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;
import jek.gameprojects.strategiapelioh.logiikka.Indeksoija;

public class TiedostoAlustaja extends PelinAlustaja{
    
    private List<String> tiedostonTiedot;
    int lukukohta;
    
    public TiedostoAlustaja(String tiedostonNimi) throws Exception{
        
        TiedostonPurkaja purkaja = new TiedostonPurkaja();
        tiedostonTiedot = purkaja.lueTiedosto(tiedostonNimi);
        
        lukukohta=0;
            
    }

    @Override
    public List<Pelaaja> alustaPelaajat(List<String> pelaajienNimet) {
        List<Pelaaja> pelaajat = new ArrayList<>();
        
        int id=0;
        
        for(String nimi : pelaajienNimet){
            Pelaaja pelaaja = new Pelaaja(id, nimi);
            pelaajat.add(pelaaja);
            
            id++;
        }
        
        return pelaajat;
    }

    
    //
    ///Yksikkotyyppien alustus
    @Override
    public List<Yksikkotyyppi> alustaYksikkotyypit() throws Exception{
        List<Yksikkotyyppi> yksikkotyypit = new ArrayList<>();
        
        while(true){
            
            if(tiedostonTiedot.get(lukukohta).equals("-")){
                break;
            }
            
            yksikkotyypit.add(alustaYksikkotyyppi());
            
        }
        
        return yksikkotyypit;
    }
    
    private Yksikkotyyppi alustaYksikkotyyppi() throws Exception{
        
        Liikkuvuus liikkuvuus = alustaLiikkuvuus();
        Hyokkays hyokkays = alustaHyokkays();
        
        return new Yksikkotyyppi(liikkuvuus, hyokkays);
        
    }
    
    private Liikkuvuus alustaLiikkuvuus() throws Exception{
        int liikuntamaara = Integer.parseInt(tiedostonTiedot.get(lukukohta));
        lukukohta++;
        
        Map<Aluetyyppi, Boolean> mihinVoiLiikkua = alustaMihinYksikkotyyppiVoiLiikkua();
        Map<Maastotyyppi, Double> paljonkoLiikkuminenMaksaa = alustaLiikkumisenMaksut();
        
        return new Liikkuvuus(mihinVoiLiikkua, paljonkoLiikkuminenMaksaa, liikuntamaara);
    }
    
    private Map<Aluetyyppi, Boolean> alustaMihinYksikkotyyppiVoiLiikkua() throws Exception{
        
        Map<Aluetyyppi, Boolean> missaVoiLiikkua = new HashMap<>();
        
        for(int i=0; i<2;i++){
            String tamaRivi = tiedostonTiedot.get(lukukohta+i);
            
            Aluetyyppi aluetyyppi;
            
            switch(tamaRivi.charAt(0)){
                case 'm': aluetyyppi = Aluetyyppi.MAA;
                        break;
                case 'v': aluetyyppi = Aluetyyppi.VESI;
                        break;
                default: throw new Exception();
            }
            
            boolean voikoLiikkua;
            
            char totuuskirjain = tamaRivi.charAt(1);
            
            if(totuuskirjain=='1'){
                voikoLiikkua = true;
            }else if(totuuskirjain=='0'){
                voikoLiikkua = false;
            }else{throw new Exception();}
            
            missaVoiLiikkua.put(aluetyyppi, voikoLiikkua);
        }
        
        lukukohta+=2;
        
        return missaVoiLiikkua;
    }
    
    private Map<Maastotyyppi, Double> alustaLiikkumisenMaksut()throws Exception{
        
        Map<Maastotyyppi, Double> liikkumisenMaksut = new HashMap<>();
        
        for(int i=0;i<2;i++){
            String tamaRivi = tiedostonTiedot.get(lukukohta+i);
            
            Maastotyyppi maastotyyppi;
            
            switch(tamaRivi.charAt(0)){
                case 'a': maastotyyppi = Maastotyyppi.AVOMAA;
                        break;
                case 'm': maastotyyppi = Maastotyyppi.METSA;
                        break;
                default: throw new Exception();
            }
            
            double kuluvaMatka = Double.parseDouble(tamaRivi.substring(2));
            
            liikkumisenMaksut.put(maastotyyppi, kuluvaMatka);
        }
        
        lukukohta+=2;
        
        return liikkumisenMaksut;
    }
    
    private Hyokkays alustaHyokkays(){
        if(tiedostonTiedot.get(lukukohta).equals("-")){
            return new Hyokkays();
        }
        
        return new Hyokkays();
    }
    ///
    //
    
    
    @Override
    public Kartta alustaKartta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alustaYksikot(List<Pelaaja> pelaajat, Kartta kartta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
