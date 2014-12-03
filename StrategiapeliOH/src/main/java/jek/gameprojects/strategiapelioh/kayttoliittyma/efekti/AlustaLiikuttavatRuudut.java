package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkaobjekti;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.avustajat.Liikkumisavustaja;

public class AlustaLiikuttavatRuudut implements Efekti{

    private Liikkumisavustaja liikkumisavustaja;
    
    private List<ObjectKuva<Ruutu>> ruudut;
    
    public AlustaLiikuttavatRuudut(Liikkumisavustaja liikkumisavustaja, List<Grafiikkaobjekti> kartanRuudut){
        this.liikkumisavustaja = liikkumisavustaja;
        
        this.ruudut = new ArrayList<>();
        for(Grafiikkaobjekti grafiikkaobjekti : kartanRuudut){
            
            if(grafiikkaobjekti.getClass().equals(ObjectKuva.class)){
                ruudut.add((ObjectKuva<Ruutu>) grafiikkaobjekti);
            }
            
        }
    }
    
    @Override
    public void toimi() {
        Set<Koordinaatti> liikuttavatRuudut = liikkumisavustaja.alustaLiikuttavatRuudut();
        
        for(ObjectKuva<Ruutu> ruudunKuva : ruudut){
            if(liikuttavatRuudut.contains(ruudunKuva.getT().getSijainti())){
                ruudunKuva.setImage(KuvaSailio.getKuva(ruudunKuva.getT().toString()+"LIIKUTTAVA"));
            }
        }
    }
    
}
