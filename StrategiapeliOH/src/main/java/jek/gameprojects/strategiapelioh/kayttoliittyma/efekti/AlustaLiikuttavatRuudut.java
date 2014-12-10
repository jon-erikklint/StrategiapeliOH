package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import java.util.Map;
import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.RuudunKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;

public class AlustaLiikuttavatRuudut extends PelitilaEfekti{

    public AlustaLiikuttavatRuudut(Pelitila pelitila){
        super(pelitila);
    }
    
    @Override
    public void toimi() {
        Set<Koordinaatti> liikuttavatRuudut = pelitila.getPeli().getLiikuttaja().alustaJoukonMahdollisetLiikkeet(pelitila.getTilat().getValitutYksikot());
        Map<Koordinaatti, RuudunKuva> ruudut = pelitila.getKartta().getRuutuKartta();
        
        
        for(Koordinaatti sijainti : liikuttavatRuudut){
            RuudunKuva ruutu = ruudut.get(sijainti);
            
            ruutu.getObjectKuvaRuutu().setImage(KuvaSailio.getKuva(ruutu.getRuutu().toString()+":LIIKUTTAVA"));
            
        }
        
        pelitila.getTilat().setPelitila(2);
    }
    
}
