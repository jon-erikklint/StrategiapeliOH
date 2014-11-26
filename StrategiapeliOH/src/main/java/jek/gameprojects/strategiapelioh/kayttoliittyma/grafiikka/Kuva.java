package jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka;

import jek.gameprojects.strategiapelioh.kayttoliittyma.grafiikka.Grafiikkaobjekti;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Vektori;
import jek.gameprojects.strategiapelioh.kayttoliittyma.logiikka.Grafiikkalaskuri;

public class Kuva implements Grafiikkaobjekti{

    private BufferedImage image;
    
    private Vektori sijainti;
    private Vektori koko;
    
    private double kulma;
    
    private int taso;

    public Kuva(BufferedImage image, Vektori sijainti, Vektori koko, double kulma, int taso) {
        this.image = image;
        this.sijainti = sijainti;
        this.koko = koko;
        this.kulma = kulma;
        
        this.taso = taso;
    }
    
    @Override
    public void paint(Graphics2D g) {
        Vektori[] kulmat = Grafiikkalaskuri.kaannaNelio(sijainti, koko, kulma);
        
        g.drawImage(image, (int) kulmat[0].getX(), (int) kulmat[0].getY(), (int) kulmat[1].getX(), (int) kulmat[1].getY(), 
                (int) kulmat[2].getX(), (int) kulmat[2].getY(), (int) kulmat[3].getX(), (int) kulmat[3].getY(), null);
    }

    @Override
    public Vektori sijainti() {
        return sijainti;
    }

    @Override
    public Vektori koko() {
        return koko;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public double getKulma() {
        return kulma;
    }

    public void setKulma(double kulma) {
        this.kulma = kulma;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Vektori getSijainti() {
        return sijainti;
    }

    public Vektori getKoko() {
        return koko;
    }

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    public void setKoko(Vektori koko) {
        this.koko = koko;
    }

    @Override
    public int getTaso() {
        return taso;
    }
    
}
