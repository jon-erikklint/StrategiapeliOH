package jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class PerusNappaimistonKuuntelija implements NappaimistonToiminnot{

    private Map<Integer, NappaimenKuuntelija> typed;
    private Map<Integer, NappaimenKuuntelija> pressed;
    private Map<Integer, NappaimenKuuntelija> released;
    
    public PerusNappaimistonKuuntelija(){
        typed = new HashMap<>();
        pressed = new HashMap<>();
        released = new HashMap<>();
    }
    
    public void lisaaNappaimenKuuntelija(NappaimenKuuntelija kuuntelija, int tapahtumatyyppi){
        Map<Integer, NappaimenKuuntelija> mappi = annaMappiTapahtumatyypilla(tapahtumatyyppi);
        
        if(mappi!=null){
            mappi.put(kuuntelija.merkkikoodi(), kuuntelija);
        }
    }
    
    public void poistaNappaimenKuntelija(NappaimenKuuntelija kuuntelija, int tapahtumatyyppi){
        Map<Integer, NappaimenKuuntelija> mappi = annaMappiTapahtumatyypilla(tapahtumatyyppi);
        
        if(mappi!=null){
            mappi.remove(kuuntelija.merkkikoodi());
        }
    }
    
    private Map<Integer, NappaimenKuuntelija> annaMappiTapahtumatyypilla(int tapahtumatyyppi){
        if(tapahtumatyyppi == 0 ){
            return typed;
        }else if(tapahtumatyyppi == 1){
            return pressed;
        }else if(tapahtumatyyppi == 2){
            return released;
        }
        
        return null;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
