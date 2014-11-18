package jek.gameprojects.strategiapelioh.domain.peli;

import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;

public class Peli {
    
    private Kierros kierros;
    private Vuoro vuoro;
    
    private List<Yksikkotyyppi> yksikkotyypit;
    private List<Pelaaja> pelaajat;
    
    private Kartta kartta;
    
    public Peli(List<Pelaaja> pelaajat, Kartta kartta, List<Yksikkotyyppi> yksikkotyypit){
        
        this.pelaajat=pelaajat;
        this.kartta=kartta;
        this.yksikkotyypit=yksikkotyypit;
        
        kierros = new Kierros(0);
        
    }
    
    
    
}
