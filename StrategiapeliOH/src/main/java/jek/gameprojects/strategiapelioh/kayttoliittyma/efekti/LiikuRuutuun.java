package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.Liikkumisavustaja;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.TilaAvustaja;

public class LiikuRuutuun implements Efekti{

    private Liikkumisavustaja liikkumisavustaja;
    private TilaAvustaja tilaAvustaja;
    
    private Ruutu ruutu;

    public LiikuRuutuun(Liikkumisavustaja liikkumisavustaja, TilaAvustaja tilaAvustaja, Ruutu ruutu) {
        this.liikkumisavustaja = liikkumisavustaja;
        this.tilaAvustaja = tilaAvustaja;
        this.ruutu = ruutu;
    }
    
    @Override
    public void toimi() {
        if(liikkumisavustaja.onkoLiikuttavaRuutu(ruutu)){
            
            liikkumisavustaja.liikutaJoukkoRuutuun(ruutu);
            
        }
        
        tilaAvustaja.nollaaTilanne();
        
    }
    
}
