package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

/**
 * 
 * Sisältää tiedon panssarin tiedoista
 * 
 */

public class Panssari {
    
    private double panssarinVahvuus;
    private Panssarityyppi panssarityyppi;

    public Panssari(double panssarinVahvuus, Panssarityyppi panssarityyppi) {
        this.panssarinVahvuus = panssarinVahvuus;
        this.panssarityyppi = panssarityyppi;
    }
    
    public double getPanssarinVahvuus() {
        return panssarinVahvuus;
    }

    public void setPanssarinVahvuus(double panssarinVahvuus) {
        this.panssarinVahvuus = panssarinVahvuus;
    }

    public Panssarityyppi getPanssarityyppi() {
        return panssarityyppi;
    }

    public void setPanssarityyppi(Panssarityyppi panssarityyppi) {
        this.panssarityyppi = panssarityyppi;
    }
    
    
}
