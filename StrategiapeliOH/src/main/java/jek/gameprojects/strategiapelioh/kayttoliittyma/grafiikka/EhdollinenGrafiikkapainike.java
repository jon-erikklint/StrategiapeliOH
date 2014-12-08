package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.tilat.Pelitila;
import jek.gameprojects.strategiapelioh.kayttoliittyma.painikkeet.Painike;

public class EhdollinenGrafiikkapainike extends Grafiikkapainike{

    private Pelitila pelitila;
    
    public EhdollinenGrafiikkapainike(Painike painike, Grafiikkaobjekti grafiikkaobjekti, Pelitila pelitila) {
        super(painike, grafiikkaobjekti);
        
        this.pelitila = pelitila;
    }
    
    @Override
    public void paivita(){
        if(pelitila.getTilat().getValittuRuutu()==null){
            super.setNakyvyys(false);
        }else{
            super.setNakyvyys(true);
        }
    }
    
    @Override
    public void toimi(){
        if(super.getPainike().getNakyvyys()){
            super.toimi();
        }
    }
    
}
