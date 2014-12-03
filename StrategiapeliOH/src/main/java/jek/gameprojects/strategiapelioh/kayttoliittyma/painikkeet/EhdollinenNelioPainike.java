package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Efekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Tila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class EhdollinenNelioPainike extends NelioPainike{

    private Tila<Ruutu> valittuRuutu;
    private Kuva kuva;
    
    public EhdollinenNelioPainike(Efekti efekti, Vektori sijainti, Vektori koko, int taso, Tila<Ruutu> valittuRuutu, Kuva kuva) {
        super(efekti, sijainti, koko, taso);
        
        this.valittuRuutu = valittuRuutu;
        this.kuva = kuva;
    }
    
    @Override
    public void paivita(){
        if(valittuRuutu.getMuuttuja()==null){
            super.setNakyvyys(false);
            kuva.setNakyvyys(false);
        }else{
            super.setNakyvyys(true);
            kuva.setNakyvyys(true);
        }
    }
    
}
