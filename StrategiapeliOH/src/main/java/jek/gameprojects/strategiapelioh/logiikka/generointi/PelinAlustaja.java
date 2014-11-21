package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.List;
import java.util.Map;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Asetyyppi;
import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Panssarityyppi;
import jek.gameprojects.strategiapelioh.logiikka.Peli;
import jek.gameprojects.strategiapelioh.logiikka.Indeksoija;

public class PelinAlustaja {
    
    private PelaajienAlustaja pelaajienAlustaja;
    private YksikkotyyppienAlustaja yksikkotyyppienAlustaja;
    private KartanAlustaja kartanAlustaja;
    private YksikoidenAlustaja yksikoidenAlustaja;
    private PanssarivahvuuksienAlustaja panssarivahvuuksienAlustaja;
    
    private List<String> pelaajienNimet;

    public PelinAlustaja(PelaajienAlustaja pelaajienAlustaja, YksikkotyyppienAlustaja yksikkotyyppienAlustaja, 
            KartanAlustaja kartanAlustaja, List<String> pelaajienNimet, YksikoidenAlustaja yksikoidenAlustaja, 
            PanssarivahvuuksienAlustaja panssarivahvuuksienAlustaja) {
        
        this.pelaajienAlustaja = pelaajienAlustaja;
        this.yksikkotyyppienAlustaja = yksikkotyyppienAlustaja;
        this.kartanAlustaja = kartanAlustaja;
        this.yksikoidenAlustaja = yksikoidenAlustaja;
        this.panssarivahvuuksienAlustaja = panssarivahvuuksienAlustaja;
    }
    
    public Peli alustaPeli()throws Exception{
        
        Map<Asetyyppi, Map<Panssarityyppi, Double>> panssarityyppienVahvuudet = panssarivahvuuksienAlustaja.panssarityyppienVahvuudet();
        
        Map<Integer, Pelaaja> pelaajat = pelaajienAlustaja.alustaPelaajat(pelaajienNimet);
        Map<String, Yksikkotyyppi> yksikkotyypit = yksikkotyyppienAlustaja.alustaYksikkotyypit();
        Kartta kartta = kartanAlustaja.alustaKartta();
        
        Indeksoija yksikoidenIndeksoija = new Indeksoija(0);
        yksikoidenAlustaja.alustaYksikot(kartta, pelaajat, yksikkotyypit, yksikoidenIndeksoija);
        
        return new Peli(pelaajat, kartta, yksikkotyypit, yksikoidenIndeksoija, panssarityyppienVahvuudet);
    }
    
}
