package jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka;

import java.util.List;
import jek.gameprojects.strategiapelioh.kayttoliittyma.HiirenKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.NappaimistonKuuntelija;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Sisalto;

public class RuutujenHallinnoija {
    
    private List<Sisalto> ruudut;
    private Sisalto nykyinenRuutu;
    
    private HiirenKuuntelija hiirenKuuntelija;
    private NappaimistonKuuntelija nappaimistonKuuntelija;

    public RuutujenHallinnoija(List<Sisalto> ruudut, int nykyinenRuutu, HiirenKuuntelija hiirenKuuntelija, NappaimistonKuuntelija nappaimistonKuuntelija) {
        this.ruudut = ruudut;
        this.nykyinenRuutu = ruudut.get(nykyinenRuutu);
        this.hiirenKuuntelija = hiirenKuuntelija;
        this.nappaimistonKuuntelija = nappaimistonKuuntelija;
    }
    
    public boolean vaihdaRuutu(int ruudunNumero){
        
        if(ruudunNumero<0 || ruudunNumero>=ruudut.size()){
            return false;
        }
        
        nykyinenRuutu = ruudut.get(ruudunNumero);
        
        hiirenKuuntelija.setHiirenToiminnot(nykyinenRuutu.hiirenToiminnot());
        nappaimistonKuuntelija.setNappaimistonToiminnot(nykyinenRuutu.nappaimistonToiminnot());
        
        return true;
    }
    
    public void lisaaRuutu(Sisalto ruutu){
        ruudut.add(ruutu);
    }
    
    public boolean poistaRuutu(Sisalto ruutu){
        return ruudut.remove(ruutu);
    }
    
    public int ruutujenMaara(){
        return ruudut.size();
    }
    
    public Sisalto nykyinenRuutu(){
        return nykyinenRuutu;
    }
}
