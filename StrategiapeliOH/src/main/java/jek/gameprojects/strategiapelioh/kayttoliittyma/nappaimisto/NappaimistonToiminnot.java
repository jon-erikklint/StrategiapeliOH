package jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto;

import java.awt.event.KeyEvent;

/**
 * 
 * Rajapinta, jonka toteuttavat luokat pystyvät käsittelemään näppäimistön tapahtumia
 * 
 */
public interface NappaimistonToiminnot {
    
    public void keyTyped(KeyEvent e);

    public void keyPressed(KeyEvent e);

    public void keyReleased(KeyEvent e);
    
}
