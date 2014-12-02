package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Nakyva;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public interface Grafiikkaobjekti extends Nakyva{
    
    public Vektori sijainti();
    public Vektori koko();
    public int getTaso();
    
    public void paint(Graphics2D g, Kamera kamera);
    
}
