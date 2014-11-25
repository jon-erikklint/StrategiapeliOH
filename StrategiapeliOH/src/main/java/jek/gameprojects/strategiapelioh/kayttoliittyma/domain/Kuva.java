package jek.gameprojects.strategiapelioh.kayttoliittyma.domain;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Kuva implements Grafiikkaobjekti{

    private BufferedImage image;
    
    private Vektori sijainti;
    private Vektori koko;
    
    private double kulma;

    public Kuva(BufferedImage image, Vektori sijainti, Vektori koko, double kulma) {
        this.image = image;
        this.sijainti = sijainti;
        this.koko = koko;
        this.kulma = kulma;
    }
    
    @Override
    public void paint(Graphics2D g) {
        
    }

    @Override
    public Vektori sijainti() {
        return sijainti;
    }

    @Override
    public Vektori koko() {
        return koko;
    }
    
    public Image getImage() {
        return image;
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

    public void setSijainti(Vektori sijainti) {
        this.sijainti = sijainti;
    }

    public void setKoko(Vektori koko) {
        this.koko = koko;
    }
    
}
