package jek.gameprojects.strategiapelioh.kayttoliittyma.hiiri;

import java.awt.event.MouseEvent;

/**
 * 
 * Rajapinta jonka toteuttavat luokat pystyvät käsittelemään hiiritapahtumia
 * 
 */
public interface HiirenToiminnot {
    
    public void mouseClicked(MouseEvent e);
    
    public void mousePressed(MouseEvent e);

    public void mouseReleased(MouseEvent e);

    public void mouseEntered(MouseEvent e);

    public void mouseExited(MouseEvent e);
    
}
