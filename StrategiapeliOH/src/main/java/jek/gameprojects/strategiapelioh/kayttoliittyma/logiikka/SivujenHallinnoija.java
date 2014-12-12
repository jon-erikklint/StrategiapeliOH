package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.HiirenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.NappaimistonKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.Sivu;

/**
 * 
 * Hallinnoi mitä sivuja ohjelmassa on ja vaihtaa aktiivista pyydettäessä
 * 
 */
public class SivujenHallinnoija {
    
    private List<Sivu> sivut;
    private Sivu nykyinenSivu;
    
    private HiirenKuuntelija hiirenKuuntelija;
    private NappaimistonKuuntelija nappaimistonKuuntelija;

    public SivujenHallinnoija(HiirenKuuntelija hiirenKuuntelija, NappaimistonKuuntelija nappaimistonKuuntelija) {
        sivut = new ArrayList<>();
        
        this.nappaimistonKuuntelija = nappaimistonKuuntelija;
        this.hiirenKuuntelija = hiirenKuuntelija;
    }
    
    /**
     * Luo ensimmäisen sivun ja laittaa sen näkymään
     * 
     * @param ensimmainenSivu 
     */
    public void alusta(Sivu ensimmainenSivu){
        lisaaSivu(ensimmainenSivu);
        vaihdaSivu(0);
    }
    
    /**
     * Asettaa annettua indeksiä vastaavan sivun näkymään ja asettaa sen 
     * hiiren- ja näppäimistön kuuntelijat aktiivisiksi
     * 
     * @param sivunNumero
     * @return onko sallittu indeksi
     */
    public boolean vaihdaSivu(int sivunNumero){
        
        if(sivunNumero<0 || sivunNumero>=sivut.size()){
            return false;
        }
        
        nykyinenSivu = sivut.get(sivunNumero);
        
        hiirenKuuntelija.setHiirenToiminnot(nykyinenSivu.hiirenToiminnot());
        nappaimistonKuuntelija.setNappaimistonToiminnot(nykyinenSivu.nappaimistonToiminnot());
        
        return true;
    }
    
    /**
     * Lisää uuden sivun
     * 
     * @param sivu 
     */
    public void lisaaSivu(Sivu sivu){
        sivut.add(sivu);
    }
    
    /**
     * Poistaa annetun sivun
     * 
     * @param sivu
     */
    public void poistaSivu(Sivu sivu){
        sivut.remove(sivu);
    }
    
    /**
     * Palauttaa olemassaolevien sivujen määrän
     * 
     * @return sivujen määrä
     */
    public int sivujenMaara(){
        return sivut.size();
    }
    
    /**
     * Palauttaa nykyisin aktiivisena olevan sivun
     * 
     * @return aktiivinen sivu
     */
    public Sivu nykyinenSivu(){
        return nykyinenSivu;
    }
}
