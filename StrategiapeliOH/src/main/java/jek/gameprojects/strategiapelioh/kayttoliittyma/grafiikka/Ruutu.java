package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;


public interface Ruutu {
    
    public HiirenToiminnot hiirenToiminnot();
    
    public NappaimistonToiminnot nappaimistonToiminnot();
    
    public void paivita();
    
    public void paint(Graphics2D g);
    
}
