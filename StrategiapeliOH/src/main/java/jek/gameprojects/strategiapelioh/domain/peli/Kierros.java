package jek.gameprojects.strategiapelioh.domain.peli;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Pelin ajallinen yksikkö, joka koostuu yhdestä jokaisen pelaajan vuorosta
 * 
 */

public class Kierros {
    
    private final int kierros;
    private List<Vuoro> vuorot;
    
    public Kierros(int kierros){
        vuorot = new ArrayList<>();
        
        this.kierros = kierros;
    }
    
    /**
     * Lisää vuoron kierroksen tietoihin.
     * 
     * @param vuoro lisättävä vuoro
     */
    public void lisaaVuoro(Vuoro vuoro){
        vuorot.add(vuoro);
    }
    
    /**
     * Palauttaa itseään seuraavan kierroksen
     * 
     * @return uusi kierros
     */
    public Kierros getSeuraavaKierros(){
        return new Kierros(kierros+1);
    }
    
    public int getKierros(){
        return kierros;
    }

    public List<Vuoro> getVuorot() {
        return vuorot;
    }
    
    @Override
    public String toString(){
        return "Kierros: "+kierros;
    }
    
}
