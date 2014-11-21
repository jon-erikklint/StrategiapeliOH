package jek.gameprojects.strategiapelioh.domain.kartta.maasto;

/**
 * 
 * Sisaltaa tiedon yhden ruudun maasto-ominaisuuksista
 * 
 */

public class Maasto {
    
    private Aluetyyppi aluetyyppi;
    private Maastotyyppi maastotyyppi;
    private int korkeus;

    public Maasto(Aluetyyppi aluetyyppi, Maastotyyppi maastotyyppi, int korkeus) {
        this.aluetyyppi = aluetyyppi;
        this.maastotyyppi = maastotyyppi;
        this.korkeus = korkeus;
    }

    public Aluetyyppi getAluetyyppi() {
        return aluetyyppi;
    }

    public void setAluetyyppi(Aluetyyppi aluetyyppi) {
        this.aluetyyppi = aluetyyppi;
    }

    public Maastotyyppi getMaastotyyppi() {
        return maastotyyppi;
    }

    public void setMaastotyyppi(Maastotyyppi maastotyyppi) {
        this.maastotyyppi = maastotyyppi;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }
    
    
}
