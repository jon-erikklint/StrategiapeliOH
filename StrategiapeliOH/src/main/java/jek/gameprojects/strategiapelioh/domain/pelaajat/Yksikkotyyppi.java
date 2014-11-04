package jek.gameprojects.strategiapelioh.domain.pelaajat;

import jek.gameprojects.strategiapelioh.domain.pelaajat.liikkuminen.Liikkuvuus;

public class Yksikkotyyppi {
    
    private int liikkuvuus;
    private Liikkuvuus liikuntakyky;
    
    public Yksikkotyyppi(int liikkuvuus, Liikkuvuus liikuntakyky) {
        this.liikkuvuus = liikkuvuus;
        this.liikuntakyky = liikuntakyky;
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

    
    
    
}
