package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import java.util.Map;
import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;

public class AlustaHyokattavatRuudut extends PelitilaEfekti{
    
    public AlustaHyokattavatRuudut(Pelitila pelitila) {
        super(pelitila);
    }
    
    @Override
    public void toimi() {
        Set<Koordinaatti> hyokattavat = pelitila.getPeli().getHyokkayshallinnoija().alustaJoukonHyokattavatRuudut(pelitila.getTilat().getValitutYksikot());
        Map<Koordinaatti, ObjectKuva<Ruutu>> ruudut = pelitila.getKartta().getRuutuKartta();
        
        for(Koordinaatti sijainti : hyokattavat){
            
            ruudut.get(sijainti).setImage(KuvaSailio.getKuva(ruudut.get(sijainti).toString()+":HYOKATTAVA"));
            
        }
    }
    
}
