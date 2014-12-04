package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Tilat;

public class AktivoiRuutu extends PelitilaEfekti{
    
    private ObjectKuva<Ruutu> ruutuKuva;
    
    public AktivoiRuutu(Pelitila pelitila, ObjectKuva<Ruutu> ruutuKuva) {
        super(pelitila);
        
        this.ruutuKuva = ruutuKuva;
    }

    @Override
    public void toimi() {
        Tilat tilat = pelitila.getTilat();
        
        if(tilat.getValittuRuutu().equals(ruutuKuva.getT())){
            
            tilat.nollaaTilanne();
            
        }else{
            tilat.setValittuRuutu(ruutuKuva.getT());
            tilat.setValitutYksikot(ruutuKuva.getT().annaEnsimmainenJoukko());
            
            ruutuKuva.setImage(KuvaSailio.getKuva( ruutuKuva.getT().toString()+":AKTIIVINEN") );
        }
    }
    
}
