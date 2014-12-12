package jek.gameprojects.strategiapelioh.logiikka;

/**
 * 
 * Luokka joka antaa indeksejä uusille yksiköille/muille indeksoitaville
 * 
 */
public class Indeksoija{
    
    private int arvo;
    
    public Indeksoija(int alkuarvo){
        this.arvo=alkuarvo;
    }
    
    /**
     * Antaa seuraavan indeksin arvon, joka kasvaa aina yhdellä kutsukertaa kohden
     * 
     * @return seuraavaIndeksi
     */
    public int nextIndex(){
        int nyt=arvo;
        
        arvo++;
        
        return nyt;
    }
}
