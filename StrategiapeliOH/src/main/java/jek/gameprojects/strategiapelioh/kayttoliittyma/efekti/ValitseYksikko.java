package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Pelitila;

public class ValitseYksikko extends PelitilaEfekti{
    
    private Yksikko yksikko;
    
    public ValitseYksikko(Pelitila pelitila, Yksikko yksikko){
        super(pelitila);
        
        this.yksikko = yksikko;
    }

    @Override
    public void toimi() {
        Joukko valittuJoukko = pelitila.getTilat().getValitutYksikot();
        
        if(valittuJoukko.getYksikot().contains(yksikko)){
            
            pelitila.getPeli().getJoukkojenHallinnoija().luoYksikolleOmaJoukko(yksikko);
            
        }else{
            
            valittuJoukko.lisaaYksikko(yksikko);
            
        }
    }
}
