package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Omistettava;

/**
 * 
 * Rajapinnan toteuttavat oliot kykenevät taistelemaan toisia rajapinnan toteuttavuia olioita vastaan
 * 
 */

public interface Hyokkaava extends Omistettava{
    
    public Hyokkays hyokkays();
    
    public double hyokkayskerroin();
    
    public void menetaElamaa(int maara);
    
    public int getElamat();
    
    public int getMaksimiElamat();
    
    public void setElamat(int maara);
    
    public boolean onkoKuollut();
    
    public Koordinaatti getSijainti();
    
    public Ase getAktiivinenAse();
    
    public void setAktiivinenAse(Ase ase);
    
    public int getHyokkaystenMaara();
    
    public void menetaHyokkayksia(int maara);
    
    public boolean voikoHyokata();
    
}
