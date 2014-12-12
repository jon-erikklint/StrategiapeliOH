package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Purkaa tiedostoja string-listoiksi
 * 
 */
public class TiedostonPurkaja {
    
    /**
     * Muuttaa annetun tiedoston listaksi tekstijonoja. Jako tapahtuu rivinvaihtojen perusteella.
     * 
     * @param tiedostonNimi
     * @return tiedosto string-listana
     * @throws Exception tiedostoa ei voitu lukea
     */
    public List<String> lueTiedosto(String tiedostonNimi) throws Exception{
        
        List<String> sisalto = new ArrayList<>();
        
        try{InputStream is = getClass().getResourceAsStream(tiedostonNimi);
        
            String rivi="";
            int Byte;
            
            while ((Byte = is.read()) != -1 ) {
                char kirjain = (char) Byte;
                
                if(kirjain=='\n'){
                    sisalto.add(rivi);
                    rivi="";
                }else{
                    rivi=rivi+kirjain;
                }
                
            }
            
            sisalto.add(rivi);
        }
        catch(Exception e){
            throw new Exception("Virhe tiedostoa luettaessa");
        }
            

        return sisalto;
        
    }
    
}
