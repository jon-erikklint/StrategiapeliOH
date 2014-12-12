package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;

/**
 * Alustajatyyppi joka lukee alustettavia tietoja tiedostosta. Sisältää yleishyödyllisiä metodeja tiedoston tulkitsemiseen
 * 
 */
public abstract class TiedostoAlustaja {
    
    List<String> tiedostonTiedot;
    int lukukohta;
    
    public TiedostoAlustaja(String osoite) throws Exception{
        TiedostonPurkaja purkaja = new TiedostonPurkaja();
        
        tiedostonTiedot = purkaja.lueTiedosto(osoite);
        
        lukukohta=0;
    }
    
    /**
     * Tulkitsee totuusarvon seuraavan rivin ensimmäisestä kirjaimesta
     * 
     * @return totuusarvo
     * @throws Exception Rivi ei ollut tulkittavissa totuusarvona
     */
    public boolean tulkitseTotuusarvo()throws Exception{
        char totuuskirjain = annaString().charAt(0);
        
        boolean palautettava = tulkitseTotuusarvo(totuuskirjain);
        
        kasvata(1);
        
        return palautettava;
        
    }
    
    /**
     * Tulkitsee anetun kirjaimen totuusarvoksi
     * 
     * @param kirjain
     * @return totuusarvo
     * @throws Exception kirjain ei ollut tulkittavissa totuusarvoksi
     */
    public boolean tulkitseTotuusarvo(char kirjain) throws Exception{
        if(kirjain == '0'){
            return false;
        }else if(kirjain == '1'){
            return true;
        }else{
            throw new Exception("Virhe tulkittaessa totuusarvoa rivillä "+lukukohta);
        }
    }
    
    /**
     * Tulkitsee kokonaisluvun seuraavalta lukuriviltä
     * 
     * @return kokonaisluku
     * @throws Exception rivi ei ollut tulkittavissa kokonaisluvuksi
     */
    public int tulkitseKokonaisluku() throws Exception{
        String rivi = annaString();
        
        int palautettava = tulkitseKokonaisluku(rivi);
        
        kasvata(1);
        
        return palautettava;
    }
    
    /**
     * Tulkitsee annetun stringin kokonaislukuna
     * 
     * @param teksti
     * @return kokonaisluku
     * @throws Exception Stringi ei ollut tulkittavissa kokonaislukuna
     */
    public int tulkitseKokonaisluku(String teksti) throws Exception{
        try{
            return Integer.parseInt(teksti);
        }catch(Exception e){
            throw new Exception("Virhe tulkittaessa kokonaislukua rivillä "+lukukohta);
        }
    }
    
    /**
     * Tulkitsee seuraavan rivin liukulukuna
     * 
     * @return liukuluku
     * @throws Exception Rivi ei ollut tulkittavissa liukulukuna
     */
    public double tulkitseLiukuluku() throws Exception{
        String rivi = annaString();
        
        double palautettava = tulkitseLiukuluku(rivi);
        
        kasvata(1);
        
        return palautettava;
    }
    
    /**
     * Tulkitsee annetun tekstin liukulukuna
     * 
     * @param teksti
     * @return liukuluku
     * @throws Exception tekstiä ei voinut tulkita liukuluvuksi
     */
    public double tulkitseLiukuluku(String teksti)throws Exception{
        try{
            return Double.parseDouble(teksti);
        }catch(Exception e){
            throw new Exception("Virhe tulkittaessa liukulukua rivillä "+lukukohta);
        }
    }
    
    /**
     * Tulkitsee seuraavan rivin koordinaattina
     * 
     * @return koordinaatti
     * @throws Exception rivi ei tulkittavissa koordinaattina
     */
    public Koordinaatti tulkitseKoordinaatti() throws Exception{
        String rivi = nykyinen();
        
        Koordinaatti palautettava = tulkitseKoordinaatti(rivi);
        
        kasvata(1);
        
        return palautettava;
    }
    
    /**
     * Tulkitsee annetun stringin koordinaattina
     * 
     * @param rivi
     * @return koordinaatti
     * @throws Exception stringi ei tulkittavissa koordinaattina
     */
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
    
    /**
     * Antaa seuraavan rivin stringinä
     * 
     * @return string
     * @throws Exception tiedostossa ei ole seuraavaa riviä 
     */
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
    
    /**
     * Tarkistaa onko lukukohta tiedoston sisällä
     * 
     * @throws Exception lukukohta ei ole tiedoston sisällä
     */
    public void tarkistaLukukohta() throws Exception{
        if(lukukohta>=tiedostonTiedot.size()){
            throw new Exception("Kaikkia tietoja ei voitu ladata: tiedosto liian pieni/toistolause ei loppunut");
        }
    }
    
    /**
     * Siirtää lukukohtaa annetun määrän
     * 
     * @param maara 
     */
    public void kasvata(int maara){
        lukukohta+=maara;
    }
    
    /**
     * Antaa nykyisen rivin tiedot
     * 
     * @return rivi
     */
    public String nykyinen(){
        return tiedostonTiedot.get(lukukohta);
    }
    
    /**
     * Palauttaa lukukohdan
     * 
     * @return lukukohta
     */
    public int lukukohta(){
        return this.lukukohta;
    }
    
}
