package jek.gameprojects.strategiapelioh.domain.pelaajat;

import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkays;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;

public class Yksikkotyyppi {
    
    private Liikkuvuus liikuntakyky;
    private Hyokkays hyokkays;
    
    public Yksikkotyyppi(Liikkuvuus liikuntakyky, Hyokkays hyokkays) {
        this.liikuntakyky = liikuntakyky;
        this.hyokkays = hyokkays;
        
    }
    
    public Yksikkotyyppi(Liikkuvuus liikuntakyky){
        this.liikuntakyky = liikuntakyky;
        
        hyokkays = new Hyokkays();
    }
    
    public Liikkuvuus getLiikuntakyky() {
        return liikuntakyky;
    }

    public void setLiikuntakyky(Liikkuvuus liikuntakyky) {
        this.liikuntakyky = liikuntakyky;
    }

    public boolean isOnkoHyokkaava() {
        return hyokkays.isOnkoHyokkaava();
    }

    public void setOnkoHyokkaava(boolean onkoHyokkaava) {
        this.hyokkays.setOnkoHyokkaava(onkoHyokkaava);
    }

    public Hyokkays getHyokkays() {
        return hyokkays;
    }

    public void setHyokkays(Hyokkays hyokkays) {
        this.hyokkays = hyokkays;
    }
    
}
