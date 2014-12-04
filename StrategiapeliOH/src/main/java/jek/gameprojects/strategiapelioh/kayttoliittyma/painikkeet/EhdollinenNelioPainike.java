package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.efekti.Efekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class EhdollinenNelioPainike extends NelioPainike{

    private Pelitila pelitila;
    private Kuva kuva;
    
    public EhdollinenNelioPainike(Efekti efekti, Vektori sijainti, Vektori koko, int taso, Kuva kuva, Pelitila pelitila) {
        super(efekti, sijainti, koko, taso);
        this.kuva = kuva;
        
        this.pelitila = pelitila;
    }
    
    @Override
    public void paivita(){
        Ruutu valittuRuutu = pelitila.getTilat().getValittuRuutu();
        
        if(valittuRuutu==null){
            
            super.setNakyvyys(false);
            kuva.setNakyvyys(false);
            
        }else{
            
            super.setNakyvyys(true);
            kuva.setNakyvyys(true);
            
        }
    }
    
}
