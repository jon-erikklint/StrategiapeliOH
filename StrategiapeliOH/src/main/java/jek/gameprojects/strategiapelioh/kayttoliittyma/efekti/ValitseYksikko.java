package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.pelaajat.Joukko;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikko;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.JoukkojenHallinnoija;

public class ValitseYksikko implements Efekti{
    
    private Tila<Joukko> valitutYksikot;
    private Yksikko yksikko;
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    public ValitseYksikko(Tila<Joukko> valitutYksikot, Yksikko yksikko){
        this.valitutYksikot = valitutYksikot;
        this.yksikko = yksikko;
        
        joukkojenHallinnoija = new JoukkojenHallinnoija();
    }

    @Override
    public void toimi() {
        Joukko valittuJoukko = valitutYksikot.getMuuttuja();
        
        if(valittuJoukko.getYksikot().contains(yksikko)){
            joukkojenHallinnoija.luoYksikolleOmaJoukko(yksikko);
        }else{
            valittuJoukko.lisaaYksikko(yksikko);
        }
    }
}
