package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.HiirenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.NappaimistonKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.sivut.Sivu;

public class SivujenHallinnoija {
    
    private List<Sivu> sivut;
    private Sivu nykyinenSivu;
    
    private HiirenKuuntelija hiirenKuuntelija;
    private NappaimistonKuuntelija nappaimistonKuuntelija;

    public SivujenHallinnoija(List<Sivu> sivut, int aloitusSivu, HiirenKuuntelija hiirenKuuntelija, NappaimistonKuuntelija nappaimistonKuuntelija) {
        this.sivut = sivut;
        this.nykyinenSivu = sivut.get(aloitusSivu);
        this.hiirenKuuntelija = hiirenKuuntelija;
        this.nappaimistonKuuntelija = nappaimistonKuuntelija;
        
        hiirenKuuntelija.setHiirenToiminnot(nykyinenSivu.hiirenToiminnot());
        nappaimistonKuuntelija.setNappaimistonToiminnot(nykyinenSivu.nappaimistonToiminnot());
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
