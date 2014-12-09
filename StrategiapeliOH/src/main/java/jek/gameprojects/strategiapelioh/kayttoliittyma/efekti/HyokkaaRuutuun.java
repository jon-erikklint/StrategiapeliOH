package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;
import jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen.Hyokkayshallinnoija;

public class HyokkaaRuutuun extends PelitilaEfekti{

    private Ruutu ruutu;
    
    public HyokkaaRuutuun(Pelitila pelitila, Ruutu ruutu){
        super(pelitila);
        
        this.ruutu = ruutu;
    }
    
    @Override
    public void toimi() {
        Hyokkayshallinnoija hal= pelitila.getPeli().getHyokkayshallinnoija();
        
        if(hal.getJoukonHyokattavatRuudut(pelitila.getTilat().getValitutYksikot()).contains(ruutu.getSijainti())){
            
            hal.hyokkaaJoukollaRuutuun(pelitila.getTilat().getValitutYksikot(), ruutu.getSijainti());
            
        }
        
        pelitila.tyhjennaValinnat();
    }
    
}
