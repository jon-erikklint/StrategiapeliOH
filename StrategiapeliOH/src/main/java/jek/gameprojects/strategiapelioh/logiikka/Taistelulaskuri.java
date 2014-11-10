package jek.gameprojects.strategiapelioh.logiikka;

import java.util.List;
import java.util.Map;
import java.util.Random;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Sotilas;

public class Taistelulaskuri {
    
    private Map<Asetyyppi,Map<Panssarityyppi, Double>> asetyyppienVahvuudet; 
    
    private Random random;
    
    private List<Sotilas> hyokkaajat;
    private List<Sotilas> puolustajat;
    
    public Taistelulaskuri(Map<Asetyyppi,Map<Panssarityyppi,Double>> asetyyppienVahvuudet){
        random = new Random();
        
        this.asetyyppienVahvuudet=asetyyppienVahvuudet;
    }
    
    public void taisteleKierros(){
        
    }
    
//    public Sotilas haePahinPuolustaja(Sotilas hyokkaava){
//        Sotilas puolustaja;
//        double puolustuskerroin=-1;
//        
//        for(Sotilas sotilas:puolustajat){
//            double vastaavaPuolustuskerroin=haeVahvinPanssari(sotila)
//        }
//    }
    
    public void nollaa(){
        hyokkaajat.clear();
        puolustajat.clear();
    }
    
    public double haeVahvinPanssari(Asetyyppi asetyyppi, List<Panssarityyppi> panssarit){
        Map<Panssarityyppi, Double> asetyypinVahvuudet = asetyyppienVahvuudet.get(asetyyppi);
        
        double vahvin=asetyypinVahvuudet.get(panssarit.get(0));
        
        for(int i=1;i<panssarit.size();i++){
            double panssarinVahvuus=asetyypinVahvuudet.get(panssarit.get(i));
            if(panssarinVahvuus<vahvin){
                vahvin=panssarinVahvuus;
            }
        }
        
        return vahvin;
    }
    
    public List<Sotilas> getHyokkaajat() {
        return hyokkaajat;
    }

    public void setHyokkaajat(List<Sotilas> hyokkaajat) {
        this.hyokkaajat = hyokkaajat;
    }

    public List<Sotilas> getPuolustajat() {
        return puolustajat;
    }

    public void setPuolustajat(List<Sotilas> puolustajat) {
        this.puolustajat = puolustajat;
    }
}
