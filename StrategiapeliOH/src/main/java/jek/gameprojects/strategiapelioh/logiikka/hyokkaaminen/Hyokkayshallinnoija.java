package jek.gameprojects.strategiapelioh.logiikka.hyokkaaminen;

import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.logiikka.yksikot.JoukkojenHallinnoija;

public class Hyokkayshallinnoija {
    
    private KantamanLaskija kantamanLaskija;
    private Taistelulaskuri taistelulaskuri;
    
    private JoukkojenHallinnoija joukkojenHallinnoija;
    
    public Hyokkayshallinnoija(Kartta kartta, Map<Asetyyppi, Map<Panssarityyppi,Double>> panssarienVahvuudet){
        this.kantamanLaskija = new KantamanLaskija(kartta);
        this.taistelulaskuri = new Taistelulaskuri(panssarienVahvuudet);
        
        joukkojenHallinnoija = new JoukkojenHallinnoija();
    }
    
    
}
