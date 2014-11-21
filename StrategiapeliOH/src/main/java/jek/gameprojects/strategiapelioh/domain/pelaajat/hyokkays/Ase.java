package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

/**
 * 
 * Sisältää tiedon aseen ominaisuuksista
 * 
 */

public class Ase {
    
    private int isku;
    private Asetyyppi asetyyppi;
    private double tarkkuus;

    public Ase(int isku, Asetyyppi asetyyppi, double tarkkuus) {
        this.isku = isku;
        this.asetyyppi = asetyyppi;
        this.tarkkuus = tarkkuus;
    }
    
    public double getTarkkuus() {
        return tarkkuus;
    }

    public void setTarkkuus(double tarkkuus) {
        this.tarkkuus = tarkkuus;
    }
    
    public int getIsku() {
        return isku;
    }

    public void setIsku(int isku) {
        this.isku = isku;
    }

    public Asetyyppi getAsetyyppi() {
        return asetyyppi;
    }

    public void setAsetyyppi(Asetyyppi asetyyppi) {
        this.asetyyppi = asetyyppi;
    }
    
    
}
