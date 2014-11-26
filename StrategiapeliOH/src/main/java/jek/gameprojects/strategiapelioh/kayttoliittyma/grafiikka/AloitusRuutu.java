package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics;
import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;
import jek.gameprojects.strategiapelioh.kayttoliittyma.nappaimisto.NappaimistonToiminnot;

public class AloitusRuutu implements Ruutu{

    private HiirenToiminnot hiirenToiminnot;
    private NappaimistonToiminnot nappaimistonToiminnot;
    
    public AloitusRuutu(){
        
    }
    
    @Override
    public void paivita() {}

    @Override
    public void paint(Graphics2D g) {
        
    }

    @Override
    public HiirenToiminnot hiirenToiminnot() {
        return hiirenToiminnot;
    }

    @Override
    public NappaimistonToiminnot nappaimistonToiminnot() {
        return nappaimistonToiminnot;
    }
    
}
