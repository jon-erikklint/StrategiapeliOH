package jek.gameprojects.strategiapelioh.logiikka.generointi.aseet;

import jek.gameprojects.strategiapelioh.logiikka.generointi.aseet.PanssarivahvuuksienAlustaja;
import java.util.HashMap;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;

public class PanssarivahvuuksienVakioAlustaja implements PanssarivahvuuksienAlustaja{

    private Map<Asetyyppi, Map<Panssarityyppi, Double>> panssarityyppienVahvuudet;
    
    @Override
    public Map<Asetyyppi, Map<Panssarityyppi, Double>> panssarityyppienVahvuudet() {
        panssarityyppienVahvuudet = new HashMap<>();
        
        alustaAsetyyppi(Asetyyppi.LASER, 1.0);
        alustaAsetyyppi(Asetyyppi.LUOTI, 1.0);
        alustaAsetyyppi(Asetyyppi.RAJAHDE, 1.0);
        
        return panssarityyppienVahvuudet;
    }
    
    private void alustaAsetyyppi(Asetyyppi asetyyppi, double... vahvuudet){
        panssarityyppienVahvuudet.put(asetyyppi, alustaAseenPanssarityyppivahvuudet(vahvuudet));
    }
    
    private Map<Panssarityyppi, Double> alustaAseenPanssarityyppivahvuudet(double[] vahvuudet){
        Map<Panssarityyppi, Double> aseenVahvuudet = new HashMap<>();
        
        for(int i=0; i<Panssarityyppi.values().length; i++){
            aseenVahvuudet.put(Panssarityyppi.values()[i], vahvuudet[i]);
        }
        
        return aseenVahvuudet;
    }
    
}
