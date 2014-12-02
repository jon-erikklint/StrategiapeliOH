package jek.gameprojects.strategiapelioh.kayttoliittyma.sivut;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Paivittyva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;


public interface Sivu extends Paivittyva{
    
    public HiirenToiminnot hiirenToiminnot();
    
    public NappaimistonToiminnot nappaimistonToiminnot();
    
    public void paint(Graphics2D g);
    
}
