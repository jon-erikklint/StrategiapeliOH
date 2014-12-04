package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import java.util.Map;
import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Pelitila;

public class AlustaLiikuttavatRuudut extends PelitilaEfekti{

    public AlustaLiikuttavatRuudut(Pelitila pelitila){
        super(pelitila);
    }
    
    @Override
    public void toimi() {
        Set<Koordinaatti> liikuttavatRuudut = pelitila.getPeli().getLiikuttaja().alustaJoukonMahdollisetLiikkeet(pelitila.getTilat().getValitutYksikot());
        Map<Koordinaatti, ObjectKuva<Ruutu>> ruudut = pelitila.getKartta().getRuutuKartta();
        
        
        for(Koordinaatti sijainti : liikuttavatRuudut){
            ObjectKuva<Ruutu> ruutu = ruudut.get(sijainti);
            
            ruutu.setImage(KuvaSailio.getKuva(ruutu.getT().toString()+"LIIKUTTAVA"));
            
        }
    }
    
}
