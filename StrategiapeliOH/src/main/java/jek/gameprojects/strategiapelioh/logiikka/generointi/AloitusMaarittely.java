package jek.gameprojects.strategiapelioh.logiikka.generointi;

import jek.gameprojects.strategiapelioh.logiikka.generointi.yksikkotyypit.YksikkotyyppienAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.generointi.yksikot.YksikoidenAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.generointi.aseet.PanssarivahvuuksienAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.generointi.pelaajat.PelaajienAlustaja;
import jek.gameprojects.strategiapelioh.logiikka.generointi.kartta.KartanAlustaja;
import java.util.List;

public class AloitusMaarittely {
    
    private PelaajienAlustaja pelaajienAlustaja;
    private YksikkotyyppienAlustaja yksikkotyyppienAlustaja;
    private KartanAlustaja kartanAlustaja;
    private YksikoidenAlustaja yksikoidenAlustaja;
    private PanssarivahvuuksienAlustaja panssarivahvuuksienAlustaja;
    
    private List<String> pelaajienNimet;

    public PelaajienAlustaja getPelaajienAlustaja() {
        return pelaajienAlustaja;
    }

    public void setPelaajienAlustaja(PelaajienAlustaja pelaajienAlustaja) {
        this.pelaajienAlustaja = pelaajienAlustaja;
    }

    public YksikkotyyppienAlustaja getYksikkotyyppienAlustaja() {
        return yksikkotyyppienAlustaja;
    }

    public void setYksikkotyyppienAlustaja(YksikkotyyppienAlustaja yksikkotyyppienAlustaja) {
        this.yksikkotyyppienAlustaja = yksikkotyyppienAlustaja;
    }

    public KartanAlustaja getKartanAlustaja() {
        return kartanAlustaja;
    }

    public void setKartanAlustaja(KartanAlustaja kartanAlustaja) {
        this.kartanAlustaja = kartanAlustaja;
    }

    public YksikoidenAlustaja getYksikoidenAlustaja() {
        return yksikoidenAlustaja;
    }

    public void setYksikoidenAlustaja(YksikoidenAlustaja yksikoidenAlustaja) {
        this.yksikoidenAlustaja = yksikoidenAlustaja;
    }

    public PanssarivahvuuksienAlustaja getPanssarivahvuuksienAlustaja() {
        return panssarivahvuuksienAlustaja;
    }

    public void setPanssarivahvuuksienAlustaja(PanssarivahvuuksienAlustaja panssarivahvuuksienAlustaja) {
        this.panssarivahvuuksienAlustaja = panssarivahvuuksienAlustaja;
    }

    public List<String> getPelaajienNimet() {
        return pelaajienNimet;
    }

    public void setPelaajienNimet(List<String> pelaajienNimet) {
        this.pelaajienNimet = pelaajienNimet;
    }
    
    
    
}
