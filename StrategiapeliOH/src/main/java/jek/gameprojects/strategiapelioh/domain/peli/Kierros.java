package jek.gameprojects.strategiapelioh.domain.peli;

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
        this.kierros = kierros;
    }
    
    public void lisaaVuoro(Vuoro vuoro){
        vuorot.add(vuoro);
    }
    
    public Kierros getSeuraavaKierros(){
        return new Kierros(kierros+1);
    }
    
    public int getKierros(){
        return kierros;
    }

    public List<Vuoro> getVuorot() {
        return vuorot;
    }
    
}
