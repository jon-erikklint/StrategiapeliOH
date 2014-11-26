package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;

public class NappaimistonKuuntelija implements KeyListener{

    private NappaimistonToiminnot nappaimistonToiminnot;

    public NappaimistonToiminnot getNappaimistonToiminnot() {
        return nappaimistonToiminnot;
    }

    public void setNappaimistonToiminnot(NappaimistonToiminnot nappaimistonToiminnot) {
        this.nappaimistonToiminnot = nappaimistonToiminnot;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        nappaimistonToiminnot.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        nappaimistonToiminnot.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        nappaimistonToiminnot.keyReleased(e);
    }
    
}
