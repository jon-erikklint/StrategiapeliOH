package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import java.awt.Graphics2D;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;

public interface Grafiikkaobjekti extends Nakyva{
    
    public Vektori getSijainti();
    public void setSijainti(Vektori sijainti);
    
    public Vektori getKoko();
    public void setKoko(Vektori koko);
    
    public void paint(Graphics2D g, Kamera kamera);
    
}
