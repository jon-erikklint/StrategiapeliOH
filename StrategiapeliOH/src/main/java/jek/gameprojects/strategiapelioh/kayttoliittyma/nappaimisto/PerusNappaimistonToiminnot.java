package jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class PerusNappaimistonToiminnot implements NappaimistonToiminnot{

    private Map<Integer, NappaimenKuuntelija> kuuntelijat;
    
    public PerusNappaimistonToiminnot(){
        kuuntelijat = new HashMap<>();
    }
    
    public void lisaaNappaimenKuuntelija(NappaimenKuuntelija kuuntelija){
        kuuntelijat.put(kuuntelija.merkkikoodi(), kuuntelija);
    }
    
    public void poistaNappaimenKuntelija(NappaimenKuuntelija kuuntelija, int tapahtumatyyppi){
        kuuntelijat.remove(kuuntelija.merkkikoodi());
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        NappaimenKuuntelija kuuntelija = kuuntelijat.get(e.getExtendedKeyCode());
        if( kuuntelija!=null ){
            kuuntelija.toimi();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
