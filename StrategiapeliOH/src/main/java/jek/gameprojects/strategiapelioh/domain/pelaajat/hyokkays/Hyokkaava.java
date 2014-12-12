package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Omistettava;

/**
 * 
 * Rajapinnan toteuttavat oliot kykenevät taistelemaan toisia rajapinnan toteuttavuia olioita vastaan
 * 
 */

public interface Hyokkaava extends Omistettava{
    
    /**
     * Palauttaa tietopaketin hyökkäävän hyökkäämiseen liittyvistä tiedoista
     * 
     * @return hyökkäys
     */
    public Hyokkays hyokkays();
    
    /**
     * Kertoo kertoimen kuinka paljon damagea hyökkäävä tekee normaaliin verrattuna elämäpisteidensä perusteella.
     * 
     * @return kerroin tiastellessa
     */
    public double elamakerroin();
    
    /**
     * Laittaa hyökkäävän menettämään elämäpisteitä annetun määrän
     * 
     * @param maara 
     */
    public void menetaElamaa(int maara);
    
    /**
     * Palauttaa hyökkäävän tämänhetkiset elämäpisteet
     * 
     * @return elämäpisteiden määrä
     */
    public int getElamat();
    
    /**
     * Palauttaa paljonko elämäpisteitä hyökkäävällä voi olla maksimissaan
     * 
     * @return maksimi elämäpisteet
     */
    public int getMaksimiElamat();
    
    /**
     * Asettaa elämäpisteet tiettyyn arvoon
     * 
     * @param maara 
     */
    public void setElamat(int maara);
    
    /**
     * Palauttaa tiedon siitä onko hyökkäävä kuollut
     * 
     * @return onko kuollut
     */
    public boolean onkoKuollut();
    
    /**
     * Palauttaa hyökkäävän tämänhetkisen sijainnin
     * 
     * @return sijainti
     */
    public Koordinaatti getSijainti();
    
    /**
     * Palauttaa hyökkäävän tällä hetkellä käyttämän aseen
     * 
     * @return käytössä oleva ase
     */
    public Ase getAktiivinenAse();
    
    /**
     * Asettaa yksikön käyttöön annetun aseen
     * 
     * @param ase 
     */
    public void setAktiivinenAse(Ase ase);
    
    /**
     * Kertoo montako kertaa yksikkö voi hyökätä vielä tällä vuorolla
     * 
     * @return hyökkäysten määrä
     */
    public int getHyokkaystenMaara();
    
    /**
     * Poistaa hyökkäävältä annetun määrän hyökkäyksiä tältä vuorolta
     * 
     * @param maara 
     */
    public void menetaHyokkayksia(int maara);
    
    /**
     * Kertoo voiko yksikkö hyökätä vielä tällä vuorolla
     * 
     * @return voiko hyökätä
     */
    public boolean voikoHyokata();
    
}
