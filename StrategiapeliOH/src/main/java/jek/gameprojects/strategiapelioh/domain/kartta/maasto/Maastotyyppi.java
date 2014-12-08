package jek.gameprojects.strategiapelioh.domain.kartta.maasto;

/**
 * 
 * Tietyn paikan maastotyyppi, esim metsä
 * 
 */

public enum Maastotyyppi {
    
    METSA("metsa"), AVOMAA("avomaa");
    
    private final String nimi;
    
    Maastotyyppi(String nimi){
        this.nimi=nimi;
    }
    
    @Override
    public String toString(){
        return nimi;
    }
}
