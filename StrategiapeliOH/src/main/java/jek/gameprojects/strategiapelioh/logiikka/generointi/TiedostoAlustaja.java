package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.io.FileNotFoundException;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;

public abstract class TiedostoAlustaja {
    
    List<String> tiedostonTiedot;
    int lukukohta;
    
    public TiedostoAlustaja(String osoite) throws Exception{
        TiedostonPurkaja purkaja = new TiedostonPurkaja();
        
        tiedostonTiedot = purkaja.lueTiedosto(osoite);
        
        lukukohta=0;
    }
    
    public boolean tulkitseTotuusarvo()throws Exception{
        char totuuskirjain = annaString().charAt(0);
        
        boolean palautettava = tulkitseTotuusarvo(totuuskirjain);
        
        kasvata(1);
        
        return palautettava;
        
    }
    
    public boolean tulkitseTotuusarvo(char kirjain) throws Exception{
        if(kirjain == '0'){
            return false;
        }else if(kirjain == '1'){
            return true;
        }else{
            throw new Exception("Virhe tulkittaessa totuusarvoa rivillä "+lukukohta);
        }
    }
    
    public int tulkitseKokonaisluku() throws Exception{
        String rivi = annaString();
        
        int palautettava = tulkitseKokonaisluku(rivi);
        
        kasvata(1);
        
        return palautettava;
    }
    
    public int tulkitseKokonaisluku(String teksti) throws Exception{
        try{
            return Integer.parseInt(teksti);
        }catch(Exception e){
            throw new Exception("Virhe tulkittaessa kokonaislukua rivillä "+lukukohta);
        }
    }
    
    public double tulkitseLiukuluku() throws Exception{
        String rivi = annaString();
        
        double palautettava = tulkitseLiukuluku(rivi);
        
        kasvata(1);
        
        return palautettava;
    }
    
    public double tulkitseLiukuluku(String teksti)throws Exception{
        try{
            return Double.parseDouble(teksti);
        }catch(Exception e){
            throw new Exception("Virhe tulkittaessa liukulukua rivillä "+lukukohta);
        }
    }
    
    public Koordinaatti tulkitseKoordinaatti() throws Exception{
        String rivi = nykyinen();
        
        Koordinaatti palautettava = tulkitseKoordinaatti(rivi);
        
        kasvata(1);
        
        return palautettava;
    }
    
    public Koordinaatti tulkitseKoordinaatti(String rivi) throws Exception{
        int kohta = 0;
        for(int i=0;i<rivi.length();i++){
            if(rivi.charAt(i)=='.'){
                kohta = i;
                break;
            }
            
            if(i==rivi.length()-1){
                throw new Exception("Virheellinen koordinaatti rivillä "+lukukohta);
            }
        }
        
        int x = tulkitseKokonaisluku(rivi.substring(0, kohta));
        int y = tulkitseKokonaisluku(rivi.substring(kohta+1));
        
        return new Koordinaatti(x,y);
    }
    
    public String annaString() throws Exception{
        String palautettava;
        
        try{
            palautettava = nykyinen();
        }catch(Exception e){
            throw new Exception("Tiedosto liian pieni");
        }
        
        kasvata(1);
        
        return palautettava;
    }
    
    public void tarkistaLukukohta() throws Exception{
        if(lukukohta>=tiedostonTiedot.size()){
            throw new Exception("Kaikkia tietoja ei voitu ladata: tiedosto liian pieni/toistolause ei loppunut");
        }
    }
    
    public void kasvata(int maara){
        lukukohta+=maara;
    }
    
    public String nykyinen(){
        return tiedostonTiedot.get(lukukohta);
    }
    
}
