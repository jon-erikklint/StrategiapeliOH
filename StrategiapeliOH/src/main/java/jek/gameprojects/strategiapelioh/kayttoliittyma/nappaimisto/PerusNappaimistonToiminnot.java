package jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class PerusNappaimistonToiminnot implements NappaimistonToiminnot{

    private Map<Integer, NappaimenKuuntelija> typed;
    private Map<Integer, NappaimenKuuntelija> pressed;
    private Map<Integer, NappaimenKuuntelija> released;
    
    public PerusNappaimistonToiminnot(){
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
    
    private void haluttuKuuntelijaToimii(int tapahtumatyyppi, int keycode){
        NappaimenKuuntelija haluttuKuuntelija = annaMappiTapahtumatyypilla(tapahtumatyyppi).get(keycode);
        if(haluttuKuuntelija != null){
            haluttuKuuntelija.toimi();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        haluttuKuuntelijaToimii(0, e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        haluttuKuuntelijaToimii(1, e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        haluttuKuuntelijaToimii(2, e.getKeyCode());
    }
    
}
