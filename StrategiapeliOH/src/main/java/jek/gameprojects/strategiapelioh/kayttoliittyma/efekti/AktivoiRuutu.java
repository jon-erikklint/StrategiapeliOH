package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.TilaAvustaja;

public class AktivoiRuutu implements Efekti{
    
    private ObjectKuva<Ruutu> ruutuKuva;
    
    private TilaAvustaja tilaAvustaja;
    
    public AktivoiRuutu(ObjectKuva<Ruutu> ruutuKuva, TilaAvustaja tilaAvustaja) {
        this.ruutuKuva=ruutuKuva;
        
        this.tilaAvustaja = tilaAvustaja;
    }

    @Override
    public void toimi() {
        if(tilaAvustaja.getValittuRuutu().getMuuttuja().equals(ruutuKuva.getT())){
            
            tilaAvustaja.nollaaTilanne();
            
        }else{
            tilaAvustaja.getValittuRuutu().setMuuttuja(ruutuKuva.getT());
            tilaAvustaja.getValitutYksikot().setMuuttuja(ruutuKuva.getT().annaEnsimmainenJoukko());
            
            ruutuKuva.setImage(KuvaSailio.getKuva( ruutuKuva.getT().toString()+":AKTIIVINEN") );
        }
    }
    
}
