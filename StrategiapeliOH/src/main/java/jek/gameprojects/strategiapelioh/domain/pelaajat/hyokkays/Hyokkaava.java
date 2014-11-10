package jek.gameprojects.strategiapelioh.domain.pelaajat.hyokkays;

import jek.gameprojects.strategiapelioh.domain.kartta.Koordinaatti;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Omistettava;
import jek.gameprojects.strategiapelioh.domain.pelaajat.Pelaaja;

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
    
    @Override
    public Pelaaja getOmistaja();
    
}
