package jek.gameprojects.strategiapelioh.logiikka;

public class Indeksoija{
    
    private int arvo;
    
    public Indeksoija(int alkuarvo){
        this.arvo=alkuarvo;
    }
    
    public int nextIndex(){
        int nyt=arvo;
        
        arvo++;
        
        return nyt;
    }
}
