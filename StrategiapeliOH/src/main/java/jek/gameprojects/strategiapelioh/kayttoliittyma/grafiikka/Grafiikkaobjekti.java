package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Tasollinen;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public interface Grafiikkaobjekti extends Tasollinen{
    
    public Vektori sijainti();
    public Vektori koko();
    
    public void paint(Graphics2D g, Kamera kamera);
    
}
