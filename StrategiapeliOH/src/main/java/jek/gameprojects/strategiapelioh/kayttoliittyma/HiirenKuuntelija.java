package jek.gameprojects.strategiapelioh.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri.HiirenToiminnot;

public class HiirenKuuntelija implements MouseListener{

    private HiirenToiminnot hiirenToiminnot;

    public HiirenToiminnot getHiirenToiminnot() {
        return hiirenToiminnot;
    }

    public void setHiirenToiminnot(HiirenToiminnot hiirenToiminnot) {
        this.hiirenToiminnot = hiirenToiminnot;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        hiirenToiminnot.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        hiirenToiminnot.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        hiirenToiminnot.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hiirenToiminnot.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hiirenToiminnot.mouseExited(e);
    }
    
}
