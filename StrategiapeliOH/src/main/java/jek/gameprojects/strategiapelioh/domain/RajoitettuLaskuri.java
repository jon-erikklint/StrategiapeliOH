package jek.gameprojects.strategiapelioh.domain;

public class RajoitettuLaskuri {
    
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
    
    public void asetaArvo(int uusiArvo){
        if(uusiArvo>=alaraja && uusiArvo<=ylaraja){
            arvo=uusiArvo;
        }
    }
    
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
