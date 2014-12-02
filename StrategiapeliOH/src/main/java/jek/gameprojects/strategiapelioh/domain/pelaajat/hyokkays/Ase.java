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
    
    private int kantama;
    private boolean kaukotaistelu;

    public Ase(int isku, Asetyyppi asetyyppi, double tarkkuus, int kantama, boolean kaukotaistelu) {
        this.isku = isku;
        this.asetyyppi = asetyyppi;
        this.tarkkuus = tarkkuus;
        
        this.kantama = kantama;
        this.kaukotaistelu = kaukotaistelu;
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

    public int getKantama() {
        return kantama;
    }

    public void setKantama(int kantama) {
        this.kantama = kantama;
    }

    public boolean isKaukotaistelu() {
        return kaukotaistelu;
    }

    public void setKaukotaistelu(boolean kaukotaistelu) {
        this.kaukotaistelu = kaukotaistelu;
    }
    
}
