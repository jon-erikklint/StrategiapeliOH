package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkaobjekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Kuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.Hyokkaysavustaja;

public class AlustaHyokattavatRuudut implements Efekti{
    
    private Hyokkaysavustaja hyokkaysavustaja;
    private List<ObjectKuva<Ruutu>> ruudut;
    
    public AlustaHyokattavatRuudut(Hyokkaysavustaja hyokkaysavustaja, List<Grafiikkaobjekti> kartanRuudut) {
        this.hyokkaysavustaja = hyokkaysavustaja;
        
        this.ruudut = new ArrayList<>();
        for(Grafiikkaobjekti grafiikkaobjekti : kartanRuudut){
            
            if(grafiikkaobjekti.getClass().equals(ObjectKuva.class)){
                ruudut.add((ObjectKuva<Ruutu>) grafiikkaobjekti);
            }
            
        }
    }
    
    @Override
    public void toimi() {
        Set<Koordinaatti> hyokattavat = hyokkaysavustaja.asetaJoukonHyokattavatRuudut();
        
        for(ObjectKuva<Ruutu> ruudunKuva : ruudut){
            Ruutu ruutu = ruudunKuva.getT();
            
            if(hyokattavat.contains(ruutu.getSijainti())){
                
                ruudunKuva.setImage(KuvaSailio.getKuva(ruutu.toString()+":HYOKATTAVA"));
                
            }
        }
    }
    
}
