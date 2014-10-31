package jek.gameprojects.strategiapelioh.domain.pelaajat;

import jek.gameprojects.strategiapelioh.domain.Liikuntakyky;

public class Yksikkotyyppi {
    
    private int liikkuvuus;
    private Liikuntakyky liikuntakyky;
    
    public Yksikkotyyppi(int liikkuvuus, Liikuntakyky liikuntakyky) {
        this.liikkuvuus = liikkuvuus;
        this.liikuntakyky = liikuntakyky;
    }
    
    public int getLiikkuvuus() {
        return liikkuvuus;
    }

    public void setLiikkuvuus(int liikkuvuus) {
        this.liikkuvuus = liikkuvuus;
    }

    public Liikuntakyky getLiikuntakyky() {
        return liikuntakyky;
    }

    public void setLiikuntakyky(Liikuntakyky liikuntakyky) {
        this.liikuntakyky = liikuntakyky;
    }

    
    
    
}
