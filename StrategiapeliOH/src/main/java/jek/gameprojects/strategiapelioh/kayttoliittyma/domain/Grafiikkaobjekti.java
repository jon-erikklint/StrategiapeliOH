package jek.gameprojects.strategiapelioh.kayttoliittyma.domain;

import java.awt.Graphics2D;

public interface Grafiikkaobjekti {
    
    public Vektori sijainti();
    public Vektori koko();
    
    public void paint(Graphics2D g);
    
}
