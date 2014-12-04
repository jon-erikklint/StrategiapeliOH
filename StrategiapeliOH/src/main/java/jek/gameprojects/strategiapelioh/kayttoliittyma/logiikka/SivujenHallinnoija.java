package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.util.ArrayList;
import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.HiirenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.NappaimistonKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.Sivu;

public class SivujenHallinnoija {
    
    private List<Sivu> sivut;
    private Sivu nykyinenSivu;
    
    private HiirenKuuntelija hiirenKuuntelija;
    private NappaimistonKuuntelija nappaimistonKuuntelija;

    public SivujenHallinnoija(HiirenKuuntelija hiirenKuuntelija, NappaimistonKuuntelija nappaimistonKuuntelija) {
        this.hiirenKuuntelija = hiirenKuuntelija;
        this.nappaimistonKuuntelija = nappaimistonKuuntelija;
        
        sivut = new ArrayList<>();
    }
    
    public void alusta(Sivu ensimmainenSivu){
        lisaaSivu(ensimmainenSivu);
        vaihdaSivu(0);
    }
    
    public boolean vaihdaSivu(int sivunNumero){
        
        if(sivunNumero<0 || sivunNumero>=sivut.size()){
            return false;
        }
        
        nykyinenSivu = sivut.get(sivunNumero);
        
        hiirenKuuntelija.setHiirenToiminnot(nykyinenSivu.hiirenToiminnot());
        nappaimistonKuuntelija.setNappaimistonToiminnot(nykyinenSivu.nappaimistonToiminnot());
        
        return true;
    }
    
    public void lisaaSivu(Sivu ruutu){
        sivut.add(ruutu);
    }
    
    public boolean poistaSivu(Sivu ruutu){
        return sivut.remove(ruutu);
    }
    
    public int sivujenMaara(){
        return sivut.size();
    }
    
    public Sivu nykyinenSivu(){
        return nykyinenSivu;
    }
}
