package jek.gameprojects.strategiapelioh.kayttoliittyma.efekti;

import jek.gameprojects.strategiapelioh.kayttoliittyma.KuvaSailio;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.RuudunKuva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.YksikoidenKuvakkeet;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Tilat;

public class AktivoiRuutu extends PelitilaEfekti{
    
    private RuudunKuva ruutuKuva;
    
    public AktivoiRuutu(Pelitila pelitila, RuudunKuva ruutuKuva) {
        super(pelitila);
        
        this.ruutuKuva = ruutuKuva;
    }

    @Override
    public void toimi() {
        Tilat tilat = pelitila.getTilat();
        RuudunKuva valittuRuutu = tilat.getValittuRuutu();
        
        if(valittuRuutu == null){
            
            if(varmistaRuudunKelpoisuusValittavaksi()){
                valitseRuutu(tilat);
            }
            
            
        }else if(!valittuRuutu.equals(ruutuKuva)){
            
            poistaValinta();
            
            if(varmistaRuudunKelpoisuusValittavaksi()){    
                valitseRuutu(tilat);
            }
            

            
        }else{
            
            poistaValinta();
            
        }
    }
    
    public void poistaValinta(){
        pelitila.tyhjennaValinnat();
    }
    
    public boolean varmistaRuudunKelpoisuusValittavaksi(){
        
        if(ruutuKuva.getRuutu().getJoukot().isEmpty()){
            return false;
        }
        
        return pelitila.getPeli().getVuoro().getPelaaja().equals(ruutuKuva.getRuutu().kenenHallussa());
    }
    
    public void valitseRuutu(Tilat tilat){
        
        tilat.setValittuRuutu(ruutuKuva);
        tilat.setValitutYksikot(ruutuKuva.getRuutu().annaEnsimmainenJoukko());
            
        ruutuKuva.getObjectKuvaRuutu().setImage(KuvaSailio.getKuva( ruutuKuva.getRuutu().toString()+":AKTIIVINEN") );
        
        pelitila.getKayttoliittyma().setYksikoidenKuvakkeet(luoYksikoidenKuvakkeet());
    }
    
    public YksikoidenKuvakkeet luoYksikoidenKuvakkeet(){
        YksikoidenKuvakkeet uudet = new YksikoidenKuvakkeet();
        uudet.alustaKuvakkeet(ruutuKuva.getRuutu().getYksikot(), pelitila.getPainikkeidenKuuntelija().getPainikkeidenKuuntelija(0), pelitila);
        
        return uudet;
    }
    
}
