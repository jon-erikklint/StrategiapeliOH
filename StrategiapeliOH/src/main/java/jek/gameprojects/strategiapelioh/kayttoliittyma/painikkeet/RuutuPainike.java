package jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public class RuutuPainike extends NelioPainike{

    private ObjectKuva<Ruutu> ruutuKuva;
    
    private Ruutu aktiivinenRuutu;

    public RuutuPainike(Vektori sijainti, Vektori koko, int taso, ObjectKuva<Ruutu> ruutuKuva) {
        super(sijainti, koko, taso);
        
        this.ruutuKuva=ruutuKuva;
    }
    
    @Override
    public void toimi() {
        if(aktiivinenRuutu.equals(ruutuKuva.getT())){
            
            aktiivinenRuutu = null;
            
        }else{
            aktiivinenRuutu = ruutuKuva.getT();
            
            ruutuKuva.setImage(KuvaSailio.getKuva(aktiivinenRuutu.toString()+":aktiivinen"));
        }
    }

    @Override
    public void paivita() {}
    
}
