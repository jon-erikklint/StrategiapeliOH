package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.Hyokkaysavustaja;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.TilaAvustaja;

public class HyokkaaRuutuun implements Efekti{

    private Hyokkaysavustaja hyokkaysavustaja;
    private TilaAvustaja tilaAvustaja;
    
    private Ruutu ruutu;
    
    public HyokkaaRuutuun(Hyokkaysavustaja hyokkaysavustaja, TilaAvustaja tilaAvustaja, Ruutu ruutu){
        this.hyokkaysavustaja = hyokkaysavustaja;
        this.tilaAvustaja = tilaAvustaja;
        
        this.ruutu = ruutu;
    }
    
    @Override
    public void toimi() {
        if(hyokkaysavustaja.onkoHyokattavaRuutu(ruutu.getSijainti())){
            hyokkaysavustaja.hyokkaaHyokkaavilla(ruutu);
        }else{
            tilaAvustaja.nollaaTilanne();
        }
    }
    
}
