package jek.gameprojects.strategiapelioh.logiikka.laskurit;

import jek.gameprojects.strategiapelioh.logiikka.laskurit.Laskuri;

public class RajoitettuLaskuri extends Laskuri{
    
    private int alaraja;
    private int ylaraja;
    private int arvo;
    
    public RajoitettuLaskuri(int ylaraja, int alaraja, int alkuArvo){
        this.ylaraja=ylaraja;
        this.alaraja=alaraja;
        
        if(alkuArvo>ylaraja||alkuArvo<alaraja){
            arvo=ylaraja;
        }else{
            arvo=alkuArvo;
        }
        
    }
    
    public RajoitettuLaskuri(int ylaraja, int alaraja){
        this(ylaraja, alaraja, ylaraja);
    }
    
    @Override
    public void lisaaArvoa(int maara){
        if(arvo+maara>ylaraja){
            arvo=ylaraja;
            return;
        }
        
        if(arvo+maara<alaraja){
            arvo=alaraja;
            return;
        }
        
        arvo+=maara;
     
    }
    
    @Override
    public void setArvo(int uusiArvo){
        if(uusiArvo>=alaraja && uusiArvo<=ylaraja){
            arvo=uusiArvo;
        }
    }
    
    @Override
    public int getArvo(){
        return arvo;
    }

    public int getAlaraja() {
        return alaraja;
    }

    public int getYlaraja() {
        return ylaraja;
    }
    
    
}
