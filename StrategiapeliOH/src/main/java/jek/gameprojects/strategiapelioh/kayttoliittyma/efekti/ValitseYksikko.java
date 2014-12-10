package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.YksikonKuvake;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;

public class ValitseYksikko extends PelitilaEfekti{
    
    private YksikonKuvake yksikonKuvake;
    
    public ValitseYksikko(Pelitila pelitila, YksikonKuvake yksikonKuvake){
        super(pelitila);
        
        this.yksikonKuvake = yksikonKuvake;
    }

    @Override
    public void toimi() {
        Joukko valittuJoukko = pelitila.getTilat().getValitutYksikot();
        Yksikko yksikko = yksikonKuvake.getYksikko();
        
        if(valittuJoukko.getYksikot().contains(yksikko)){
            
            pelitila.getPeli().getJoukkojenHallinnoija().luoYksikolleOmaJoukko(yksikko);
            
        }else{
            
            valittuJoukko.lisaaYksikko(yksikko);
            
        }
    }
}
