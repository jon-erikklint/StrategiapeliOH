package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.domain.kartta.Ruutu;
import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.ObjectKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Tilat;

public class AktivoiRuutu extends PelitilaEfekti{
    
    private ObjectKuva<Ruutu> ruutuKuva;
    
    public AktivoiRuutu(Pelitila pelitila, ObjectKuva<Ruutu> ruutuKuva) {
        super(pelitila);
        
        this.ruutuKuva = ruutuKuva;
    }

    @Override
    public void toimi() {
        Tilat tilat = pelitila.getTilat();
        
        if(tilat.getValittuRuutu()==null){
            
            if(varmistaRuudunKelpoisuusValittavaksi()){
                valitseRuutu(tilat);
            }
            
            
        }else if(!tilat.getValittuRuutu().equals(ruutuKuva)){
            
            if(varmistaRuudunKelpoisuusValittavaksi()){
                
                valitseRuutu(tilat);
                tilat.getValittuRuutu().paivita();
            
            }
            
        }else{
            
            tilat.getValittuRuutu().paivita();
            tilat.nollaaTilanne();
            
        }
    }
    
    public boolean varmistaRuudunKelpoisuusValittavaksi(){
//        if(ruutuKuva.getT().getJoukot().isEmpty()){
//            return false;
//        }
//        
//        return pelitila.getPeli().getVuoro().getPelaaja().equals(ruutuKuva.getT().kenenHallussa());
        
        return true;
    }
    
    public void valitseRuutu(Tilat tilat){
        
        tilat.setValittuRuutu(ruutuKuva);
        tilat.setValitutYksikot(ruutuKuva.getT().annaEnsimmainenJoukko());
            
        ruutuKuva.setImage(KuvaSailio.getKuva( ruutuKuva.getT().toString()+":AKTIIVINEN") );
    }
    
}
