package jek.gameprojects.strategiapelioh.domain.pelaajat;

import jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays.Hyokkays;
import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;

public class Yksikkotyyppi {
    
    private int liikkuvuus;
    private boolean onkoHyokkaava;
    
    private Liikkuvuus liikuntakyky;
    private Hyokkays hyokkays;
    
    public Yksikkotyyppi(int liikkuvuus, Liikkuvuus liikuntakyky, Hyokkays hyokkays) {
        this.liikkuvuus = liikkuvuus;
        this.liikuntakyky = liikuntakyky;
        this.hyokkays = hyokkays;
        
        onkoHyokkaava=true;
    }
    
    public Yksikkotyyppi(int liikkuvuus, Liikkuvuus liikuntakyky){
        this.liikkuvuus = liikkuvuus;
        this.liikuntakyky = liikuntakyky;
        
        hyokkays = new Hyokkays(0, false);
        
        onkoHyokkaava = false;
    }
    
    public int getLiikkuvuus() {
        return liikkuvuus;
    }

    public void setLiikkuvuus(int liikkuvuus) {
        this.liikkuvuus = liikkuvuus;
    }

    public Liikkuvuus getLiikuntakyky() {
        return liikuntakyky;
    }

    public void setLiikuntakyky(Liikkuvuus liikuntakyky) {
        this.liikuntakyky = liikuntakyky;
    }

    public boolean isOnkoHyokkaava() {
        return onkoHyokkaava;
    }

    public void setOnkoHyokkaava(boolean onkoHyokkaava) {
        this.onkoHyokkaava = onkoHyokkaava;
    }

    public Hyokkays getHyokkays() {
        return hyokkays;
    }

    public void setHyokkays(Hyokkays hyokkays) {
        this.hyokkays = hyokkays;
    }
    
}
