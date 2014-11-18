package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class TiedostoAlustaja {
    
    List<String> tiedostonTiedot;
    int lukukohta;
    
    public TiedostoAlustaja(String osoite) throws Exception{
        TiedostonPurkaja purkaja = new TiedostonPurkaja();
        
        tiedostonTiedot = purkaja.lueTiedosto(osoite);
        
        lukukohta=0;
    }
    
    public boolean tulkitseTotuusarvo()throws Exception{
        char totuuskirjain = nykyinen().charAt(0);
        
        kasvata(1);
        
        if(totuuskirjain == '0'){
            return false;
        }else if(totuuskirjain == '1'){
            return true;
        }else{
            throw new Exception("Virhe tulkittaessa totuusarvoa rivillä "+lukukohta);
        }
        
    }
    
    public int tulkitseKokonaisluku() throws Exception{
        String rivi = nykyinen();
        
        kasvata(1);
        
        try{
            return Integer.parseInt(rivi);
        }catch(Exception e){
            throw new Exception("Virhe tulkittaessa kokonaislukua rivillä "+lukukohta);
        }
    }
    
    public double tulkitseLiukuluku() throws Exception{
        String rivi = nykyinen();
        
        kasvata(1);
        
        try{
            return Double.parseDouble(rivi);
        }catch(Exception e){
            throw new Exception("Virhe tulkittaessa liukulukua rivillä "+lukukohta);
        }
    }
    
    public String annaString(){
        String palautettava = nykyinen();
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
