package jek.gameprojects.strategiapelioh.logiikka.generointi;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.domain.kartta.Kartta;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Yksikkotyyppi;
import jek.gameprojects.strategiapelioh.domain.peli.Peli;

public class PelinAlustaja {
    
    private PelaajienAlustaja pelaajienAlustaja;
    private PelitietojenAlustaja yksikkotyyppienAlustaja;
    private KartanAlustaja kartanAlustaja;
    
    private List<String> pelaajienNimet;

    public PelinAlustaja(PelaajienAlustaja pelaajienAlustaja, PelitietojenAlustaja yksikkotyyppienAlustaja, KartanAlustaja kartanAlustaja, List<String> pelaajienNimet) {
        this.pelaajienAlustaja = pelaajienAlustaja;
        this.yksikkotyyppienAlustaja = yksikkotyyppienAlustaja;
        this.kartanAlustaja = kartanAlustaja;
    }
    
    public Peli alustaPeli()throws Exception{
        
        List<Pelaaja> pelaajat = pelaajienAlustaja.alustaPelaajat(pelaajienNimet);
        List<Yksikkotyyppi> yksikkotyypit = yksikkotyyppienAlustaja.alustaYksikkotyypit();
        Kartta kartta = kartanAlustaja.alustaKartta();
        
        return new Peli(pelaajat, kartta, yksikkotyypit);
    }
    
}
