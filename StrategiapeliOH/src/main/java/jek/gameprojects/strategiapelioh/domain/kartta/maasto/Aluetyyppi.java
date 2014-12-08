package jek.gameprojects.strategiapelioh.domain.kartta.maasto;

/**
 * 
 * Tietyn paikan aluetyyppi, esim vesi, maa
 * 
 */

public enum Aluetyyppi {
    
    MAA("maa"), VESI("vesi");
    
    private final String nimi;
    
    Aluetyyppi(String nimi){
        this.nimi=nimi;
    }
    
    @Override
    public String toString(){
        return nimi;
    }
    
}
