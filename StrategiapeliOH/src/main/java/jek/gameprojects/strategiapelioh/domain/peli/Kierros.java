package jek.gameprojects.strategiapelioh.domain.peli;

import java.util.List;

public class Kierros {
    
    private final int kierros;
    private List<Vuoro> vuorot;
    
    public Kierros(int kierros){
        this.kierros = kierros;
    }
    
    public Kierros getSeuraavaKierros(){
        return new Kierros(kierros+1);
    }
    
    public int getKierros(){
        return kierros;
    }
}
