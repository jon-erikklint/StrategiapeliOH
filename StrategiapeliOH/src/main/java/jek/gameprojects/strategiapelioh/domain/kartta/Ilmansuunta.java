package jek.gameprojects.strategiapelioh.domain.kartta;

/**
 * 
 * Ilmansuunnan mukaisen vektorin sisältävä enum
 * 
 */
public enum Ilmansuunta{
    POHJOINEN(new Koordinaatti(0,-1)),
    ETELA(new Koordinaatti(0,1)),
    LANSI(new Koordinaatti(-1,0)),
    ITA(new Koordinaatti(1,0));
    
    private final Koordinaatti koordinaatti;
    
    Ilmansuunta(Koordinaatti koordinaatti){
        this.koordinaatti=koordinaatti;
    }
    
    public Koordinaatti suuntakoordinaatti(){
        return koordinaatti;
    }
}
